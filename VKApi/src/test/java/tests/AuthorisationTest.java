package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.response.VkInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import utils.ApiUtils;
import utils.ParseUtils;
import utils.RandomGenerator;

import java.util.HashMap;

import static constants.CredentialConstants.LOGIN;
import static constants.CredentialConstants.PASSWORD;
import static constants.IndexConstants.EXPECTED_LENGTH;
import static constants.IndexConstants.LIKES_COUNT;
import static constants.IndexConstants.NEW_POST_INDEX;
import static constants.PathConstants.CONFIG_FILE_PATH;
import static constants.PathConstants.REQUEST_URL_PATH;

public class AuthorisationTest extends BaseTest {

    public static final String USER_ID = ParseUtils.parseFromJson("user_id");
    public static final String USER_NAME = ParseUtils.parseFromJson("user_name");

    @BeforeTest
    public void beforeVkApiTest() {
        RestAssured.baseURI = ParseUtils.parseFromJson("BASE_URI", CONFIG_FILE_PATH);
    }

    @Test
    public void vkApiTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.insertLogin(LOGIN);
        loginPage.submitLogin();
        Assert.assertTrue(loginPage.checkLoginInput(), "login form is not displayed");
        loginPage.insertPassword(PASSWORD);
        loginPage.submitPassword();
        Assert.assertTrue(loginPage.checkPasswordInput(), "password for is not displayed");
        MainPage mainPage = new MainPage();
        mainPage.clickToMyPage();
        Assert.assertEquals(mainPage.checkUserPage(), USER_NAME, "wrong page is opened");
        mainPage.checkUserPage();
        String randomString = RandomGenerator.generateRandomString(EXPECTED_LENGTH);
        VkInfo postInfo = ApiUtils.postPost(randomString);
        VkInfo[] pos2t = ApiUtils.getId2(USER_ID, postInfo.getPostId());
        VkInfo[] post = ApiUtils.getId(USER_ID, postInfo.getPostId());
        Assert.assertEquals(post[NEW_POST_INDEX].getText(), randomString,"Expected text from posted post is not equal actual text");
        Assert.assertEquals(post[NEW_POST_INDEX].getFromId(), USER_ID,"Expected user id from posted post is not equal actual user id");

        ValidatableResponse uploadServer = ApiUtils.getUploadServer();
        HashMap<String, String> photoInfoFromServer = ApiUtils.getPhotoInfoFromServer(uploadServer.extract().path(REQUEST_URL_PATH));
        VkInfo[] uploadPhoto = ApiUtils.savePhoto(photoInfoFromServer);

        String newMessage = RandomGenerator.generateRandomString(EXPECTED_LENGTH);
        String photoId = uploadPhoto[NEW_POST_INDEX].getId().toString();
        VkInfo updatePost = ApiUtils.updatePost(USER_ID,
                postInfo.getPostId().toString(),
                newMessage,
                photoId);
        Integer postId = updatePost.getPostId();
        Assert.assertNotEquals(post[NEW_POST_INDEX].getText(),newMessage, "Text from updated post have not changed");
        Assert.assertEquals(photoId, mainPage.getPhotoId(postId), "updated photo does not exist in the updated post");

        newMessage = RandomGenerator.generateRandomString(EXPECTED_LENGTH);
        ApiUtils.addComment(postInfo.getPostId().toString(), newMessage);
        String postText = mainPage.getCommentText(postInfo.getPostId().toString());
        Assert.assertEquals(postText,newMessage, "Comment text has not been added");

        mainPage.likePost();
        VkInfo[] updatesPost = ApiUtils.getId(USER_ID, postInfo.getPostId());
        Assert.assertEquals(updatesPost[NEW_POST_INDEX].getFromId(), USER_ID, "like's post author is not equal expected author");
        Assert.assertEquals(updatesPost[NEW_POST_INDEX].getLikes().getCount(), LIKES_COUNT, "Like does not exist on the post");
        ApiUtils.deletePost(updatesPost[NEW_POST_INDEX].getId().toString());
        String id = updatesPost[NEW_POST_INDEX].getId().toString();
        Assert.assertFalse(mainPage.checkPostExists(id), "Post has not been deleted");
    }

}

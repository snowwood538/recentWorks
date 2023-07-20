package tests;

import base.BaseTest;
import factory.PostFactory;
import io.restassured.response.Response;
import models.Post;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParseUtils;
import utils.RequestUtils;

import java.util.Objects;

import static constants.Constants.POSTS;

public class PostTests extends BaseTest {
    @Test
    public void sendPostRequest() {
        Post uniquePost = PostFactory.createPost();
        uniquePost.setUserId(Integer.valueOf(Objects.requireNonNull(ParseUtils.getTestConfig("POST_USER_ID"))));
        Response response = RequestUtils.post(POSTS, uniquePost);
        Post postResult = response.getBody().as(Post.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"wrong status code");
        Assert.assertEquals(postResult, uniquePost,"objects are not equal");
    }
}

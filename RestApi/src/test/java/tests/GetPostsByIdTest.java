package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.Post;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestUtils;
import static constants.Constants.EXPECTED_ID;
import static constants.Constants.EXPECTED_USER_ID;
import static constants.Constants.POSTS;

public class GetPostsByIdTest extends BaseTest {

    @Test
    public void getPostsByIdTest(){
        Response response = RequestUtils.get(POSTS + "/" + EXPECTED_ID);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_SUCCESS);
        Post post = response.getBody().as(Post.class);
        Assert.assertNotNull(post.getBody(),"body is empty");
        Assert.assertNotNull(post.getTitle(), "title is empty");
        Assert.assertEquals(post.getId().toString(), EXPECTED_ID, " id are not equal");
        Assert.assertEquals(post.getUserId().toString(), EXPECTED_USER_ID,"users id are not equal");
    }
}

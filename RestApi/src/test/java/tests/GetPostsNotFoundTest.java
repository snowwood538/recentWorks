package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.Post;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestUtils;
import static constants.Constants.EXPECTED_LENGTH;
import static constants.Constants.EXPECTED_POST_NOT_FOUND_ID;
import static constants.Constants.POSTS;

public class GetPostsNotFoundTest extends BaseTest {

    @Test
    public void getPostsNotFoundTest() {
        Response response = RequestUtils.get(POSTS + "/" + EXPECTED_POST_NOT_FOUND_ID);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND, "wrong status code");
        Post post = response.getBody().as(Post.class);
        Assert.assertEquals(post.toString().length(), EXPECTED_LENGTH, "body is not empty");
    }
}

package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.Post;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static constants.Constants.POSTS;

public class GetPostsTest extends BaseTest {

    @Test
    public void getPostsTest() {
        Response response = RequestUtils.get(POSTS);
        response.print();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_SUCCESS,"wrong status code");
        List<Post> actualResponse = Arrays.stream(response.getBody().as(Post[].class)).collect(Collectors.toList());
        List<Post> expectedResponse = actualResponse.stream().sorted(Comparator.comparing(Post::getId)).collect(Collectors.toList());
        Assert.assertEquals(actualResponse, expectedResponse,"objects are not equal");
    }
}

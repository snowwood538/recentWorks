package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.user.User;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ParseUtils;
import utils.RequestUtils;

import static constants.PathsConstants.USERS_JSON_PATH;


@Listeners(utils.Listener.class)
public class GetUsersByIdTest extends BaseTest {

    @Test
    public void getUsersByIdTest() {
        User expectedUser = ParseUtils.parseFromJson(USERS_JSON_PATH, User.class);
        Response response = RequestUtils.get(ParseUtils.getTestConfig("USERS") + "/" + ParseUtils.getTestConfig("GET_USER_ID"));
        User actualUser = response.getBody().as(User.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_SUCCESS, "wrong status code");
        Assert.assertEquals(actualUser, expectedUser, "objects are not the same");
    }
}

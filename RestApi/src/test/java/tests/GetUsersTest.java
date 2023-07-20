package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.user.User;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParseUtils;
import utils.RequestUtils;
import java.util.Arrays;
import static constants.Constants.GET_USER_ID;
import static constants.Constants.USERS;
import static constants.Constants.USERS_JSON_PATH;

public class GetUsersTest extends BaseTest {
    @Test
    public void getUsersTest() {
        User expectedUser = ParseUtils.parseFromJson(USERS_JSON_PATH, User.class );
        Response response = RequestUtils.get(String.valueOf(RequestUtils.get(ParseUtils.getTestConfig(USERS))));
        User actualUser = Arrays.stream(response.getBody().as(User[].class))
                .filter(user -> user.getId().toString().equals(ParseUtils.getTestConfig(GET_USER_ID)))
                .findFirst().get();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_SUCCESS,"wrong status code");
        Assert.assertEquals(actualUser, expectedUser, "objects are not the same");
    }
}

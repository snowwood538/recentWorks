package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utils.ParseUtils;

import static constants.Constants.DOMAIN;
import static constants.PathsConstants.CONFIG_DATA_PATH;

public abstract class BaseTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = ParseUtils.getTestConfig(CONFIG_DATA_PATH, DOMAIN);
    }

}

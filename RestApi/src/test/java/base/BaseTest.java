package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utils.ParseUtils;
import static constants.Constants.CONFIG_DATA_PATH;
import static constants.Constants.DOMAIN;

public abstract class BaseTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = ParseUtils.getTestConfig( CONFIG_DATA_PATH,DOMAIN);
    }

}

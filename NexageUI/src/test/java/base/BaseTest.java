package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import static constants.AttributeConstants.URI;
import static constants.CredentialConstants.URL;
import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    private final Browser browser = AqualityServices.getBrowser();

    @BeforeMethod
    public void startBrowser() {
        browser.goTo(URL);
    }

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = URI;
    }

    @AfterTest
    public void quitBrowser() {
        browser.quit();
    }
}

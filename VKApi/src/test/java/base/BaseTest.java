package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static constants.CredentialConstants.URL;

public abstract class BaseTest {
    private final Browser browser = AqualityServices.getBrowser();

    @BeforeMethod
    public void startBrowser() {
        browser.goTo(URL);
    }

    @AfterTest
    public void quitBrowser() {
        browser.quit();
    }
}

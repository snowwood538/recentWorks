package com.a1qa;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ParseUtils;
import static constants.Constants.CONFIG_FILE_PATH;

public abstract class BaseTest {

    Browser browser = AqualityServices.getBrowser();

    @BeforeMethod
    public void startBrowser() {
        String configModelClass = ParseUtils.parseFromJson("URL",CONFIG_FILE_PATH);
        browser.goTo(configModelClass);
    }

    @AfterTest
    public void quitBrowser() {
        browser.quit();
    }
}

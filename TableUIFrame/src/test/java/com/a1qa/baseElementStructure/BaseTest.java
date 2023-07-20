package com.a1qa.baseElementStructure;

import com.a1qa.logger.MyLogger;
import com.a1qa.models.ConfigModel;
import com.a1qa.utils.DriveManager;
import com.a1qa.utils.ParseUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    @BeforeMethod
    public void startBrowser() throws IOException {
        ConfigModel configModelClass = ParseUtils.parseFromJson("src/test/java/com/a1qa/Data/ConfigData.json", ConfigModel.class);
        DriveManager.setBrowserWebDriver(configModelClass.getBrowser());
        DriveManager.getDriver().get(configModelClass.getURL());
        MyLogger.info("Going to URL:" + configModelClass.getURL());
    }
    @AfterTest
    public void quitBrowser() {
        DriveManager.getDriver().quit();
    }

}

package com.a1qa.utils;

import com.a1qa.models.ConfigModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DriveManager {

    private static WebDriver driver;

    private DriveManager() {
    }

    public static WebDriver setBrowserWebDriver(String browser) throws IOException {
        ConfigModel configModelClass = ParseUtils.parseFromJson("src/test/java/com/a1qa/Data/ConfigData.json", ConfigModel.class);
        if (driver == null) {
            switch (browser) {
                case "FireFox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.of(configModelClass.getTimeout(), ChronoUnit.SECONDS));
                    driver.manage().window().maximize();
                    break;
                }
                case "Chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.of(configModelClass.getTimeout(), ChronoUnit.SECONDS));
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

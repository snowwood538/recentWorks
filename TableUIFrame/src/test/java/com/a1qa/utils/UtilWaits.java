package com.a1qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilWaits {

    private final WebDriverWait wait = new WebDriverWait(DriveManager.getDriver(), Duration.ofSeconds(2));

    public UtilWaits() {
    }

    public WebElement waitForElementPresence(By uniqueElement) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(uniqueElement)) ;
    }

    public WebElement waitForElementToBeClickable(By uniqueElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(uniqueElement)) ;
    }
}

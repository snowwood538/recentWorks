package com.a1qa.baseElementStructure;

import com.a1qa.utils.UtilWaits;
import com.a1qa.utils.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseForm {
    public By uniqueFormLocator;
    public String formName;
    public WebDriver driver;
    protected UtilWaits waits;

    public BaseForm() {
        this.driver = DriveManager.getDriver();
       PageFactory.initElements(driver, this);
    }
    public BaseForm(By uniqueFormLocator, String formName) {
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;
        this.driver = DriveManager.getDriver();
        this.waits = new UtilWaits();
        PageFactory.initElements(driver, this);
    }
    public boolean isPageOpen() {
        waits.waitForElementPresence(uniqueFormLocator);
        return driver.findElement(uniqueFormLocator).isDisplayed();
    }
}

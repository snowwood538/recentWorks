package com.a1qa.baseElementStructure;

import com.a1qa.utils.DriveManager;
import com.a1qa.utils.UtilWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    public By uniqueLocator;
    public String elementName;
    UtilWaits waits;

    public BaseElement(By uniqueLocator, String elementName) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
        this.waits = new UtilWaits();
    }

    public  WebElement getWebElement() {
        return DriveManager.getDriver().findElement(uniqueLocator);
    }

    public void click() {
        waits.waitForElementPresence(uniqueLocator);
        waits.waitForElementToBeClickable(uniqueLocator);
        getWebElement().click();
    }

    public boolean isElementPresent() {
        waits.waitForElementPresence(uniqueLocator);
        return DriveManager.getDriver().findElement(uniqueLocator).isDisplayed();
    }

    public String getText(){
        return getWebElement().getText();
    }

    public String getAttribute(String name) {
        return getWebElement().getAttribute(name);
    }

    public List<WebElement> findElements() {
        return DriveManager.getDriver().findElements(uniqueLocator);
    }
}

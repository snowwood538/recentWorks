package com.a1qa.baseElementStructure;

import org.openqa.selenium.By;

public class Field extends BaseElement{
    public Field(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendKeys(String keys) {
        getWebElement().sendKeys(keys);
    }

    public void sendKeys(int keys) {
        getWebElement().sendKeys(Integer.toString(keys));
    }

}

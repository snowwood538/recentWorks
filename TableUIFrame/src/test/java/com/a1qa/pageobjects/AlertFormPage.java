package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseElement;
import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class AlertFormPage extends BaseForm {
    private BaseForm alertPageHeader = new BaseForm(By.xpath("//div[@class='main-header']"), "Alerts, Frame & Windows header" );
    private  Button alertsButton = new Button(By.xpath("//span[text()= 'Alerts']"), "Alerts section button");
    private  Button alertBoxButton = new Button(By.xpath("//*[@id='alertButton']"),"Click button alert");
    private Button confirmBoxAlertButton = new Button(By.xpath("//*[@id='confirmButton']"), "confirm box button");
    private  BaseElement confirmResultField = new BaseElement(By.xpath("//*[@id='confirmResult']"), "confirm result field");
    private  Button promptBoxButton = new Button(By.xpath("//*[@id='promtButton']"), "prompt box button");
    private BaseElement promptResultField = new BaseElement(By.xpath("//*[@id='promptResult']"), "prompt result field with text");

    public boolean checkAlertPageHeaderIsPresented() {
        MyLogger.info("Alerts, Frame & Windows header is presented");
        return alertPageHeader.isPageOpen();
    }
    public void clickAlertSection() {
        alertsButton.click();
    }

    public void clickAlertBoxButton() {
        alertBoxButton.click();
    }
    public boolean isAlertPresent()
    {   try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {   MyLogger.error("Alert is not presented");
            return false;
        }
    }
    public void pressOKInAlertMessage() {
        driver.switchTo().alert().accept();
    }
    public void clickConfirmBoxButton() {
        confirmBoxAlertButton.click();
    }
    public void pressOkInConfirmBoxAlert() {
        driver.switchTo().alert().accept();
    }
    public boolean checkConfirmResultFieldIsPresented() {
        MyLogger.info("confirm result is presented");
        return confirmResultField.isElementPresent();
    }
    public void clickPromptButton() {
        promptBoxButton.click();
    }
    public void writeRandomStringToFormAlertAndAccept(String stringToType) {
        driver.switchTo().alert().sendKeys(stringToType);
        driver.switchTo().alert().accept();
        MyLogger.info("String - " + stringToType + "has been successfully typed and accepted");
    }
    public String getPromptText() {
        return promptResultField.getText().replace("You entered ", "").trim();
    }



}

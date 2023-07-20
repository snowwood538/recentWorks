package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private BaseForm mainPageTemplates = new BaseForm(By.xpath("//div[@class='category-cards']"), "Main Page Templates");
    private Button alertButton = new Button(By.xpath("//div[3][@class='card mt-4 top-card']"), "Alerts, Frame & Windows button");
    private Button elementsButton = new Button(By.xpath("//div[1][@class='card mt-4 top-card']"), "Elements button");

    public boolean checkMainPageTemplateIsPresented() {
        MyLogger.info("Check main page template is presented");
        return mainPageTemplates.isPageOpen();
    }
    public void clickAlertSectionButton() {
        alertButton.click();
    }
    public void clickElementsSectionButton() {
        elementsButton.click();
    }
}

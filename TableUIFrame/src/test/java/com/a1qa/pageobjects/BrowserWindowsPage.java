package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {

    private Button browserWindowsButton = new Button(By.xpath("//span[text()= 'Browser Windows']"), "windows browser section button");
    private BaseForm browserWindowPageHeader = new BaseForm(By.xpath("//div[@class='main-header']"), "Browser Window section header");
    private Button newTabButton = new Button(By.xpath("//*[@id='tabButton']"), "new tab button");
    private Button elementsSectionButton = new Button(By.cssSelector("div:nth-child(1) > span > div"), "Element section button");
    private Button linkButton = new Button(By.xpath("//span[text()= 'Links']"), "Links button");

    public void clickBrowserWindowsSection() {
        browserWindowsButton.click();
    }
    public boolean checkBrowserWindowPageHeaderIsPresented() {
        MyLogger.info("Tables header is presented");
        return browserWindowPageHeader.isPageOpen();
    }
    public void clickNewTabButton() {
        newTabButton.click();
    }
    public void clickElementsSectionButton(){
        elementsSectionButton.click();
    }
    public void clickLinksSectionButton(){
        linkButton.click();
    }
}


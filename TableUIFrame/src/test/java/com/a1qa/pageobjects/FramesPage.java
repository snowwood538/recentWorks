package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FramesPage extends BaseForm {

    private BaseForm formPageHeader = new BaseForm(By.xpath("//div[text()= 'Frames']"), "frames page is presented");

    public boolean checkFramesHeaderIsPresented() {
        MyLogger.info("Frame header is presented on the page");
        return formPageHeader.isPageOpen();
    }
    public String checkParentFrame() {
        driver.switchTo().defaultContent();
        WebElement parentFrame= driver.switchTo().frame("frame1").findElement(By.xpath("//*[@id='sampleHeading']"));
        return parentFrame.getText();
    }
    public String checkChildFrame() {
        driver.switchTo().defaultContent();
        WebElement childrenFrame= driver.switchTo().frame("frame2").findElement(By.xpath("//*[@id='sampleHeading']"));
        return childrenFrame.getText();
    }
}

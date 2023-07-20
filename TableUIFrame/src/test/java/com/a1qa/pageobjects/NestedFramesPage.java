package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseElement;
import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {


    private  Button nestedFramesButton = new Button(By.xpath("//span[text()= 'Nested Frames']"),"Nested Frames section button");
    private  BaseForm nestedFramesHeader = new BaseForm(By.xpath("//div[@class='main-header']")," nested frames header");
    private  BaseElement childrenFrame = new BaseElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")," children frame template");
    private  BaseElement parentFrame = new BaseElement(By.xpath("//iframe[@id='frame1']")," children frame template");
    private Button framesOptionButton = new Button(By.xpath("//li[@class='btn btn-light ']/span[text()= 'Frames']"), "frames option button");

    public void clickNestedFramesButton() {
        nestedFramesButton.click();
    }

    public boolean checkNestedFramesFormIsOpened() {
        MyLogger.info("nested frames form  is presented");
        return  nestedFramesHeader.isPageOpen();
    }
    public boolean checkParentFrame() {
        driver.switchTo().parentFrame();
        MyLogger.info("parent frame is presented on the page");
        return parentFrame.isElementPresent();
    }
    public boolean checkChildrenFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        MyLogger.info("children frame is presented on the page");
        return  childrenFrame.isElementPresent();
    }
    public void clickFramesOptionButton() {
        driver.switchTo().defaultContent();
        framesOptionButton.click();
    }
}

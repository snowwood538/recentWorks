package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {

    private BaseForm linkHeader = new BaseForm(By.xpath("//div[text()= 'Links']"), "links header is presented");

    public boolean checkLinksHeaderIsPresented() {
        MyLogger.info("Links header is presented");
        return linkHeader.isPageOpen();
    }
}

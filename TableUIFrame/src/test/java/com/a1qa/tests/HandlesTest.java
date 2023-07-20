package com.a1qa.tests;

import com.a1qa.baseElementStructure.BaseTest;
import com.a1qa.pageobjects.BrowserWindowsPage;
import com.a1qa.pageobjects.LinksPage;
import com.a1qa.pageobjects.MainPage;
import com.a1qa.utils.DriveManager;
import com.a1qa.utils.UtilsBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlesTest extends BaseTest {

    @Test
    public void testHandles() {
        MainPage mainPage = new MainPage();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(mainPage.checkMainPageTemplateIsPresented(), "Main page isn't displayed");
        mainPage.clickAlertSectionButton();
        browserWindowsPage.clickBrowserWindowsSection();
        Assert.assertTrue(browserWindowsPage.checkBrowserWindowPageHeaderIsPresented(),"Browser windows page is not presented");
        String mainPageTab = UtilsBrowser.getCurrentWindowName();
        browserWindowsPage.clickNewTabButton();
        UtilsBrowser.switchTabFrom(mainPageTab);
        DriveManager.getDriver().close();
        DriveManager.getDriver().switchTo().window(mainPageTab);
        Assert.assertTrue(browserWindowsPage.checkBrowserWindowPageHeaderIsPresented(), "Browser windows page is not presented");
        browserWindowsPage.clickElementsSectionButton();
        browserWindowsPage.clickLinksSectionButton();
        Assert.assertTrue(linksPage.checkLinksHeaderIsPresented(), "Links page is not presented");
        String linkPageTab = UtilsBrowser.getCurrentWindowName();
        DriveManager.getDriver().switchTo().window(linkPageTab);
        Assert.assertTrue(linksPage.checkLinksHeaderIsPresented(), "Links page is not presented");
    }
}

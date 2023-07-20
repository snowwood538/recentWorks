package com.a1qa.tests;

import com.a1qa.baseElementStructure.BaseTest;
import com.a1qa.pageobjects.FramesPage;
import com.a1qa.pageobjects.MainPage;
import com.a1qa.pageobjects.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void testFrames() {
        MainPage mainPage = new MainPage();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(mainPage.checkMainPageTemplateIsPresented(), "Main page isn't displayed");
        mainPage.clickAlertSectionButton();
        nestedFramesPage.clickNestedFramesButton();
        Assert.assertTrue(nestedFramesPage.checkNestedFramesFormIsOpened());
        Assert.assertTrue( nestedFramesPage.checkParentFrame(),"parent frame is not presented");
        Assert.assertTrue( nestedFramesPage.checkChildrenFrame(),"child frame is not presented");
        nestedFramesPage.clickFramesOptionButton();

        Assert.assertTrue(framesPage.checkFramesHeaderIsPresented(),"Frames page is not presented");
        String actual = framesPage.checkParentFrame();
        String expected = framesPage.checkChildFrame();
        Assert.assertEquals(actual, expected);
    }
}

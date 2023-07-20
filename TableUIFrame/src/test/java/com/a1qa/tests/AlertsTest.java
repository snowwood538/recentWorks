package com.a1qa.tests;

import com.a1qa.baseElementStructure.BaseTest;
import com.a1qa.pageobjects.AlertFormPage;
import com.a1qa.pageobjects.MainPage;
import com.a1qa.utils.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void testAlerts() {
        MainPage mainPage = new MainPage();
        AlertFormPage alertFormPage = new AlertFormPage();
        Assert.assertTrue(mainPage.checkMainPageTemplateIsPresented(), "Main page isn't displayed");
        mainPage.clickAlertSectionButton();
        Assert.assertTrue(alertFormPage.checkAlertPageHeaderIsPresented(), "Alert page isn't presented");
        alertFormPage.clickAlertSection();
        alertFormPage.clickAlertBoxButton();
        Assert.assertTrue(alertFormPage.isAlertPresent(), "Alert section is not presented");
        alertFormPage.pressOKInAlertMessage();
        alertFormPage.clickConfirmBoxButton();
        alertFormPage.pressOkInConfirmBoxAlert();
        Assert.assertTrue(alertFormPage.checkConfirmResultFieldIsPresented(), "confirm result template  is not presented");
        alertFormPage.clickPromptButton();
        Assert.assertTrue(alertFormPage.isAlertPresent(), "Alert section is not presented");
        String stringToType = RandomStringGenerator.generateRandomString(5);
        alertFormPage.writeRandomStringToFormAlertAndAccept(stringToType);
        Assert.assertEquals(alertFormPage.getPromptText(),stringToType, "Appeared text is not equal to the one typed before");
    }
}

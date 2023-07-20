package testSteps;

import aquality.selenium.browser.AqualityServices;
import static constants.AttributeConstants.CONTENT_TYPE;
import static constants.AttributeConstants.ENV;
import static constants.AttributeConstants.METHOD_NAME;
import static constants.AttributeConstants.NEXAGE_PROJECT_ID;
import static constants.AttributeConstants.PROJECT_NAME;
import static constants.AttributeConstants.TEST_NAME;
import static constants.AttributeConstants.TOKEN_ATTRIBUTE;
import static constants.AttributeConstants.VARIANT_ID;
import static constants.CredentialConstants.LOGIN;
import static constants.CredentialConstants.PASSWORD;
import static constants.PathConstants.LOG_FILE_PATH;
import models.TestModel;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import pageObjects.CreatedProjectPage;
import pageObjects.HomePage;
import pageObjects.NewTestPage;
import pageObjects.NexageProjectPage;
import utils.ApiUtils;
import utils.CookieUtils;
import utils.JsonParser;
import static utils.JsonParser.parseJsonToClass;
import utils.TestUtils;

import java.sql.Timestamp;
import java.util.List;

public class Steps {

    private static final HomePage homePage = new HomePage();
    private static final NexageProjectPage nexageProjectPage = new NexageProjectPage();
    private static final CreatedProjectPage createdProjectPage = new CreatedProjectPage();
    private static final NewTestPage newTestPage = new NewTestPage();

    public static String getToken() {
        return ApiUtils.getToken(VARIANT_ID);
    }

    public static void goToWebSiteAndAuthorize() {
        TestUtils.authorisation(LOGIN, PASSWORD);
    }

    public static void sendTokenWithCookie(String token) {
        Cookie cookie = CookieUtils.getBasicCookie(TOKEN_ATTRIBUTE, token);
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }

    public static void checkTheRightVariant(int actualVariant, int expectedVariant) {
        Assert.assertEquals(actualVariant, expectedVariant, "Variant of the page is not that expected");
    }

    public static void refreshPage() {
        AqualityServices.getBrowser().refresh();
    }

    public static void goToNexageProject() {
        homePage.clickNexageProject();
    }

    public static models.TestModel[] getTestsListInJson() {
        String testList = ApiUtils.getTestList(NEXAGE_PROJECT_ID);
        return JsonParser.parseJsonToClass(testList, TestModel[].class);
    }

    public static void checkApiListContainsUiList(List<TestModel> apiList, List<TestModel> uiList) {
        Assert.assertTrue(apiList.containsAll(uiList),"Tests' list does not correspond to the list returned by the request to the api");
    }

    public static void checkTestsListIsSorted(List<TestModel> testsFromPage,  List<TestModel> sortedTestList) {
        Assert.assertEquals(testsFromPage, sortedTestList, "List from first page is not sorted by date ");
    }

    public static void backToHomePage() {
        nexageProjectPage.backToHomePage();
    }

    public static void addNewProject() {
        homePage.usePopUp(PROJECT_NAME);
    }

    public static void checkProjectIsCreated(boolean projectCondition) {
        Assert.assertTrue(projectCondition, "Project is not created");
    }

    public static void closePopUpWindow() {
        homePage.closePopUp();
    }

    public static void goToAddedProject() {
        homePage.chooseMyProject(PROJECT_NAME);
    }

    public static void checkPresenceOfProjectInList(boolean projectCondition) {
        Assert.assertTrue(projectCondition,"The project has not been found in the project list");
    }

    public static String addNewTestToProject() {
        return ApiUtils.createTest(Timestamp.valueOf(java.time.LocalDateTime.now()), PROJECT_NAME, TEST_NAME, METHOD_NAME, ENV);
    }

    public static void addPhotoToTest(String testId, byte[] content) {
        ApiUtils.putAttachment(testId, content, CONTENT_TYPE);
    }

    public static void addLogsToTest(String testId, String logs) {
        ApiUtils.putLogs(testId, logs);
    }

    public static String getLogFileContent() {
        return TestUtils.readFile(LOG_FILE_PATH);
    }

    public static byte[] makeScreenshotOfWindow() {
        return TestUtils.makeScreenshot();
    }

    public static void  checkTestIsAddedToProject(boolean testCondition) {
        Assert.assertTrue(testCondition, "Test has not been added to project");
    }

    public static void openCreatedTest(String testId) {
        createdProjectPage.clickTestButton(testId);
    }

    public static void checkLogInTest(boolean logsCondition) {
        Assert.assertFalse(logsCondition,"logs are not added");
    }

    public static void checkPhotoInTest(String actual, String expected) {
        Assert.assertEquals(actual, expected, "photo is not added");
    }
}

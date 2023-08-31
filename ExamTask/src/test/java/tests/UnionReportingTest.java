package tests;

import base.BaseTest;
import static constants.AttributeConstants.EXPECTED_VARIANT;
import static constants.AttributeConstants.PHOTO_ENCODER_ATTRIBUTE;
import static constants.AttributeConstants.PROJECT_NAME;
import static constants.AttributeConstants.TEST_NAME;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import models.TestModel;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import pageObjects.CreatedProjectPage;
import pageObjects.HomePage;
import pageObjects.NewTestPage;
import pageObjects.NexageProjectPage;
import testSteps.Steps;

public class UnionReportingTest extends BaseTest {

    private static final HomePage homePage = new HomePage();
    private static final NexageProjectPage nexageProjectPage = new NexageProjectPage();
    private static final CreatedProjectPage createdProjectPage = new CreatedProjectPage();
    private static final NewTestPage newTestPage = new NewTestPage();

    @Test
    public void createProjectTest() {
        String token = Steps.getToken();
        Steps.goToWebSiteAndAuthorize();
        Steps.sendTokenWithCookie(token);
        Steps.refreshPage();
        Steps.checkTheRightVariant(Integer.parseInt(homePage.getVariantNumber()), EXPECTED_VARIANT);
        Steps.goToNexageProject();
        TestModel[] testsListInJson = Steps.getTestsListInJson();
        List<TestModel> testsFromPage = nexageProjectPage.getTestsFromPage();
        Steps.checkTestsListIsSorted(testsFromPage, testsFromPage.stream().sorted(Comparator.comparing(TestModel::getStartTime).reversed()).toList() );
        Steps.checkApiListContainsUiList(List.of(testsListInJson), nexageProjectPage.getTestsFromPage());
        Steps.backToHomePage();
        Steps.addNewProject();
        Steps.checkProjectIsCreated(homePage.checkSuccessfulCreation());
        Steps.closePopUpWindow();
        Steps.refreshPage();
        Steps.checkPresenceOfProjectInList(homePage.isElementPresent(PROJECT_NAME));
        Steps.goToAddedProject();
        String testId = Steps.addNewTestToProject();
        String logFileContent = Steps.getLogFileContent();
        byte[] photo = Steps.makeScreenshotOfWindow();
        Steps.addLogsToTest(testId, logFileContent);
        Steps.addPhotoToTest(testId, photo);
        Steps.checkTestIsAddedToProject(createdProjectPage.checkIfTestCreated(TEST_NAME));
        Steps.openCreatedTest(testId);
        Steps.checkLogInTest(newTestPage.getLogs());
        Steps.checkPhotoInTest(StringUtils.substringAfter(newTestPage.getPhotoContent(), PHOTO_ENCODER_ATTRIBUTE), Base64.getEncoder().encodeToString(photo));
    }
}

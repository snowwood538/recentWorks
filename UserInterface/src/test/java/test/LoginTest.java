package test;

import com.a1qa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeObjects.AvatarPage;
import pajeObjects.LoginPage;
import pajeObjects.PersonalDetailPage;
import pajeObjects.WelcomePage;
import utils.RandomGenerator;
import utils.Utils;
import java.io.IOException;


import static constants.Constants.PASSWORD_LENGTH;
import static constants.Constants.REQUIRED_NUMBER_CHECKBOX;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws IOException {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.checkMainPageLogoIsPresented(), "welcome page not presented");
        welcomePage.clickToGoToNextPage();
        String RandomStringToField = RandomGenerator.generateRandomString(PASSWORD_LENGTH);
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.checkFirstCardIsPresented(), "first card is not presented");
        loginPage.writeRandomEmail(RandomStringToField);
        loginPage.writeRandomPassword(RandomStringToField);
        loginPage.writeRandomDomain(RandomGenerator.generateRandomDomain());
        loginPage.chooseRandomDomainFromDropDown();
        loginPage.clickToCheckBox();
        loginPage.clickToNextPageButton();
        AvatarPage avatarPage = new AvatarPage();
        Assert.assertTrue(avatarPage.checkSecondCardIsPresented(), "second card is nod presented");
        avatarPage.unselectInterests();
        avatarPage.selectCheckBox(REQUIRED_NUMBER_CHECKBOX);
        avatarPage.clickToUpload();
        Utils.uploadImage();
        avatarPage.clickToNextPage();
        PersonalDetailPage personalDetailPage = new PersonalDetailPage();
        Assert.assertTrue(personalDetailPage.checkCardThreeIsPresented(), "third card is nod presented");
    }
}

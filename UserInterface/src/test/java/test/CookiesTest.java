package test;

import com.a1qa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeObjects.WelcomePage;

public class CookiesTest extends BaseTest {

    @Test
    public void cookiesTest() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickToGoToNextPage();
        welcomePage.acceptCookies();
        Assert.assertFalse(welcomePage.checkIfCookiesFormIsClosed(), "cookies form is not closed");
    }
}

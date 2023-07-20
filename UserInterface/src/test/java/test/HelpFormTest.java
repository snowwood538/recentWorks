package test;

import com.a1qa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeObjects.WelcomePage;

public class HelpFormTest extends BaseTest {

    @Test
    public void hideHelpTest() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickToGoToNextPage();
        welcomePage.clickToHideHelp();
        Assert.assertFalse(welcomePage.checkContentFormIsNotPresented(),"Help form is not hidden");
    }
}

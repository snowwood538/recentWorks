package test;

import com.a1qa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeObjects.WelcomePage;


import static constants.Constants.EXPECTED_TIME;

public class TimerTest extends BaseTest {

    @Test
    public void timerTest() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickToGoToNextPage();
        Assert.assertEquals(welcomePage.checkTimer(), EXPECTED_TIME,"Timers doesn't start with 00:00:00");

    }
}

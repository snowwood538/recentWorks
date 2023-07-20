package pajeObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import utils.ParseUtils;

import java.time.Duration;

import static constants.Constants.WAITER;


public class WelcomePage {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final IElement mainPageLogo = elementFactory.getLabel(By.xpath("//div[contains(@class,'logo__icon')]"), "logo icon");
    private final IButton goToLinkButton = elementFactory.getButton(By.xpath("//a[contains(@href,'/game.html')] "), "goToLink");
    private final IButton hideHelpButton = elementFactory.getButton(By.xpath("//button[contains(@class,' help-form__send-to-bottom')]"), "hide help button");
    private final ILabel contentForm = elementFactory.getLabel(By.xpath("//textarea[contains(@class,'help-form')]"), "form content");
    private final IButton acceptCookiesButton = elementFactory.getButton(By.xpath("//button[contains(@class,'button button--solid button--transparent')]"), "button to accept cookies");
    private final IElement cookiesForm = elementFactory.getLabel(By.xpath("//div[@class='cookies']"), "cookies form");
    private final ILabel timer = elementFactory.getLabel(By.xpath("//div[contains(@class,'timer timer--white timer--center')]"), "timer form");

    public boolean checkMainPageLogoIsPresented() {
        return mainPageLogo.state().isDisplayed();
    }

    public void clickToGoToNextPage() {
        goToLinkButton.click();
    }

    public void clickToHideHelp() {
        hideHelpButton.click();
    }

    public boolean checkContentFormIsNotPresented() {
        return contentForm.state().waitForNotExist(Duration.ofSeconds(WAITER));
    }

    public void acceptCookies() {
        acceptCookiesButton.state().waitForDisplayed(Duration.ofSeconds(WAITER));
        acceptCookiesButton.click();
    }

    public boolean checkIfCookiesFormIsClosed() {
        return cookiesForm.state().isDisplayed();
    }

    public String checkTimer() {
        return timer.getText();
    }
}

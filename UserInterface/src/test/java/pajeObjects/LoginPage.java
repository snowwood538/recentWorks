package pajeObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import utils.RandomGenerator;
import static constants.Constants.NUMBER_DROPDOWN_DOMAINS;

public class LoginPage {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ICheckBox checkBoxAccept = elementFactory.getCheckBox(By.xpath("//span[@class='icon icon-check checkbox__check']"),"check box terms of using acceptation");
    private final ITextBox choosePasswordTextBox = elementFactory.getTextBox(By.xpath("//input[@placeholder='Choose Password']")," password textBox");
    private final ITextBox yourEmailTextBox = elementFactory.getTextBox(By.xpath("//input[@placeholder='Your email']"), "email textBox");
    private final ITextBox domainTextBox = elementFactory.getTextBox(By.xpath("//input[@placeholder='Domain']"), "domain textBox");
    private final IElement domainDropDown = elementFactory.getButton(By.xpath("//div[@class='dropdown__field']"), "dropDown menu");
    private final IButton nextButton = elementFactory.getButton(By.xpath("//a[@class='button--secondary']"),"next page  button");
    private final ILabel firstCard = elementFactory.getLabel(By.xpath(" //div[@class='login-form__container']"), "first card");
    private final ILabel domainLabel = elementFactory.getLabel(By.xpath(String.format("//div[@class='dropdown__list-item'][%d]",
                    RandomGenerator.generateRandomNumber(NUMBER_DROPDOWN_DOMAINS))), "first lab");

    public boolean checkFirstCardIsPresented() {
        return firstCard.state().isDisplayed();
    }

    public void writeRandomPassword(String password) {
        choosePasswordTextBox.click();
        choosePasswordTextBox.clearAndType(password);
    }

    public void writeRandomEmail(String email) {
        yourEmailTextBox.click();
        yourEmailTextBox.clearAndType(email);
    }

    public void writeRandomDomain(String domain) {
        domainTextBox.click();
        domainTextBox.clearAndType(domain);

    }

    public void chooseRandomDomainFromDropDown() {
        domainDropDown.click();
        domainLabel.click();

    }

    public void clickToCheckBox() {
        checkBoxAccept.click();
    }

    public void clickToNextPageButton() {
        nextButton.click();
    }
}

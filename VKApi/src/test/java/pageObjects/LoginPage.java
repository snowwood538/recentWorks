package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class LoginPage {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final ITextBox loginTextBox = elementFactory.getTextBox(By.xpath("//input[@id='index_email']"), "email/number textBox");
    private final IButton nextButton = elementFactory.getButton(By.xpath("//button[contains(@class,'VkIdForm__signInButton')]"), "go to next login page button");
    private final ITextBox passwordTextBox = elementFactory.getTextBox(By.xpath("//input[@name='password']"), "password textBox");
    private final IButton submitButton = elementFactory.getButton(By.xpath("//button[@type='submit']"), "submit password button");

    public boolean checkLoginInput() {
        return loginTextBox.state().isDisplayed();
    }
    public void insertLogin(String login) {
        loginTextBox.click();
        loginTextBox.sendKeys(login);
    }
    public void submitLogin() {
        nextButton.click();
    }
    public boolean checkPasswordInput() {
        return passwordTextBox.state().isDisplayed();
    }
    public void insertPassword(String password) {
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }
    public void submitPassword() {
        submitButton.click();
    }


}

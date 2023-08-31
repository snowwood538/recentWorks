package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import static utils.constants.SymbolConstants.COLON;
import static utils.constants.SymbolConstants.SPACE;


public class HomePage extends Form {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final IButton nexageProjectButton = elementFactory.getButton(By.xpath("//a[@class='list-group-item' and contains(text(), 'Nexage')]"), "button go to Nexage project");
    private final IButton addButton2 = elementFactory.getButton(By.xpath("//a[@href='addProject']"), "add test button");
    private final ITextBox projectNameField = elementFactory.getTextBox(By.xpath("//input[@id='projectName']"), "project name field");
    private final IButton submitButton = elementFactory.getButton(By.xpath("//button[@type='submit']"), "submit button");
    private final ILabel successLabel = elementFactory.getLabel(By.xpath("//div[contains(@class, 'alert-success')]"), "version number label");
    private final ILabel variant = elementFactory.getLabel(By.xpath("//p[contains(@class,'text-center footer-text')]"), "variant number label");
    private static final String projects = "//a[contains(@href,'allTests?projectId')]";

    public HomePage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "home page form");
    }

    public void clickNexageProject() {
        nexageProjectButton.click();
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    public void usePopUp(String projectName) {
        addButton2.click();
        String mainWindowHandle = AqualityServices.getBrowser().getDriver().getWindowHandle();
        String popupWindowHandle = AqualityServices
                .getBrowser()
                .getDriver()
                .getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(mainWindowHandle))
                .findFirst()
                .orElse(null);
        AqualityServices.getBrowser().getDriver().switchTo().window(popupWindowHandle);
        projectNameField.sendKeys(projectName);
        submitButton.click();

    }
    public void closePopUp() {
        try {
            String jsCode = new String(Files.readAllBytes(Path.of(java.util.Objects.requireNonNull(constants.PathConstants.JS_SCRIPT_PATH))));
            AqualityServices.getBrowser().getDriver().executeScript(jsCode);
        } catch (IOException e) {
            AqualityServices.getLogger().error("pop up has not appeared" + e.getMessage());
        }
        AqualityServices.getBrowser()
                .tabs()
                .switchToTab(constants.AttributeConstants.ORIGINAL_TAB_INDEX);
    }

    public boolean checkSuccessfulCreation() {
        AqualityServices.getBrowser().waitForPageToLoad();
        return successLabel.state().isDisplayed();
    }

    public void chooseMyProject(String projectName) {
        elementFactory.findElements(By.xpath(projects), ElementType.LABEL)
                .stream()
                .filter(element -> element.getText().equals(projectName))
                .findFirst()
                .get()
                .click();
    }

    public boolean isElementPresent(String elementName) {
        AqualityServices.getBrowser().waitForPageToLoad();
        List<ILabel> listOfProjects = elementFactory.findElements(By.xpath(projects), ElementType.LABEL);
        return listOfProjects.stream()
                .anyMatch(element -> element.getText()
                        .equals(elementName));
    }
    public String getVariantNumber() {
        return StringUtils.substringAfterLast(variant.getText(),COLON + SPACE);
    }
}

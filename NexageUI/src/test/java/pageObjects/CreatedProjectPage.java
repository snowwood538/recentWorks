package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import static constants.AttributeConstants.TEST_CLASS_A_ATTRIBUTE;
import org.openqa.selenium.By;
import static pageObjects.NexageProjectPage.childFieldElementTd;

import java.util.List;

public class CreatedProjectPage extends Form {

    private static final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private static final String PROJECT_LIST = "//table[@class='table']//tr[not(position()=1)]";

    public CreatedProjectPage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "created page form");
    }

    public boolean checkIfTestCreated(String testName)  {
        AqualityServices.getBrowser().waitForPageToLoad();
        List<ILabel> listOfProjects = elementFactory.findElements(By.xpath(PROJECT_LIST), ElementType.LABEL);
        return listOfProjects.stream()
                .anyMatch(element -> element.findChildElement(By.xpath(childFieldElementTd(1) + TEST_CLASS_A_ATTRIBUTE), ElementType.LABEL).getText()
                        .equals(testName));
     }
    public void clickTestButton(String testId) {
        IButton testButton = elementFactory.getButton(By.xpath("//a[@href='testInfo?testId="+ testId + "']"), "test button");
        testButton.click();
    }
}


package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import static constants.AttributeConstants.SPAN_ATTRIBUTE;
import static constants.AttributeConstants.TEST_CLASS_A_ATTRIBUTE;
import static constants.AttributeConstants.TEST_FIELD_ATTRIBUTE;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class NexageProjectPage extends Form {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final List<ILabel> nexageProjectTests = elementFactory.findElements(By.xpath("//table[@class='table']//tr[not(position()=1)]"), ElementType.LABEL);
    private final IButton homePageButton = elementFactory.getButton(By.xpath("//a[contains(text(), 'Home')]"), " home page button");
    private final IButton pageLoadIndication = elementFactory.getButton(By.xpath("//div[@id='pie']//canvas[@class='flot-base']"), " indication");


    public NexageProjectPage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "Nexage page form");
    }

    public List<models.TestModel> getTestsFromPage() {
        List<models.TestModel> testList = new ArrayList<>();
        nexageProjectTests.forEach(test -> {
            String testName = test.findChildElement(By.xpath(childFieldElementTd(1) + TEST_CLASS_A_ATTRIBUTE), ElementType.LABEL).getText();
            String testMethod = test.findChildElement(By.xpath(childFieldElementTd(2)), ElementType.LABEL).getText();
            String testResult = test.findChildElement(By.xpath(childFieldElementTd(3) + SPAN_ATTRIBUTE), ElementType.LABEL).getText();
            String testStartTime = test.findChildElement(By.xpath(childFieldElementTd(4)), ElementType.LABEL).getText();
            String testEndTime = test.findChildElement(By.xpath(childFieldElementTd(5)), ElementType.LABEL).getText();
            String testDuration = test.findChildElement(By.xpath(childFieldElementTd(6)), ElementType.LABEL).getText();
            testList.add(new models.TestModel(testName, testMethod, testResult, testStartTime, testEndTime, testDuration));
        });
        return testList;
    }

    public static String childFieldElementTd(int id) {
        return String.format(TEST_FIELD_ATTRIBUTE, id);
    }

    public void backToHomePage() {
        waitPageLoad();
        homePageButton.state().waitForEnabled();
        homePageButton.click();
    }

    public void waitPageLoad() {
        pageLoadIndication.state().waitForDisplayed();
    }
}

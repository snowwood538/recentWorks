package pajeObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class PersonalDetailPage {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ILabel labelCardThree = elementFactory.getLabel(By.xpath("//div[@class='personal-details__form']"), "third card");

    public boolean checkCardThreeIsPresented() {
        return labelCardThree.state().isDisplayed();
    }
}

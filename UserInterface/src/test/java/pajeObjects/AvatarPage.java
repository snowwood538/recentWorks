package pajeObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import utils.RandomGenerator;

import java.util.List;

public class AvatarPage {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ICheckBox unselectCheckBox = elementFactory.getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "unselect");
    private final IButton uploadImageButton = elementFactory.getButton(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "button to upload image");
    private final IButton nextButtonClick = elementFactory.getButton(By.xpath("//button[contains(text(),'Next')]"), "go to next page");
    private final ILabel labelCardTwo = elementFactory.getLabel(By.xpath("//div[@class='avatar-and-interests__form']"), "card two");
    private final List<ICheckBox> listOfInterests = elementFactory.findElements(By.xpath("//label[@Class='checkbox__label' and not(@for='interest_selectall') and not(@for='interest_unselectall')]"), ElementType.CHECKBOX);

    public boolean checkSecondCardIsPresented() {
        return labelCardTwo.state().isDisplayed();
    }

    public void unselectInterests() {
        unselectCheckBox.click();
    }

    public void clickToUpload() {
        uploadImageButton.click();
    }

    public void clickToNextPage() {
        nextButtonClick.click();
    }

    public void selectCheckBox(int numberOfCheckBoxes) {
        int numberOfChecks = 0;
        while (numberOfChecks < numberOfCheckBoxes) {
            ICheckBox checkBox =  listOfInterests.get(RandomGenerator
                    .getNumberExceptingNumbers(listOfInterests.size() - 1));
            if (checkBox.isChecked()) {
                continue;
            }
            checkBox.click();
            numberOfChecks++;
        }
    }
}

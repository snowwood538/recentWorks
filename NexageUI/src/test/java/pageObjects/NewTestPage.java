package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import static constants.AttributeConstants.SRC_ATTRIBUTE;
import org.openqa.selenium.By;


public class NewTestPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final ILabel logs = elementFactory.getLabel(By.xpath("//div[contains(text(), 'Logs')]/following-sibling::table//td"), "logs field");
    private final ILabel photoContent = elementFactory.getLabel(By.xpath(" //*[contains(@src,'data:image')]"), "photo content");


    public NewTestPage() {
            super(By.xpath("//div[contains(@class,'main-container')]"), "new test page form");
        }

    public boolean getLogs() {
        return logs.getText().isEmpty();
    }

    public String getPhotoContent() {
        return photoContent.getAttribute(SRC_ATTRIBUTE);
    }
}

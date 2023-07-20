package pageObjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import utils.ApiUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static constants.AttributeConstants.HREF_ATTRIBUTE;
import static constants.AttributeConstants.ID_ATTRIBUTE;
import static constants.IndexConstants.NEW_POST_INDEX;
import static tests.AuthorisationTest.USER_ID;

public class MainPage {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final ILabel userNamePlate = elementFactory.getLabel(By.xpath("//h2[@id='owner_page_name']"), "User name plate");
    private final ILabel mainPagePlate = elementFactory.getLabel(By.xpath("//div[@id='page_header_wrap']"), "Main page plate");
    private final ILabel myPageLabel = elementFactory.getLabel(By.xpath("//li[contains(@id,'l_pr')] "), "main page label");
    private final IButton showCommentsButton = elementFactory.getButton(By.xpath("//span[@class='js-replies_next_label']"), "button to show hidden comments");
    private final String likeButton = "//div[@data-section-ref='reactions-button']";
    private final String postsLocator = "//div[contains(@class,'_post post')]";
    private final String postsPhotoChild = "//div[@class='wall_reply_text']";
    private final String photoInPost = "//a[@aria-label]";


    public void clickToMyPage() {
        myPageLabel.click();
    }
    public boolean checkMainPage() {
        return mainPagePlate.state().isDisplayed();
    }

    public String checkUserPage() {
        return userNamePlate.getText();
    }

    public void likePost() {
        List<IButton> likenButton = elementFactory.findElements(By.xpath(likeButton), ElementType.BUTTON);
        likenButton.get(NEW_POST_INDEX).click();
    }

    public String getPhotoId(Integer postId) {
        List<IButton> posts = getPosts();
        AqualityServices.getBrowser().waitForPageToLoad();
        IButton postWithPhoto = posts.stream().filter(post -> post.getAttribute(ID_ATTRIBUTE).contains(USER_ID + "_" + postId)).findAny().get();
        IElement childElement = postWithPhoto.findChildElement(By.xpath(photoInPost), ElementType.BUTTON);
        return StringUtils.substringAfterLast(childElement.getAttribute(HREF_ATTRIBUTE), "_");
    }

    private List<IButton> getPosts() {
        AqualityServices.getBrowser().waitForPageToLoad();
        return elementFactory.findElements(By.xpath(postsLocator), ElementType.BUTTON);
    }

    public String getCommentText(String postId) {
        showCommentsButton.click();
        IButton postPhotos = getPosts().stream().filter(post -> StringUtil.substringAfter(post.getAttribute(ID_ATTRIBUTE), '_').equals(postId)).findAny().get();
        return postPhotos.findChildElement(By.xpath(postsPhotoChild), ElementType.BUTTON).getText();
    }

    public boolean checkPostExists(String postId) {
        return getPosts().stream().map(post -> {
            try {
                return StringUtil.substringAfter(post.getAttribute(ID_ATTRIBUTE), '_');
            } catch (RuntimeException e) {
                AqualityServices.getLogger().info("Incorrect id " + ID_ATTRIBUTE);
            }
            return null;
        }).collect(Collectors.toList()).contains(postId);
    }
}

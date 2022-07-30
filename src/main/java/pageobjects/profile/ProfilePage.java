package pageobjects.profile;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProfilePage extends BasePage {
    private final By UsernameImg = By.cssSelector(".user-pic");
    private final By articlesList = By.xpath("//div[@class='article-preview']");
    private final By editProfileSettingsButton = By.cssSelector(".btn-outline-secondary");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying Profile page UI elements");

        log.info("Verifying Article list is displayed");
        softAssert.assertTrue(verifyIsDisplayed(articlesList), "Article list is not displayed");

        log.info("Verifying username img is displayed");
        softAssert.assertTrue(verifyIsDisplayed(UsernameImg), "username img is not displayed");

        log.info("Verifying edit Profile Settings Button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(editProfileSettingsButton), "edit Profile Settings Button is not displayed");

        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(articlesList, this.getClass().getSimpleName());
    }

    public void clickOnUsernameImg() {
        log.info("Clicking on new Account link");
        click(UsernameImg);
    }

    public void clickOnEditProfileSettingsButton() {
        log.info("Clicking on edit Profile Settings Button");
        click(editProfileSettingsButton);
    }

    public void verifyArticleWasDelete(String text) {
        for (WebElement article : getElementList(articlesList)
        ) {
            var arcticleTitle = article.getText();
            if (!arcticleTitle.equals(text)) {
                Assert.assertFalse(false);
            }
        }
    }
}


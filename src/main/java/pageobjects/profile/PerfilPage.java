package pageobjects.profile;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.user.UserPage;

public class PerfilPage extends BasePage {
    private final By articlesList = By.xpath("//div[@class='article-preview']");
    private final By UsernameImg= By.cssSelector(".user-pic");

    public PerfilPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying Profile page UI elements");

        softAssert.assertTrue(verifyIsDisplayed(articlesList), "Article list is not displayed");
        softAssert.assertTrue(verifyIsDisplayed(UsernameImg), "username img is not displayed");

        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(articlesList, this.getClass().getSimpleName());
    }

    public void clickOnHaveAccountlink() {
        log.info("Clicking on new Account link");
        click(UsernameImg);
    }

    public void verifyArticleWasDelete(String text){
        for (WebElement article:getElementList(articlesList)
        ) {
            var arcticleTitle=article.getText();
            if (!arcticleTitle.equals(text)){
                Assert.assertFalse(false);
            }
        }
    }
}


package pageobjects.article;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.user.UserPage;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ArticlePage extends BasePage {
    private final By titleInput = By.cssSelector("input[placeholder='Article Title']");
    private final By articleAboutInput = with(By.tagName("input")).below(titleInput);
    private final By articleDetailInput = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
    private final By tagInput = By.cssSelector("input[placeholder='Enter tags']");
    private final By publishButton = By.cssSelector("button[type='button']");

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(titleInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying Article page UI elements");

        log.info("Verifying title Input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(titleInput), "title Input is not displayed");

        log.info("Verifying article About Input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(articleAboutInput), "article About Input is not displayed");

        log.info("Verifying Article Detail Input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(articleDetailInput), "article Detail Input is not displayed");

        log.info("Verifying tag Input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(tagInput), "tag Detail Input is not displayed");

        log.info("Verifying publish Button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(publishButton), "publish Button is not displayed");

        softAssert.assertAll();
    }

    public void fillArticle(String titulo, String asunto, String detalle, String etiqueta) {
        log.info("Filling titulo");
        type(titleInput, titulo);

        log.info("Filling asunto");
        type(articleAboutInput, asunto);

        log.info("Filling detalle");
        type(articleDetailInput, detalle);

        log.info("Filling etiqueta");
        type(tagInput, etiqueta);

        log.info("Clicking on publish button");
        click(publishButton);
    }
}

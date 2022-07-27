package pageobjects.article;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PostCommentPage extends BasePage {
    private String title;
    private final By username = By.cssSelector("a[class='author']");

    private By titleLabel() {
        var locator = String.format("//h1[text()='%s']", title);
        return By.xpath(locator);
    }

    public PostCommentPage(WebDriver driver) {
        super(driver);
    }

    public void setTitle(String title) {
        System.out.println("que titulo viaja" + title);
        this.title = title;
    }

    @Override
    public void waitPageToLoad() {
        waitPage(username,this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying PostComment page UI elements");

        log.info("Verifying title label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(titleLabel()), "title label is not displayed");

        softAssert.assertAll();
    }

    public void verifyTitleIsDisplayed() {
        log.info("Verifying title label  is displayed");
        Assert.assertTrue(verifyIsDisplayed(titleLabel()));
    }
}

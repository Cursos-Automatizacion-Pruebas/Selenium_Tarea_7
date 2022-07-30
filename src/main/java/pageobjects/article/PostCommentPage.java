package pageobjects.article;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PostCommentPage extends BasePage {
    private String title;
    private final By username = By.cssSelector("a[class='author']");
    private final By commentInput = By.cssSelector("textarea[placeholder='Write a comment...']");
    private final By postCommentButtton = By.cssSelector("Button[type='submit']");
    private final By viewComment = By.cssSelector("p[class='card-text']");
    private final By deleteButton = By.cssSelector("i[class='ion-trash-a']");
    private final By editArticleButton = By.cssSelector(".btn-outline-secondary");
    private final By deleteArticleButton = By.cssSelector(".btn-outline-danger");

    private By titleLabel() {
        var locator = String.format("//h1[text()='%s']", title);
        return By.xpath(locator);
    }

    public PostCommentPage(WebDriver driver) {
        super(driver);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void waitPageToLoad() {
        waitPage(username, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying PostComment page UI elements");

        log.info("Verifying title label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(titleLabel()), "title label is not displayed");

        log.info("Verifying comment text area is displayed");
        softAssert.assertTrue(verifyIsDisplayed(commentInput), "title comment text area is not displayed");

        log.info("Verifying post comment Button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(postCommentButtton), "title post comment Button is not displayed");

        log.info("Verifying comment publish card text is displayed");
        softAssert.assertTrue(verifyIsDisplayed(viewComment), "title comment publish card text is not displayed");

        log.info("Verifying delete Button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(deleteButton), "title delete Button is not displayed");

        softAssert.assertAll();
    }

    public void verifyTitleIsDisplayed() {
        log.info("Verifying title label  is displayed");
        Assert.assertTrue(verifyIsDisplayed(titleLabel()));
    }

    public void fillComments(String comment) {
        log.info("Filling comment");
        type(commentInput, comment);

        log.info("Clicking on post Comment button");
        click(postCommentButtton);
    }

    public void verifyCommentsIsDisplayed() {
        log.info("Verifying Comments is displayed");
        Assert.assertTrue(verifyIsDisplayed(viewComment));
    }

    public void clickOnDeleteButton() {
        log.info("Clicking on Delete Button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        click(deleteButton);
        ((JavascriptExecutor) driver).executeScript("location.reload()");
    }

    public void verifyCommentWasDelete() {
        log.info("Verifying Comments is displayed");
        Assert.assertFalse(verifyIsDisplayed(viewComment));
    }

    public void clickOnEditArticleButton() {
        log.info("Clicking on edit Article Button");
        click(editArticleButton);
    }

    public void clickOnDeleteArticleButton() {
        log.info("Clicking on delete Article Button");
        click(deleteArticleButton);
    }

    public void getTextTitle() {
        log.info("Verifying Title is displayed");
        waitVisibility(titleLabel());
    }
}

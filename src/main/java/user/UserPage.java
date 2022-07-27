package user;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserPage extends BasePage {

    private String username;
    private String email;
    private String password;

    private final By settingsButton = By.cssSelector("a[href='#settings']");
    private final By newPost= By.cssSelector("a[href='#editor']");

    public void setUsername(String username) {
        this.username = username;
    }

    private By usernameLabel() {
        var locator = String.format("//a[text()='%s']", username);
        return By.xpath(locator);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying login page UI elements");

        softAssert.assertTrue(verifyIsDisplayed(usernameLabel()), "username input is not displayed");
        softAssert.assertTrue(verifyIsDisplayed(settingsButton), "settings Button is not displayed");

        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(settingsButton, this.getClass().getSimpleName());
    }

    public void verifyUsernameIsDisplayed() {
        log.info("Verifying username label  is displayed");
        Assert.assertTrue(verifyIsDisplayed(usernameLabel()));
    }

    public void clickOnSettingsButton() {
        log.info("Clicking on setttings Button");
        click(settingsButton);
    }

    public void clickOnNewPostButton() {
        log.info("Clicking on new post Button");
        click(newPost);
    }
}

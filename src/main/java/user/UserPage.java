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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void verifyUsernameIsDisplayed(String username) {
        log.info("Verifying username label  is displayed");
        Assert.assertEquals(verifyIsDisplayed(usernameLabel()), username);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void clickOnSettingsButton() {
        log.info("Clicking on setttings Button");
        System.out.println("Antes de dar clic a setttings");
        click(settingsButton);
        System.out.println("Despues de dar clic setttings");
    }


}

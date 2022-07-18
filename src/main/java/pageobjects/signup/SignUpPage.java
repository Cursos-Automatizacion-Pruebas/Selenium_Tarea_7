package pageobjects.signup;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage extends BasePage {
    private final By usernameInput = By.cssSelector("input[placeholder='Username']");
    private final By emailInput = By.cssSelector("input[placeholder='Email']");
    private final By passwordInput = By.cssSelector("input[placeholder='Password']");
    private final By sumbitbutton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.xpath("//ul[@class='error-messages']");
    private final By haveAccount = By.xpath("//a[text()='Have an account?']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying login page UI elements");

        log.info("Verifying username input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(usernameInput), "username input is not displayed");

        log.info("Verifying email input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(emailInput), "email input is not displayed");

        log.info("Verifying password input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput), "password input is not displayed");

        log.info("Verifying Sumbit button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(sumbitbutton), "Sumbit button is not displayed");

        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    public void fillLogin(String username, String email, String password) {
        log.info("Filling username");
        type(usernameInput, username);

        log.info("Filling email");
        type(emailInput, email);

        log.info("Filling password");
        type(passwordInput, password);

        log.info("Clicking on Sign Up button");
        click(sumbitbutton);
    }

    public void verifyErrorMessageText(String text) {
        log.info("Verifying error message content");
        Assert.assertEquals(getText(errorMessage), text);
    }

    public void clickOnHaveAccountlink() {
        log.info("Clicking on new Account link");
        click(haveAccount);
    }
}






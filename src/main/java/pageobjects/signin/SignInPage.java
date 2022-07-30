package pageobjects.signin;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private final By emailInput = By.cssSelector("input[placeholder='Email']");
    private final By passwordInput = By.cssSelector("input[placeholder='Password']");
    private final By sumbitbutton = By.cssSelector("button[type='submit']");
    private final By newAccount = By.xpath("//a[text()='Need an account?']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying login page UI elements");

        log.info("Verifying username input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(emailInput), "username input is not displayed");

        log.info("Verifying password input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput), "password input is not displayed");

        log.info("Verifying Sumbit button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(sumbitbutton), "Sumbit button is not displayed");

        log.info("Verifying question new Account is displayed");
        softAssert.assertTrue(verifyIsDisplayed(newAccount), "Question New Account is not displayed");

        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(emailInput, this.getClass().getSimpleName());
    }

    public void fillLogin(String email, String password) {
        log.info("Filling email");
        type(emailInput, email);

        log.info("Filling password");
        type(passwordInput, password);

        log.info("Clicking on Sign In button");
        click(sumbitbutton);
    }

    public void clickOnNewAccountlink() {
        log.info("Clicking on new Account link");
        click(newAccount);
    }
}

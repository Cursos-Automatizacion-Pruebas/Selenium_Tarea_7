package pageobjects.signup;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.DataProviders;

public class SignUpPage extends BasePage {
    private final By usernameInput = By.cssSelector("input[placeholder='Username']");
    private final By emailInput = By.cssSelector("input[placeholder='Email']");
    private final By passwordInput = By.cssSelector("input[placeholder='Password']");
    private final By sumbitbutton = By.cssSelector("button[type='submit']");
    private final By usernamelabel = By.xpath("//a[normalize-space()='u100']");

    //private final By usernamelabel=
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

    public void getUsername(){


    }
    //a[normalize-space()='mason.armstrong']
    /*public void verifyUsernameIsDisplayed() {
        //var credentials = new DataProviders().getUserData();
        //u100
        //final By usernamelabel = By.xpath("//a[normalize-space()="+"'"+credentials.getUser()+"']");
        log.info("Verifying locked message is displayed");
        //waitPage(usernamelabel, this.getClass().getSimpleName());
        waitPage(usernamelabel, this.getClass().getSimpleName());
        Assert.assertTrue(verifyIsEnabled(usernamelabel));
    }*/
}

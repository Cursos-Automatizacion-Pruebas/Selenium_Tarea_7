package signin;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.signin.SignInPage;
import pageobjects.signup.SignUpPage;
import pageobjects.user.UserPage;
import utilities.DataProviders;

public class SignInTest extends BaseTest {
    private SignInPage signInPage;
    private UserPage userPage;
    private SignUpPage signUpPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignIn();
    }

    @Test(groups = {regression})
    public void verifyLoginPageTest() {
        signInPage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyUsernameIsDisplayed() {
        var credentials = new DataProviders().getValidCredentials();
        signInPage.fillLogin(credentials.getEmail(), credentials.getPassword());
        userPage.waitPageToLoad();
        userPage.setUsername(credentials.getUsername());
        userPage.verifyUsernameIsDisplayed();
    }

    @Test(groups = {regression})
    public void verifySignUpPageIsDisplayed() {
        signInPage.clickOnNewAccountlink();
        signUpPage.waitPageToLoad();
    }

    @Override
    protected void initPages() {
        signInPage = new SignInPage(driver);
        userPage = new UserPage(driver);
        signUpPage = new SignUpPage(driver);
    }
}

package signup;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.signin.SignInPage;
import pageobjects.signup.SignUpPage;
import pageobjects.user.UserPage;
import utilities.DataProviders;

import java.time.Duration;

import static utilities.DataProviders.BAD_USER_INFO_DP;

public class SignUpTest extends BaseTest {
    private SignUpPage signUpPage;
    private UserPage userPage;
    private SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignUp();
    }

    @Test(groups = {regression})
    public void verifyLoginPageTest() {
        signUpPage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyUsernameIsDisplayed() {
        var credentials = new DataProviders().getUserData();
        signUpPage.fillLogin(credentials.getUser(), credentials.getEmail(), credentials.getPassword());
        userPage.waitPageToLoad();
        userPage.setUsername(credentials.getUser());
        userPage.verifyUsernameIsDisplayed();
    }

    @Test(groups = {regression}, dataProvider = BAD_USER_INFO_DP,
            dataProviderClass = DataProviders.class)
    public void errorMessageTest(String username, String email, String password, String errorMessageText) {
        signUpPage.fillLogin(username, email, password);
        signUpPage.waitPageToLoad();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signUpPage.verifyErrorMessageText(errorMessageText);
    }

    @Test(groups = {regression})
    public void verifySignInPageIsDisplayed() {
        signUpPage.clickOnHaveAccountlink();
        signInPage.waitPageToLoad();
    }

    @Override
    protected void initPages() {
        userPage = new UserPage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
    }
}

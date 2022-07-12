package signup;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.signup.SignUpPage;
import pageobjects.signup.UserPage;
import utilities.DataProviders;

public class SignUpTest extends BaseTest {
    private SignUpPage signUpPage;
    private UserPage userPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToIndex();
    }

    @Test(groups = {smoke})
    public void verifyLoginPageTest() {
        signUpPage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyUsernameIsDisplayed() {
        var credentials = new DataProviders().getUserData();
        signUpPage.fillLogin(credentials.getUser(),credentials.getEmail(),credentials.getPassword());
        userPage.waitPageToLoad();
        userPage.setUsername(credentials.getUser());
        userPage.verifyUsernameIsDisplayed();
    }

    @Override
    protected void initPages() {
        userPage=new UserPage(driver);
        signUpPage = new SignUpPage(driver);
    }
}

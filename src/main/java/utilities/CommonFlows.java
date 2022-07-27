package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.Home.HomePage;
import pageobjects.settings.SettingsPage;
import pageobjects.signin.SignInPage;
import pageobjects.signup.SignUpPage;
import user.UserPage;

import java.time.Duration;

public class CommonFlows {
    private final Logs log = new Logs();
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSignUp() {
        var homePage = new HomePage(driver);
        var signUpPage = new SignUpPage(driver);

        homePage.goToIndex();
        homePage.clickOnSignUplink();
        signUpPage.waitPageToLoad();
    }

    public void goToSignIn() {
        var homePage = new HomePage(driver);
        var signInPage = new SignInPage(driver);

        homePage.goToIndex();
        homePage.clickOnSignIplink();
        signInPage.waitPageToLoad();
    }

    public void loginValidUser() {
        var validCredentials = new DataProviders().getValidCredentials();
        var homePage = new HomePage(driver);
        var signInPage = new SignInPage(driver);

        homePage.waitPageToLoad();
        homePage.clickOnSignIplink();
        signInPage.fillLogin(validCredentials.getEmail(), validCredentials.getPassword());
    }

    public void goToArticle() {
        loginValidUser();
        var userpage = new UserPage(driver);
        userpage.waitPageToLoad();
        userpage.clickOnNewPostButton();
    }

    public void goToSettings() {
        loginValidUser();
        var userPage = new UserPage(driver);
        var settingsPage = new SettingsPage(driver);
        userPage.waitPageToLoad();
        userPage.clickOnSettingsButton();
        settingsPage.waitPageToLoad();
    }


}

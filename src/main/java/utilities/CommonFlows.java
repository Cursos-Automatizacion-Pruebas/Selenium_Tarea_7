package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.Home.HomePage;
import pageobjects.article.ArticlePage;
import pageobjects.article.PostCommentPage;
import pageobjects.profile.ProfilePage;
import pageobjects.settings.SettingsPage;
import pageobjects.signin.SignInPage;
import pageobjects.signup.SignUpPage;
import pageobjects.user.UserPage;

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

    public void fillArticle() {
        var articlePage = new ArticlePage(driver);
        var postCommentPage = new PostCommentPage(driver);
        var articles = new DataProviders().getArticleData();

        articlePage.fillArticle(articles.getTitulo(), articles.getAsunto(), articles.getDetalle(), articles.getEtiqueta());
        postCommentPage.waitPageToLoad();
        postCommentPage.setTitle(articles.getTitulo());
        postCommentPage.getTextTitle();
    }

    public void goToProfile() {
        loginValidUser();
        var userpage = new UserPage(driver);
        var profilePage = new ProfilePage(driver);
        userpage.waitPageToLoad();
        profilePage.clickOnUsernameImg();
        profilePage.waitPageToLoad();
    }
}

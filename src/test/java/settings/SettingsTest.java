package settings;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Home.HomePage;
import pageobjects.settings.SettingsPage;
import pageobjects.user.UserPage;
import utilities.DataProviders;

public class SettingsTest extends BaseTest {
    private SettingsPage settingsPage;
    private HomePage homePage;
    private UserPage userPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSettings();
    }

    @Override
    protected void initPages() {
        userPage = new UserPage(driver);
        settingsPage = new SettingsPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(groups = {regression})
    public void verifySettingsPageTest() {
        settingsPage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyHomePageIsDisplayed() {
        userPage.waitPageToLoad();
        userPage.clickOnSettingsButton();
        settingsPage.clickOnLogoutButton();
        homePage.waitPageToLoad();
    }

    @Test(groups = {regression})
    public void verifyBioIsDisplayed() {
        var settings = new DataProviders().getSettingsData();
        settingsPage.fillSettings(settings.getUrlProfile(), settings.getBio(), settings.getPassword());
        userPage.waitPageToLoad();
        userPage.clickOnSettingsButton();
        settingsPage.waitPageToLoad();
        settingsPage.verifyBioText(settings.getBio());
    }


}

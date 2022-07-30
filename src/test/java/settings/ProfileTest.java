package settings;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.profile.ProfilePage;
import pageobjects.settings.SettingsPage;

public class ProfileTest extends BaseTest {
    private ProfilePage profilePage;
    private SettingsPage settingsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToProfile();
    }

    @Override
    protected void initPages() {
        profilePage = new ProfilePage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test(groups = {regression})
    public void verifyProfilePageTest() {
        profilePage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyProfileSettingsTest() {
        profilePage.clickOnEditProfileSettingsButton();
        settingsPage.verifyPage();
    }
}

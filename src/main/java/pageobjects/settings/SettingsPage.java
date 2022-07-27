package pageobjects.settings;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.accessibility.AccessibleAction;

public class SettingsPage extends BasePage{
    private final By logoutbutton =By.cssSelector(".btn-outline-danger");
    private final By urlProfileInput =By.cssSelector("input[placeholder='URL of profile picture']");
    private final By bioInput =By.cssSelector("textarea[placeholder='Short bio about you']");
    private final By passwordInput =By.cssSelector("input[placeholder='New Password']");
    private final By updateButton = By.cssSelector("button[type='submit']");
    private final By yourSetting = By.cssSelector(".text-xs-center");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(logoutbutton,this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying Settings page UI elements");

        log.info("Verifying logout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(logoutbutton), "logout button is not displayed");

        log.info("Verifying logout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(urlProfileInput), "url Profile Input is not displayed");

        log.info("Verifying logout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(bioInput), "bio Input is not displayed");

        log.info("Verifying logout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput), "password button is not displayed");

        log.info("Verifying logout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(updateButton), "update button is not displayed");

        softAssert.assertAll();
    }

    public void clickOnLogoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        log.info("Clicking on Logout Button");
        click(logoutbutton);
    }

    public void fillSettings(String url,String bio, String password) {
        log.info("Filling url");
        type(urlProfileInput, url);

        log.info("Filling bio");
        type(bioInput, bio);

        log.info("Filling password");
        type(passwordInput, password);

        log.info("Clicking on update settings Button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        click(updateButton);
    }

    public void verifyBioText(String text) throws InterruptedException {
        log.info("Verifying bio content");
        Thread.sleep(10000);
        //var aa= getText(bioInput);
       // System.out.println("actual"+ aa);
        Assert.assertEquals(getText(yourSetting), text);
        Thread.sleep(10000);
    }

}


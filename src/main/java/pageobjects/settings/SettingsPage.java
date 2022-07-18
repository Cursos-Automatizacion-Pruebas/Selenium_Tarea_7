package pageobjects.settings;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.accessibility.AccessibleAction;

public class SettingsPage extends BasePage{
    private final By logoutbutton =By.cssSelector(".btn-outline-danger");

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

        softAssert.assertAll();
    }

    public void clickOnLogoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        log.info("Clicking on Logout Button");
        click(logoutbutton);
    }
}


package pageobjects.Home;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By signUplink = By.cssSelector("a[href='#register']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying Home page UI elements");

        log.info("Verifying signUp link is displayed");
        softAssert.assertTrue(verifyIsDisplayed(signUplink), "username input is not displayed");
        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(signUplink, this.getClass().getSimpleName());
    }

    public void clickOnSignUplink() {
        log.info("Clicking on signUp link");
        click(signUplink);
    }
}

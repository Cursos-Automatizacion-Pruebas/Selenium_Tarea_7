package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.Home.HomePage;
import pageobjects.signup.SignUpPage;

public class CommonFlows {
    private final Logs log = new Logs();
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var homePage =new HomePage(driver);
        var signUpPage = new SignUpPage(driver);

        homePage.goToIndex();
        homePage.clickOnSignUplink();
        signUpPage.waitPageToLoad();
    }
}

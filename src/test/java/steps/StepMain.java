package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

import java.security.SecureRandom;

public class StepMain {
    private static WebDriver driver;
    private MainPage mainPage;

    public StepMain(WebDriver driver) {
        StepMain.driver = driver;
        mainPage = new MainPage(driver);
    }

    @Step("Click on Login")
    public void execClickLogin() {
        mainPage.clickLoginBtn();
    }
}

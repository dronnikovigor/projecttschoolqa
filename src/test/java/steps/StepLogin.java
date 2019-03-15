package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.security.SecureRandom;

public class StepLogin {
    private static WebDriver driver;
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();
    private LoginPage loginPage;

    public StepLogin(WebDriver driver) {
        StepLogin.driver = driver;
        loginPage = new LoginPage(driver);
    }

    @Step("Fill in Login")
    public void execFillInLogin(String login) {
        loginPage.fillInLogin(login);
    }

    @Step("Fill in Password")
    public void execFillInPwd(String password) {
        loginPage.fillInPwd(password);
    }

    @Step("Click on Login")
    public void execClickLogin() {
        loginPage.clickLoginBtn();
    }

    @Step("Click on Sign Up")
    public void execClickSignUp() {
        loginPage.clickSignUpBtn();
    }


    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}

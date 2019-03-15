package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

public class StepSignUp {
    private static WebDriver driver;
    private SignUpPage signUpPage;

    public StepSignUp(WebDriver driver) {
        StepSignUp.driver = driver;
        signUpPage = new SignUpPage(driver);
    }

    @Step("Fill in Username")
    public void execFillInUsername(String username) {
        signUpPage.fillInUsername(username);
    }

    @Step("Fill in Password")
    public void execFillInPwd(String password) {
        signUpPage.fillInPwd(password);
    }

    @Step("Fill in Email")
    public void execFillInEmail(String email) {
        signUpPage.fillInEmail(email);
    }

    @Step("Click on Next")
    public void execClickNext() {
        signUpPage.clickNextBtn();
    }
}

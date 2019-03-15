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

    @Step("Click on Next in Personal Info")
    public void execClickNextPersonal() {
        signUpPage.clickNextPersonalBtn();
    }

    @Step("Fill in Name")
    public void execFillInName(String name) {
        signUpPage.fillInName(name);
    }
    @Step("Fill in Last Name")
    public void execFillInLastName(String lastName) {
        signUpPage.fillInLastName(lastName);
    }
    @Step("Fill in Email Input")
    public void execFillInEmailInput(String email) {
        signUpPage.fillInEmailInput(email);
    }
    @Step("Fill in Birthday")
    public void execFillInBirthday(String birthdate) {
        signUpPage.fillInBirthDate(birthdate);
    }
    @Step("Fill in PassportNumber")
    public void execFillInPassportNumber(String passportNumber) {
        signUpPage.fillInPassport(passportNumber);
    }
    @Step("Fill in Passport From")
    public void execFillInPassportFrom(String passportFrom) {
        signUpPage.fillInPassportIssuedFrom(passportFrom);
    }
    @Step("Fill in Passport When")
    public void execFillInPassportWhen(String passportWhen) {
        signUpPage.fillInPassportIssuedWhen(passportWhen);
    }

}

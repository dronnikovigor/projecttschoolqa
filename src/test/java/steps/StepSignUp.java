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
    @Step("Click on Next in Address Info")
    public void execClickNextAddress() {
        signUpPage.clickNextAddressBtn();
    }
    @Step("Click on SignUp")
    public void execClickSignUp() {
        signUpPage.clickSignUpBtn();
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

    @Step("Fill in Address Country")
    public void execFillInAddressCountry(String addressCountry) {
        signUpPage.fillInAddressCountry(addressCountry);
    }
    @Step("Fill in Address City")
    public void execFillInAddressCity(String addressCity) {
        signUpPage.fillInAddressCity(addressCity);
    }
    @Step("Fill in Address Street")
    public void execFillInAddressStreet(String addressStreet) {
        signUpPage.fillInAddressStreet(addressStreet);
    }
    @Step("Fill in Address Zipcode")
    public void execFillInAddressZipcode(String addressZipcode) {
        signUpPage.fillInAddressZipcode(addressZipcode);
    }
    @Step("Fill in Address House Number")
    public void execFillInAddressHouseNumber(String addressHouseNumber) {
        signUpPage.fillInAddressHouseNumber(addressHouseNumber);
    }

    @Step("Select Tariff")
    public void execSelectTariff(String tariff) {
        signUpPage.selectTariff(tariff);
    }

    @Step("Check Email for valid errors")
    public boolean execCheckEmailValidErrors() {
        return signUpPage.checkEmailValidError();
    }
    @Step("Check Username for required errors")
    public boolean execCheckLoginRequiedErrors() {
        return signUpPage.checkLoginRequiedError();
    }
    @Step("Check Username for valid errors")
    public boolean execCheckLoginValidErrors() {
        return signUpPage.checkLoginValidError();
    }
    @Step("Check Password for required errors")
    public boolean execCheckPasswordRequiedErrors() {
        return signUpPage.checkPwdRequiedError();
    }
    @Step("Check Password for valid errors")
    public boolean execCheckPasswordValidErrors() {
        return signUpPage.checkPwdValidError();
    }
    @Step("Check Email for errors")
    public boolean execCheckEmailErrors() {
        return signUpPage.checkEmailError();
    }
    @Step("Check Fields for empty errors")
    public boolean execCheckEmptyFieldErrors() {
        return signUpPage.checkEmptyError();
    }
    @Step("Check User exists error")
    public boolean execCheckUserExistsError() {
        return signUpPage.checkUserExistsError();
    }

}

package pages;

import common.Env;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {
    private WebDriver driver;

    private static String PAGE_URL = "http://" + Env.HOST + ":8080/#/signUp";

    @FindBy(xpath = "//*[@id=\"login_username\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"login_email\"]")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"login_password\"]")
    private WebElement password;
    @FindBy(xpath = "/html/body/app-root/div/div/signup/div/div/div/form/div/button")
    private WebElement nextBtn;

    @FindBy(xpath = "//*[@id=\"nameInput\"]")
    private WebElement nameInput;
    @FindBy(xpath = "//*[@id=\"LastNameInput\"]")
    private WebElement lastNameInput;
    @FindBy(xpath = "//*[@id=\"emailInput\"]")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"birthDate\"]")
    private WebElement birthDate;
    @FindBy(xpath = "//*[@id=\"passportNumberInput\"]")
    private WebElement passportNumberInput;
    @FindBy(xpath = "//*[@id=\"passportIssuedByWhom\"]")
    private WebElement passportIssuedFrom;
    @FindBy(xpath = "//*[@id=\"passportIssuedWhen\"]")
    private WebElement passportIssuedWhen;
    @FindBy(xpath = "/html/body/app-root/div/div/signup/div/div/clr-wizard/clr-modal/div/div[1]/div/div[1]/div/div[3]/div/div/clr-wizard-button[3]/button")
    private WebElement nextPersonalBtn;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement addressCountry;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement addressCity;
    @FindBy(xpath = "//*[@id=\"street\"]")
    private WebElement addressStreet;
    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    private WebElement addressZipcode;
    @FindBy(xpath = "//*[@id=\"houseNumber\"]")
    private WebElement addressHouseNumber;
    @FindBy(xpath = "/html/body[@class='no-scrolling']/app-root/div[@id='mainCont']/div/signup/div[@class='content-container']/div[@id='signUpPage']/clr-wizard[@class='clr-wizard wizard-lg']/clr-modal[@class='ng-tns-c2-0']/div[@class='modal ng-tns-c2-0']/div[@class='modal-dialog ng-trigger ng-trigger-fadeDown modal-lg']/div[@class='modal-outer-wrapper']/div[@class='modal-content-wrapper']/div[@class='modal-content']/div[@class='modal-footer clr-wizard-footer']/div[@class='clr-wizard-footer-buttons']/div[@class='clr-wizard-footer-buttons-wrapper']/clr-wizard-button[@class='clr-wizard-btn-wrapper'][3]/button[@class='btn clr-wizard-btn btn-primary clr-wizard-btn--primary']")
    private WebElement nextAddressBtn;

    @FindBy(xpath = "/html/body[@class='no-scrolling']/app-root/div[@id='mainCont']/div/signup/div[@class='content-container']/div[@id='signUpPage']/clr-wizard[@class='clr-wizard wizard-lg lastPage']/clr-modal[@class='ng-tns-c2-0']/div[@class='modal ng-tns-c2-0']/div[@class='modal-dialog ng-trigger ng-trigger-fadeDown modal-lg']/div[@class='modal-outer-wrapper']/div[@class='modal-content-wrapper']/div[@class='modal-content']/div[@class='modal-body']/main[@class='clr-wizard-content']/clr-wizard-page[@id='clr-wizard-page-2']/div[@class='form-group']/div[@class='select']/select[@id='selects_1']")
    private WebElement tariffSelect;

    @FindBy(xpath = "/html/body[@class='no-scrolling']/app-root/div[@id='mainCont']/div/signup/div[@class='content-container']/div[@id='signUpPage']/clr-wizard[@class='clr-wizard wizard-lg lastPage']/clr-modal[@class='ng-tns-c2-0']/div[@class='modal ng-tns-c2-0']/div[@class='modal-dialog ng-trigger ng-trigger-fadeDown modal-lg']/div[@class='modal-outer-wrapper']/div[@class='modal-content-wrapper']/div[@class='modal-content']/div[@class='modal-footer clr-wizard-footer']/div[@class='clr-wizard-footer-buttons']/div[@class='clr-wizard-footer-buttons-wrapper']/clr-wizard-button[@class='clr-wizard-btn-wrapper'][4]/button[@class='btn clr-wizard-btn btn-primary clr-wizard-btn--primary btn-success']/span")
    private WebElement signUpBtn;


    @FindBy(xpath = "//label[contains(@role, 'tooltip')]")
    private List<WebElement> tooltips;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkEmailValidError() {
        return driver.getPageSource().contains("Must be a valid email!");
    }
    public boolean checkLoginRequiedError() {
        return driver.getPageSource().contains("Login is required!");
    }
    public boolean checkLoginValidError() {
        return driver.getPageSource().contains("Username must be at least 4 characters long.");
    }
    public boolean checkPwdRequiedError() {
        return driver.getPageSource().contains("Password is required!");
    }
    public boolean checkPwdValidError() {
        return driver.getPageSource().contains("Password must be at least 6 characters long.");
    }

    public boolean checkEmailError() {
        return tooltips.stream().anyMatch(webElement -> webElement.getAttribute("class").contains("invalid"));
        //return !driver.findElements(By.cssSelector("label.tooltip.tooltip-validation.tooltip-md.tooltip-top-left.invalid")).isEmpty();
    }
    public boolean checkEmptyError() {
        return tooltips.stream().anyMatch(webElement -> webElement.getAttribute("class").contains("invalid"));
        /*return !(driver.findElements(By.cssSelector("label.tooltip.tooltip-validation.tooltip-md.tooltip-top-left.invalid")).isEmpty() ||
                driver.findElements(By.cssSelector("label.tooltip.tooltip-validation.tooltip-md.tooltip-bottom-right.invalid")).isEmpty());*/
    }
    public boolean checkUserExistsError() {
        return driver.findElement(By.cssSelector("#clr-wizard-page-2 > clr-alert > div > div > div")).getText().contains("Username or email is already taken.");
    }

    public void clickNextBtn() {
        this.nextBtn.click();
    }
    public void clickNextPersonalBtn() {
        this.nextPersonalBtn.click();
    }
    public void clickNextAddressBtn() {
        this.nextAddressBtn.click();
    }
    public void clickSignUpBtn() {
        this.signUpBtn.click();
    }


    public void fillInUsername(String login) {
        this.username.sendKeys(login);
    }
    public void fillInEmail(String email) {
        this.email.sendKeys(email);
    }
    public void fillInPwd(String pwd) {
        this.password.sendKeys(pwd);
    }

    public void clickUsername() {
        this.username.click();
    }
    public void clickEmail() {
        this.email.click();
    }
    public void clickPwd() {
        this.password.click();
    }

    public void fillInName(String name) {
        this.nameInput.sendKeys(name);
    }
    public void fillInLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }
    public void clickName() {
        this.nameInput.click();
    }
    public void clickLastName() {
        this.lastNameInput.click();
    }
    public void fillInEmailInput(String email) {
        this.emailInput.clear();
        this.emailInput.sendKeys(email);
    }
    public void fillInBirthDate(String birthDate) {
        this.birthDate.sendKeys(birthDate);
    }
    public void fillInPassport(String passport) {
        this.passportNumberInput.sendKeys(passport);
    }
    public void clickPassport() {
        this.passportNumberInput.click();
    }
    public void fillInPassportIssuedFrom(String passportIssuedFrom) {
        this.passportIssuedFrom.sendKeys(passportIssuedFrom);
    }
    public void clickPassportIssuedFrom() {
        this.passportIssuedFrom.click();
    }
    public void fillInPassportIssuedWhen(String passportIssuedWhen) {
        this.passportIssuedWhen.sendKeys(passportIssuedWhen);
    }

    public void fillInAddressCountry(String addressCountry) {
        this.addressCountry.sendKeys(addressCountry);
    }
    public void fillInAddressCity(String addressCity) {
        this.addressCity.sendKeys(addressCity);
    }
    public void fillInAddressStreet(String addressStreet) {
        this.addressStreet.sendKeys(addressStreet);
    }
    public void fillInAddressZipcode(String addressZipcode) {
        this.addressZipcode.sendKeys(addressZipcode);
    }
    public void fillInAddressHouseNumber(String addressHouseNumber) {
        this.addressHouseNumber.sendKeys(addressHouseNumber);
    }

    public void selectTariff(String tariff) {
        this.tariffSelect.sendKeys(tariff);
    }

    public boolean checkEmailEquals(String email) {
        return this.emailInput.getText().equals(email);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;

    private static String PAGE_URL = "http://0.0.0.0:8080/#/signUp";

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
    @FindBy(xpath = "/html/body/app-root/div/div/signup/div/div/clr-wizard/clr-modal/div/div[1]/div/div[1]/div/div[2]/main/clr-wizard-page[1]/form/section/div[6]/input")
    private WebElement passportIssuedFrom;
    @FindBy(xpath = "//*[@id=\"passportIssuedWhen\"]")
    private WebElement passportIssuedWhen;
    @FindBy(xpath = "/html/body/app-root/div/div/signup/div/div/clr-wizard/clr-modal/div/div[1]/div/div[1]/div/div[3]/div/div/clr-wizard-button[3]/button")
    private WebElement nextPersonalBtn;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNextBtn() {
        this.nextBtn.click();
    }
    public void clickNextPersonalBtn() {
        this.nextPersonalBtn.click();
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

    public void fillInName(String name) {
        this.nameInput.sendKeys(name);
    }
    public void fillInLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }
    public void fillInEmailInput(String email) {
        this.emailInput.sendKeys(email);
    }
    public void fillInBirthDate(String birthDate) {
        this.birthDate.sendKeys(birthDate);
    }
    public void fillInPassport(String passport) {
        this.passportNumberInput.sendKeys(passport);
    }
    public void fillInPassportIssuedFrom(String passportIssuedFrom) {
        this.passportIssuedFrom.sendKeys(passportIssuedFrom);
    }
    public void fillInPassportIssuedWhen(String passportIssuedWhen) {
        this.passportIssuedWhen.sendKeys(passportIssuedWhen);
    }
}

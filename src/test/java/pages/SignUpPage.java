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

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNextBtn() {
        this.nextBtn.click();
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


}

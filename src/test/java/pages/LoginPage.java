package pages;

import common.Env;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    private static String PAGE_URL = "http://" + Env.HOST + ":8080/#/login";

    @FindBy(xpath = "/html/body/app-root/div/div/login/div/div/div/form/div/input[1]")
    private WebElement loginField;
    @FindBy(xpath = "/html/body/app-root/div/div/login/div/div/div/form/div/input[2]")
    private WebElement pwdField;
    @FindBy(xpath = "/html/body/app-root/div/div/login/div/div/div/form/div/button")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/app-root/div/div/login/div/div/div/form/div/a")
    private WebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void fillInLogin(String login) {
        loginField.sendKeys(login);
    }

    public void fillInPwd(String pwd) {
        pwdField.sendKeys(pwd);
    }

    public void clickSignUpBtn() {
        signUpBtn.click();
    }
    public boolean checkInvalidDataError() {
        return driver.findElement(By.cssSelector("#signUpLog > div > div")).getText().contains("Invalid user name or password");
    }
}

package pages;

import common.Env;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    private static String PAGE_URL = "http://" + Env.HOST + ":8080/#/main-page/main-tariff";

    @FindBy(xpath = "/html/body/app-root/div[@id='mainCont']/div/main-page/header[@class='header-6']/div[@class='header-actions']/a[@id='logout']/clr-icon")
    private WebElement loginBtn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}

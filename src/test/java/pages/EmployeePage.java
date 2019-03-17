package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/div[@id='mainCont']/div/employee/div[@class='content-container']" +
            "/clr-vertical-nav[@id='navVert']/div[@class='nav-content']/a[@class='nav-link'][1]")
    private WebElement tariffLink;

    @FindBy(xpath = "/html/body/app-root/div[@id='mainCont']/div/employee/div[@class='content-container']" +
            "/clr-vertical-nav[@id='navVert']/div[@class='nav-content']/a[@class='nav-link'][2]")
    private WebElement optionLink;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnTariffLink() {
        tariffLink.click();
    }

    public void clickOnOptionLink() {
        optionLink.click();
    }

}

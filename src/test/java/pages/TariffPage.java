package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TariffPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/div[@id='mainCont']/div/employee/div[@class='content-container']" +
            "/div[@class='content-area']/tariffs/div[@class='col-md-9']/div[@id='search-pan']/button[@class='btn btn-icon']")
    private WebElement createTariffButton;

    @FindBy(xpath = "//input[@id = 'nameInput']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id = 'descrInput']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id = 'costInput']")
    private WebElement costInput;

    @FindBy(xpath = "//input[@id = 'smsInput']")
    private WebElement smsInput;

    @FindBy(xpath = "//input[@id = 'callsInput']")
    private WebElement callsInput;

    @FindBy(xpath = "//input[@id = 'intInput']")
    private WebElement internetInput;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    private WebElement addTariffButton;

    @FindBy(xpath = "//button[contains(@class,'btn btn-outline')][2]")
    private WebElement buttonCancel;

    @FindBy(xpath = "//button[contains(@class,'btn btn-outline')][2]")
    private WebElement buttonOK;

    @FindBy(xpath = "//clr-stack-label[@class='customers']")
    private List<WebElement> tariffs;

    public TariffPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnTariffButton() {
        createTariffButton.click();
    }

    public TariffPage setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }

    public TariffPage setDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
        return this;
    }

    public TariffPage setCost(String cost) {
        costInput.clear();
        costInput.sendKeys(cost);
        return this;
    }

    public TariffPage setSms(String sms) {
        smsInput.clear();
        smsInput.sendKeys(sms);
        return this;
    }

    public TariffPage setCalls(String calls) {
        callsInput.clear();
        callsInput.sendKeys(calls);
        return this;
    }

    public TariffPage setInternet(String internet) {
        internetInput.clear();
        internetInput.sendKeys(internet);
        return this;
    }

    public void clickOnAddTariff() {
        addTariffButton.click();
    }

    public boolean addButtonIsEnabled() {
        String attr = addTariffButton.getAttribute("disabled");
        return attr == null;
    }

    public boolean tariffIsExists(String name) {
        return tariffs.stream().anyMatch(webElement -> webElement.getText().contains(name));
    }

    public void clickOnOKButton() {
        buttonOK.click();
    }
}

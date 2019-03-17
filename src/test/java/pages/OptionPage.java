package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OptionPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/div[@id='mainCont']/div/employee/div[@class='content-container']" +
            "/div[@class='content-area']/options/div[@class='col-md-9']/div[@id='search-pan']/button[@class='btn btn-icon'][1]")
    private WebElement createOptionButton;

    @FindBy(xpath = "//input[@id = 'nameInput']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id = 'descrInput']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id = 'costInput']")
    private WebElement costInput;

    @FindBy(xpath = "//input[@id = 'costOfConnectionInput']")
    private WebElement costOfConnectionInput;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    private WebElement addOptionButton;

    @FindBy(xpath = "//button[contains(@class,'btn btn-outline')][2]")
    private WebElement buttonCancel;

    @FindBy(xpath = "//button[contains(@class,'btn btn-outline')][2]")
    private WebElement buttonOK;

    @FindBy(xpath = "//clr-stack-label[@class='customers']")
    private List<WebElement> options;

    @FindBy(xpath = "//div[contains(@class, 'alert-item')]")
    private WebElement optionAlert;

    public OptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnOptionButton() {
        createOptionButton.click();
    }

    public OptionPage setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }

    public OptionPage setDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
        return this;
    }

    public OptionPage setCost(String cost) {
        costInput.clear();
        costInput.sendKeys(cost);
        return this;
    }

    public OptionPage setCostOfConnection(String cost) {
        costOfConnectionInput.clear();
        costOfConnectionInput.sendKeys(cost);
        return this;
    }

    public void clickOnAddOption() {
        addOptionButton.click();
    }

    public boolean addButtonIsEnabled() {
        String attr = addOptionButton.getAttribute("disabled");
        return attr == null;
    }

    public boolean optionIsExists(String name) {
        return options.stream().anyMatch(webElement -> webElement.getText().contains(name));
    }

    public void clickOnOKButton() {
        buttonOK.click();
    }

    public String getMessageFromAlert() {
        return optionAlert.getText();
    }
}

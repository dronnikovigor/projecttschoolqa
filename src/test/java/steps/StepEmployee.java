package steps;

import io.qameta.allure.Step;
import model.Option;
import model.Tariff;
import org.openqa.selenium.WebDriver;
import pages.EmployeePage;
import pages.OptionPage;
import pages.TariffPage;

public class StepEmployee {

    private static WebDriver driver;
    private EmployeePage employeePage;
    private TariffPage tariffPage;
    private OptionPage optionPage;

    public StepEmployee(WebDriver driver) {
        StepEmployee.driver = driver;
        employeePage = new EmployeePage(driver);
        tariffPage = new TariffPage(driver);
        optionPage = new OptionPage(driver);
    }

    @Step("Click on tariff link")
    public void clickOnTariffLink() {
        employeePage.clickOnTariffLink();
    }

    @Step("Click on option link")
    public void clickOnOptionLink() {
        employeePage.clickOnOptionLink();
    }

    @Step("Click on tariff creation button")
    public void clickOnTariffCreationButton() {
        tariffPage.clickOnTariffButton();
    }

    @Step("Click on option creation button")
    public void clickOnOptionCreationButton() {
        optionPage.clickOnOptionButton();
    }

    @Step("Fill Option")
    public void fillOption(Option option) {
        optionPage.setName(option.getName())
                .setDescription(option.getDescription())
                .setCost(option.getCost())
                .setCostOfConnection(option.getCostOfConnection());
    }

    @Step("Fill tariff")
    public void fillTariff(Tariff tariff) {
        tariffPage.setName(tariff.getName())
                .setDescription(tariff.getDescription())
                .setCost(tariff.getCost())
                .setSms(tariff.getSms())
                .setCalls(tariff.getCalls())
                .setInternet(tariff.getInternet());
    }

    @Step("Check add button")
    public boolean addTariffButtonIsEnabled() {
        return tariffPage.addButtonIsEnabled();
    }

    @Step("Check add button")
    public boolean addOptionButtonIsEnabled() {
        return optionPage.addButtonIsEnabled();
    }

    @Step("Add tariff")
    public void addTariff() {
        tariffPage.clickOnAddTariff();
    }

    @Step("Add tariff")
    public void addOption() {
        optionPage.clickOnAddOption();
    }

    @Step("Check that tariff was created")
    public boolean tariffHasCreated(String name) {
        return tariffPage.tariffIsExists(name);
    }

    @Step("Check that tariff message was showed")
    public boolean tariffMessageWasShowed(String message) {
        return message.equals(tariffPage.getMessageFromAlert().trim());
    }

    @Step("Check that tariff message was showed")
    public boolean optionMessageWasShowed(String message) {
        return message.equals(optionPage.getMessageFromAlert().trim());
    }

    @Step("Check that option was created")
    public boolean optionHasCreated(String name) {
        return optionPage.optionIsExists(name);
    }

    @Step("Click on OK button")
    public void clickOnOKButtonTariff() {
        tariffPage.clickOnOKButton();
    }

    @Step("Click on OK button")
    public void clickOnOKButtonOption() {
        optionPage.clickOnOKButton();
    }
}

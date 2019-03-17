package steps;

import io.qameta.allure.Step;
import model.Tariff;
import org.openqa.selenium.WebDriver;
import pages.EmployeePage;
import pages.LoginPage;
import pages.TariffPage;

public class StepEmployee {

    private static WebDriver driver;
    private EmployeePage employeePage;
    private TariffPage tariffPage;

    public StepEmployee(WebDriver driver) {
        StepEmployee.driver = driver;
        employeePage = new EmployeePage(driver);
        tariffPage = new TariffPage(driver);
    }

    @Step("Click on tariff link")
    public void clickOnTariffLink() {
        employeePage.clickOnTariffLink();
    }

    @Step("Click on tariff creation button")
    public void clickOnTariffCreationButton() {
        tariffPage.clickOnTariffButton();
    }

    @Step("Create tariff")
    public void fillTariff(Tariff tariff) {
        tariffPage.setName(tariff.getName())
                .setDescription(tariff.getDescription())
                .setCost(tariff.getCost())
                .setSms(tariff.getSms())
                .setCalls(tariff.getCalls())
                .setInternet(tariff.getInternet());
    }

    @Step("Check add button")
    public boolean addButtonIsEnabled() {
        return tariffPage.addButtonIsEnabled();
    }

    @Step("Add tariff")
    public void addTariff() {
        tariffPage.clickOnAddTariff();
    }

    @Step("Check that tariff was created")
    public boolean tariffHasCreated(String name) {
        return tariffPage.tariffIsExists(name);
    }

    @Step("Click on OK button")
    public void clickOnOKButton() {
        tariffPage.clickOnOKButton();
    }
}

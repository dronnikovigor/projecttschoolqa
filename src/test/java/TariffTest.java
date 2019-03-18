import model.Tariff;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepEmployee;

public class TariffTest extends TestBase {

    @Test
    @DisplayName("TC-31")
    void createTariff() {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnTariffLink();
        stepEmployee.clickOnTariffCreationButton();
        Tariff tariff = new Tariff("New Tariff-TC31", "Super New 2019", "450",
                "50", "200", "500");
        stepEmployee.fillTariff(tariff);
        Assert.assertFalse(stepEmployee.dataInTariffIsIncorrect());
        Assert.assertTrue(stepEmployee.addTariffButtonIsEnabled());
        stepEmployee.addTariff();
        Assert.assertTrue(stepEmployee.tariffMessageWasShowed("Tariff have successfully added."));
        stepEmployee.clickOnOKButtonTariff();
        Assert.assertTrue(stepEmployee.tariffHasCreated(tariff.getName()));
    }


    @Test
    @DisplayName("TC-32-37")
    void createTariffNegative() {
        Tariff tariff = new Tariff("", "", "", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-38")
    void createTariffNegativeNameLong() {
        Tariff tariff = new Tariff("New Tariff-TC38 New Tariff-TC38 New Tariff-TC38",
                "", "", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-39")
    void createTariffNegativeDescriptionLong() {
        Tariff tariff = new Tariff("", "«New Tariff-TC38 New Tariff-TC38 New Tariff-TC38 New Tariff-TC38" +
                " New Tariff-TC38 New Tariff-TC38 New Tariff-TC38 New Tariff-TC38 New Tariff-TC38 New Tariff-TC38",
                "", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-40")
    void createTariffNegativeCostLong() {
        Tariff tariff = new Tariff("", "", "12345678901", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-41")
    void createTariffNegativeCostNotDigits() {
        Tariff tariff = new Tariff("", "", "cost", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-42")
    void createTariffNegativeCostZero() {
        Tariff tariff = new Tariff("", "", "0", "", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-43")
    void createTariffNegativeSMSLong() {
        Tariff tariff = new Tariff("", "", "", "123456789012", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-44")
    void createTariffNegativeSMSNotDigits() {
        Tariff tariff = new Tariff("", "", "", "sms", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-45")
    void createTariffNegativeSMSZero() {
        Tariff tariff = new Tariff("", "", "", "0", "", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-46")
    void createTariffNegativeCallsLong() {
        Tariff tariff = new Tariff("", "", "", "", "123456789012", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-47")
    void createTariffNegativeCallsNotDigits() {
        Tariff tariff = new Tariff("", "", "", "",
                "Number of minutes for outgoing calls", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-48")
    void createTariffNegativeCallsZero() {
        Tariff tariff = new Tariff("", "", "", "", "0", "");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-49")
    void createTariffNegativeInternetLong() {
        Tariff tariff = new Tariff("", "", "", "", "", "123456789012");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-50")
    void createTariffNegativeInternetNotDigits() {
        Tariff tariff = new Tariff("", "", "", "",
                "", "Mobile Internet");
        createTariff(tariff);
    }

    @Test
    @DisplayName("TC-51")
    void createTariffNegativeInternetZero() {
        Tariff tariff = new Tariff("", "", "", "", "", "0");
        createTariff(tariff);
    }

    private void createTariff(Tariff tariff) {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnTariffLink();
        stepEmployee.clickOnTariffCreationButton();
        stepEmployee.fillTariff(tariff);
        Assert.assertTrue(stepEmployee.dataInTariffIsIncorrect());
        Assert.assertFalse(stepEmployee.addTariffButtonIsEnabled());
    }
}

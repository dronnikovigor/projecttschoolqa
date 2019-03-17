import model.Tariff;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepEmployee;
import steps.StepLogin;

public class TariffTest extends TestBase {

    @Test
    @DisplayName("Create new tariff")
    void createTariff() {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnTariffLink();
        stepEmployee.clickOnTariffCreationButton();
        Tariff tariff = new Tariff("top tariff", "super", "100",
                "100", "100", "fghjk");
        stepEmployee.fillTariff(tariff);
        Assert.assertFalse(stepEmployee.addTariffButtonIsEnabled());
        Tariff tariff1 = new Tariff("top tariff", "super", "100",
                "100", "100", "100");
        stepEmployee.fillTariff(tariff1);
        Assert.assertTrue(stepEmployee.addTariffButtonIsEnabled());
        stepEmployee.addTariff();
        stepEmployee.clickOnOKButtonTariff();
        Assert.assertTrue(stepEmployee.tariffHasCreated(tariff.getName()));
    }
}

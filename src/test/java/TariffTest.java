import model.Tariff;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepEmployee;
import steps.StepLogin;

public class TariffTest extends TestBase {

    @Test
    @DisplayName("Login Test Case")
    void createTariff() {
        StepLogin loginPageSteps = new StepLogin(getDriver());
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        loginPageSteps.execFillInLogin("ivan_88");
        loginPageSteps.execFillInPwd("4321");
        loginPageSteps.execClickLogin();
        stepEmployee.clickOnTariffLink();
        stepEmployee.clickOnTariffCreationButton();
        Tariff tariff = new Tariff("top tariff", "super", "100",
                "100", "100", "fghjk");
        stepEmployee.fillTariff(tariff);
        Assert.assertFalse(stepEmployee.addButtonIsEnabled());
        Tariff tariff1 = new Tariff("top tariff", "super", "100",
                "100", "100", "100");
        stepEmployee.fillTariff(tariff1);
        Assert.assertTrue(stepEmployee.addButtonIsEnabled());
        stepEmployee.addTariff();
        stepEmployee.clickOnOKButton();
        Assert.assertTrue(stepEmployee.tariffHasCreated(tariff.getName()));
    }
}

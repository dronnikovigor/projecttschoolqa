import model.Option;
import model.Tariff;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepEmployee;


public class OptionTest extends TestBase {

    @Test
    @DisplayName("Tc-52")
    void createOption() {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnOptionLink();
        stepEmployee.clickOnOptionCreationButton();
        Option option = new Option("New Option-TC52", "Super New 2019", "100", "100");
        stepEmployee.fillOption(option);
        Assert.assertFalse(stepEmployee.dataInTariffIsIncorrect());
        Assert.assertTrue(stepEmployee.addOptionButtonIsEnabled());
        stepEmployee.addOption();
        Assert.assertTrue(stepEmployee.optionMessageWasShowed("Option have successfully added."));
        stepEmployee.clickOnOKButtonOption();
        Assert.assertTrue(stepEmployee.optionHasCreated(option.getName()));
    }

    @Test
    @DisplayName("Tc-53-56")
    public void createOptionNegative() {
        Option option = new Option("", "", "", "");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-57")
    public void createOptionNegativeName() {
        Option option = new Option("New Option-TC52 New Option-TC52 New Option-TC52" +
                " New Option-TC52 New Option-TC52 New Option-TC52",
                "", "", "");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-58")
    public void createOptionNegativeDescription() {
        Option option = new Option("", "«New Option-TC52 New Option-TC52 New Option-TC52 New Option-TC52 " +
                "New Option-TC52 New Option-TC52 New Option-TC52 New Option-TC52 New Option-TC52 New Option-TC52 " +
                "New Option-TC52 New Option-TC52", "", "");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-59")
    public void createOptionNegativeCost() {
        Option option = new Option("", "", "0", "");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-60")
    public void createOptionNegativeCostOfConnection() {
        Option option = new Option("", "", "", "0");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-61")
    public void createOptionNegativeCostLong() {
        Option option = new Option("", "", "12345678901", "");
        createOption(option);
    }

    @Test
    @DisplayName("Tc-62")
    public void createOptionNegativeCostOfConnectionLong() {
        Option option = new Option("", "", "", "12345678901");
        createOption(option);
    }


    private void createOption(Option option) {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnOptionLink();
        stepEmployee.clickOnOptionCreationButton();
        stepEmployee.fillOption(option);
        Assert.assertTrue(stepEmployee.dataInTariffIsIncorrect());
        Assert.assertFalse(stepEmployee.addOptionButtonIsEnabled());
    }
}

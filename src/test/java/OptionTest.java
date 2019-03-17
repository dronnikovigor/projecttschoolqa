import model.Option;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepEmployee;

public class OptionTest extends TestBase {

    @Test
    @DisplayName("Create new option")
    void createOption() {
        StepEmployee stepEmployee = new StepEmployee(getDriver());
        login();
        stepEmployee.clickOnOptionLink();
        stepEmployee.clickOnOptionCreationButton();
        Option option = new Option("top option", "super", "100", "meeee");
        stepEmployee.fillOption(option);
        Assert.assertFalse(stepEmployee.addOptionButtonIsEnabled());
        Option option1 = new Option("top option", "super", "100", "100");
        stepEmployee.fillOption(option1);
        Assert.assertTrue(stepEmployee.addOptionButtonIsEnabled());
        stepEmployee.addOption();
        Assert.assertTrue(stepEmployee.optionMessageWasShowed("Option have successfully added."));
        stepEmployee.clickOnOKButtonOption();
        Assert.assertTrue(stepEmployee.optionHasCreated(option1.getName()));
    }
}

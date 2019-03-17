import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepLogin;
import steps.StepSignUp;


@DisplayName("Site Test")
class SiteTest extends TestBase {

    @Test
    @DisplayName("Login Test Case")
    void testCase1() {
        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execFillInLogin("ivan_88");
        loginPageSteps.execFillInPwd("4321");
        loginPageSteps.execClickLogin();
    }

    @Test
    @DisplayName("SignUp Test Case")
    void testCase2() {
        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("123452");
        stepSignUp.execFillInEmail("123@123.ru");
        stepSignUp.execFillInPwd("123456");
        stepSignUp.execClickNext();

        stepSignUp.execFillInName("vasy");
        stepSignUp.execFillInLastName("pupkin");
        stepSignUp.execFillInBirthday("12/12/2000"); //TODO check how to fill in date
        stepSignUp.execFillInPassportNumber("1111111");
        stepSignUp.execFillInPassportFrom("spb");
        stepSignUp.execFillInPassportWhen("11/11/2001"); //TODO check how to fill in date
        stepSignUp.execClickNextPersonal();
    }

}

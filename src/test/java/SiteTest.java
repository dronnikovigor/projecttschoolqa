import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepLogin;
import steps.StepMain;
import steps.StepSignUp;


@DisplayName("Site Test")
class SiteTest extends TestBase {
    @Test
    @DisplayName("TC-1")
    void testCase1() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC1");
        stepSignUp.execFillInEmail("satelliteTC1@ma.il");
        stepSignUp.execFillInPwd("securepassTC1");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execCheckEmailEquals("satelliteTC1@ma.il");
        stepSignUp.execFillInBirthday("31/12/2000");
        stepSignUp.execFillInPassportNumber("NP123123TC1");
        stepSignUp.execFillInPassportFrom("GYVD");
        stepSignUp.execFillInPassportWhen("31/12/2016");

        stepSignUp.execClickNextPersonal();

        stepSignUp.execFillInAddressCountry("Russia");
        stepSignUp.execFillInAddressCity("St.Petersburg");
        stepSignUp.execFillInAddressStreet("Popova");
        stepSignUp.execFillInAddressZipcode("123");
        stepSignUp.execFillInAddressHouseNumber("5");
        stepSignUp.execClickNextAddress();

        stepSignUp.execSelectTariff("All in one");
        stepSignUp.execClickSignUp();

        Assert.assertFalse(stepSignUp.execCheckUserExistsError());
    }

    @Test
    @DisplayName("TC-2")
    void testCase2() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC2");
        stepSignUp.execFillInEmail("satelliteTC2@ma.il");
        stepSignUp.execFillInPwd("securepassTC2");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execCheckEmailEquals("satelliteTC2@ma.il");
        stepSignUp.execFillInPassportNumber("NP123123TC2");

        stepSignUp.execClickNextPersonal();

        stepSignUp.execClickNextAddress();

        stepSignUp.execClickSignUp();

        Assert.assertFalse(stepSignUp.execCheckUserExistsError());
    }


    @Test
    @DisplayName("TC-3")
    void testCase3() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execClickUsername();
        stepSignUp.execFillInEmail("satelliteTC3@ma.il");
        stepSignUp.execFillInPwd("securepassTC3");

        Assert.assertTrue(stepSignUp.execCheckLoginRequiedErrors());
    }

    @Test
    @DisplayName("TC-4")
    void testCase4() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC2");
        stepSignUp.execClickEmail();
        stepSignUp.execFillInPwd("securepassTC4");

        Assert.assertTrue(stepSignUp.execCheckEmailValidErrors());
    }

    @Test
    @DisplayName("TC-5")
    void testCase5() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC5");
        stepSignUp.execFillInEmail("satelliteTC5@ma.il");
        stepSignUp.execClickPwd();
        stepSignUp.execClickEmail(); //to remove focus from pwd to get error

        Assert.assertTrue(stepSignUp.execCheckPasswordRequiedErrors());
    }

    @Test
    @DisplayName("TC-6")
    void testCase6() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("TC6");
        stepSignUp.execFillInEmail("satelliteTC6@ma.il");
        stepSignUp.execFillInPwd("securepassTC6");

        Assert.assertTrue(stepSignUp.execCheckLoginValidErrors());
    }

    @Test
    @DisplayName("TC-7")
    void testCase7() {//
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6TC6");
        stepSignUp.execFillInEmail("satelliteTC7@ma.il");
        stepSignUp.execFillInPwd("securepassTC7");

        Assert.assertFalse(stepSignUp.execCheckLoginValidErrors());
    }

    @Test
    @DisplayName("TC-8")
    void testCase8() {//
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC8");
        stepSignUp.execFillInEmail("satelliteTC8@ma.");
        stepSignUp.execFillInPwd("securepassTC8");

        Assert.assertTrue(stepSignUp.execCheckEmailValidErrors());
    }

    @Test
    @DisplayName("TC-9")
    void testCase9() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC9");
        stepSignUp.execFillInEmail("satelliteTC9@ma.il");
        stepSignUp.execFillInPwd("pTC8");

        Assert.assertTrue(stepSignUp.execCheckPasswordValidErrors());
    }

    @Test
    @DisplayName("TC-10")
    void testCase10() {//
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC10");
        stepSignUp.execFillInEmail("satelliteTC10@ma.il");
        stepSignUp.execFillInPwd("TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10TC10");

        Assert.assertFalse(stepSignUp.execCheckPasswordValidErrors());
    }

    @Test
    @DisplayName("TC-12")
    void testCase12() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC12");
        stepSignUp.execFillInEmail("satelliteTC12@ma.il");
        stepSignUp.execFillInPwd("securepassTC12");

        stepSignUp.execClickNext();

        stepSignUp.execClickName();
        stepSignUp.execClickLastName();

        Assert.assertTrue(stepSignUp.execCheckEmptyFieldErrors());
    }

    @Test
    @DisplayName("TC-14")
    void testCase14() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC14");
        stepSignUp.execFillInEmail("satelliteTC14@ma.il");
        stepSignUp.execFillInPwd("securepassTC14");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Mr. Test-TC14");
        stepSignUp.execClickLastName();
        stepSignUp.execClickPassportNumber();

        Assert.assertTrue(stepSignUp.execCheckEmptyFieldErrors());
    }

    @Test
    @DisplayName("TC-15")
    void testCase15() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC15");
        stepSignUp.execFillInEmail("satelliteTC15@ma.il");
        stepSignUp.execFillInPwd("securepassTC15");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Mr. Test-TC15");
        stepSignUp.execClickLastName();
        stepSignUp.execClickPassportNumber();

        Assert.assertTrue(stepSignUp.execCheckEmptyFieldErrors());
    }

    @Test
    @DisplayName("TC-16")
    void testCase16() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC16");
        stepSignUp.execFillInEmail("satelliteTC16@ma.il");
        stepSignUp.execFillInPwd("securepassTC16");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execFillInEmailInput("satellite");
        Assert.assertTrue(stepSignUp.execCheckEmailErrors());
    }

    @Test
    @DisplayName("TC-17")
    void testCase17() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC16");
        stepSignUp.execFillInEmail("satelliteTC16@ma.il");
        stepSignUp.execFillInPwd("securepassTC16");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execClickPassportFrom();
        Assert.assertFalse(stepSignUp.execCheckEmptyFieldErrors());
    }

    @Test
    @DisplayName("TC-18")
    void testCase18() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC16");
        stepSignUp.execFillInEmail("satelliteTC16@ma.il");
        stepSignUp.execFillInPwd("securepassTC16");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execClickPassportFrom();
        Assert.assertFalse(stepSignUp.execCheckEmptyFieldErrors());
    }

    @Test
    @DisplayName("TC-26")
    void testCase26() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("Mr. Test-TC1");
        stepSignUp.execFillInEmail("satelliteTC1@ma.il");
        stepSignUp.execFillInPwd("securepassTC1");

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("Testname");
        stepSignUp.execFillInLastName("Testlastname");
        stepSignUp.execCheckEmailEquals("satelliteTC1@ma.il");
        stepSignUp.execFillInBirthday("31/12/2000");
        stepSignUp.execFillInPassportNumber("NP123123TC1");
        stepSignUp.execFillInPassportFrom("GYVD");
        stepSignUp.execFillInPassportWhen("31/12/2016");

        stepSignUp.execClickNextPersonal();

        stepSignUp.execFillInAddressCountry("Russia");
        stepSignUp.execFillInAddressCity("St.Petersburg");
        stepSignUp.execFillInAddressStreet("Popova");
        stepSignUp.execFillInAddressZipcode("123");
        stepSignUp.execFillInAddressHouseNumber("5");
        stepSignUp.execClickNextAddress();

        stepSignUp.execSelectTariff("All in one");
        stepSignUp.execClickSignUp();

        Assert.assertTrue(stepSignUp.execCheckUserExistsError());
    }

    @Test
    @DisplayName("TC-27")
    void testCase27() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execFillInLogin("Mr. Test-TC1");
        loginPageSteps.execFillInPwd("securepassTC1");
        loginPageSteps.execClickLogin();
    }

    @Test
    @DisplayName("TC-28")
    void testCase28() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execFillInLogin("Mr. Test-TC28");
        loginPageSteps.execFillInPwd("securepassTC28");
        loginPageSteps.execClickLogin();

        Assert.assertTrue(loginPageSteps.execCheckInvalidDataError());
    }

    @Test
    @DisplayName("TC-29")
    void testCase29() {
        StepMain stepMain = new StepMain(getDriver());
        stepMain.execClickLogin();

        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execFillInLogin("Mr. Test-TC1");
        loginPageSteps.execFillInPwd("securepassTC29");
        loginPageSteps.execClickLogin();

        Assert.assertTrue(loginPageSteps.execCheckInvalidDataError());
    }


    /*
    @Test
    @DisplayName("SignUp Test Case")
    void testCase0() {
        StepLogin loginPageSteps = new StepLogin(getDriver());
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(getDriver());
        stepSignUp.execFillInUsername("123452");
        stepSignUp.execFillInEmail("123@123.ru");
        stepSignUp.execFillInPwd("123456");
        Assert.assertFalse(stepSignUp.execCheckEmailValidErrors());
        Assert.assertFalse(stepSignUp.execCheckLoginRequiedErrors());
        Assert.assertFalse(stepSignUp.execCheckLoginValidErrors());
        Assert.assertFalse(stepSignUp.execCheckPasswordRequiedErrors());
        Assert.assertFalse(stepSignUp.execCheckPasswordValidErrors());

        stepSignUp.execClickNext();

        stepSignUp.execFillInName("vasy");
        stepSignUp.execFillInLastName("pupkin");
        stepSignUp.execFillInBirthday("12/12/2000");
        stepSignUp.execFillInPassportNumber("1111111");
        stepSignUp.execFillInPassportFrom("spb");
        stepSignUp.execFillInPassportWhen("11/11/2001");

        Assert.assertFalse(stepSignUp.execCheckEmptyFieldErrors());
        Assert.assertFalse(stepSignUp.execCheckEmailErrors());

        stepSignUp.execClickNextPersonal();

        stepSignUp.execFillInAddressCountry("Russia");
        stepSignUp.execFillInAddressCity("Spb");
        stepSignUp.execFillInAddressStreet("veteranov");
        stepSignUp.execFillInAddressZipcode("198000");
        stepSignUp.execFillInAddressHouseNumber("78");
        stepSignUp.execClickNextAddress();

        stepSignUp.execSelectTariff("All in one");
        stepSignUp.execClickSignUp();

        Assert.assertFalse(stepSignUp.execCheckUserExistsError());
    }
*/
}

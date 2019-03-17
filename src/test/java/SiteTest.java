import common.Env;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.StepLogin;
import steps.StepSignUp;

import java.io.File;
import java.util.concurrent.TimeUnit;


@DisplayName("Site Test")
class SiteTest {
    private static WebDriver driver;

    @BeforeEach
    void setup() {
        File file;
        if (Env.OS.equals("windows")) {
            file = new File("drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        } else {
            file = new File("drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Login Test Case")
    void testCase1() {
        StepLogin loginPageSteps = new StepLogin(driver);
        loginPageSteps.execFillInLogin("ivan_88");
        loginPageSteps.execFillInPwd("4321");
        loginPageSteps.execClickLogin();
    }

    @Test
    @DisplayName("SignUp Test Case")
    void testCase2() {
        StepLogin loginPageSteps = new StepLogin(driver);
        loginPageSteps.execClickSignUp();

        StepSignUp stepSignUp = new StepSignUp(driver);
        stepSignUp.execFillInUsername("43423142134");
        stepSignUp.execFillInEmail("fdsfsdf1@1.ru");
        stepSignUp.execFillInPwd("1123212");
        Assert.assertFalse(stepSignUp.execCheckEmailValidErrors());
        Assert.assertFalse(stepSignUp.execCheckLoginRequiedErrors());
        Assert.assertFalse(stepSignUp.execCheckLoginValidErrors());
        Assert.assertFalse(stepSignUp.execCheckPasswordRequiedErrors());
        Assert.assertFalse(stepSignUp.execCheckPasswordValidErrors());
        stepSignUp.execClickNext();

        stepSignUp.execFillInName("fdsfsd");
        stepSignUp.execFillInLastName("fsdafsd");
        stepSignUp.execFillInBirthday("12/12/2000");
        stepSignUp.execFillInPassportNumber("sfsdfadfsa");
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

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

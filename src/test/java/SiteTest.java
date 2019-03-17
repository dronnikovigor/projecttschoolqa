import common.Env;
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

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

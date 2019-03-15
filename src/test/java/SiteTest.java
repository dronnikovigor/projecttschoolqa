
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.StepLogin;
import steps.StepSignUp;

import java.io.File;
import java.util.concurrent.TimeUnit;


@DisplayName("Site Test")
class SiteTest {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        File file = new File("drivers/geckodriver");
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Login Test Case")
    void testCase1() {
        StepLogin loginPageSteps = new StepLogin(driver);
        loginPageSteps.execFillInLogin("123");
        loginPageSteps.execFillInPwd("123");
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
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}

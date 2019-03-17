import common.Env;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmployeePage;
import steps.StepLogin;

import java.io.File;
import java.util.concurrent.TimeUnit;

@DisplayName("Test Base")
public class TestBase {
    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

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

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}

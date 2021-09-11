package ui.tests;

import configProviders.ConfigFileReader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ConfigFileReader.ReadTestConfigurationProperties();
        String currentPath = System.getProperty("user.dir");
        String chromeDriverPath = Paths.get(currentPath, "drivers", "chromedriver.exe").toString();
        String firefoxDriverPath = Paths.get(currentPath, "drivers", "geckodriver.exe").toString();
        String edgeDriverPath = Paths.get(currentPath, "drivers", "msedgedriver.exe").toString();

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        switch (ConfigFileReader.browser.toLowerCase())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}

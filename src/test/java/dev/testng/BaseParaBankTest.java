package dev.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseParaBankTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/parabank/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
        Thread.sleep(5000);
    }
}

package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("userName")).sendKeys("Somapti");
        driver.findElement(By.tagName("textarea")).sendKeys("Somapti dfdsfsdfsdf");


        Thread.sleep(2000);
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("fahmida");
        driver.findElement(By.name("password")).sendKeys("fahmida");
        driver.findElement(By.className("Solutions")).click();
        driver.findElement(By.linkText("About Us")).click();
        driver.findElement(By.partialLinkText("in Pa")).click();
        driver.findElement(By.cssSelector(".leftmenu a[href='services.htm']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}

package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println(driver.findElement(By.id("framesWrapper")).getText());

        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.id("framesWrapper")).getText());

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        driver.close();
        driver.quit();
    }
}

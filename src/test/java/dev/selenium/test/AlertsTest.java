package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //simple alert/alert
        WebElement webElement = driver.findElement(By.id("alertButton"));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        wait.until(ExpectedConditions.alertIsPresent());
//        Thread.sleep(200);
        driver.switchTo().alert().accept();
//        Thread.sleep(200);


        //confirmButton
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(200);
        alert.dismiss();
        Thread.sleep(200);

        //promtButton
        driver.findElement(By.id("promtButton")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Shoaib");
        Thread.sleep(2000);
        System.out.println(promptAlert.getText());
        Thread.sleep(2000);
        promptAlert.accept();

        driver.quit();
    }
}

package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String originalWindow = driver.getWindowHandle();
//        driver.findElement(By.id("tabButton")).click();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        driver.close();

        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        windows = driver.getWindowHandles();
        System.out.println(windows.size());
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(originalWindow);

        Thread.sleep(2000);
        driver.close();
        if (driver.findElements(By.id("sampleHeading")).size() != 0) {
            driver.findElement(By.id("sampleHeading")).click();
        }


    }
}

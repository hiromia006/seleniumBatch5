package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DynamicLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println(driver.findElement(By.cssSelector(".orangehrm-login-logo img")).getAttribute("src"));

        // dynamic locators
        WebElement username = driver.findElement(By.cssSelector("input[name*='ernam']"));
        username.clear();
        username.sendKeys("Admin");
        System.out.println(username.isDisplayed());
        System.out.println(username.getTagName());
        System.out.println(username.getCssValue("font-size").trim());
        System.out.println(username.getRect().x+ "  "+ username.getRect().y);
        System.out.println(driver.findElement(By.cssSelector(".orangehrm-login-forgot-header")).getText().trim());

        WebElement password = driver.findElement(By.cssSelector("input[name^='pass']"));
        password.clear();
        password.sendKeys("admin123");

//        driver.findElement(By.cssSelector("button[class$='orangehrm-login-button']")).click();
        driver.findElement(By.cssSelector("form.oxd-form")).submit();
//        driver.findElement(By.className("oxd-form")).submit();
        Thread.sleep(3000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        if (links.size() != 0) {
            for (WebElement webElement : links) {
                String link = webElement.getAttribute("href").trim();
//            String linkValue = link != null ? link : "";
                if (link != null && !link.isEmpty()) {
                    System.out.println(link);
                }
            }
        }


        driver.quit();
    }
}

package dev.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//        WebElement country=driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(driver.findElement(By.cssSelector("select[name='country']")));
//        Select select=new Select(country);
        select.selectByValue("ALGERIA");
        Thread.sleep(2000);
//        select.deselectByValue("ALGERIA");
        Thread.sleep(2000);
        select.selectByIndex(3);
        Thread.sleep(2000);
//        select.deselectByIndex(3);
        Thread.sleep(2000);
        select.selectByVisibleText("AUSTRIA");

        for (WebElement option : select.getOptions()) {
            System.out.println(option.getText());
        }

        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.quit();
    }
}

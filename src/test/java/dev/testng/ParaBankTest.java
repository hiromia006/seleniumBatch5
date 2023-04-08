package dev.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankTest extends BaseParaBankTest {
    @Test(priority = 0)
    public void verifyTittleShouldSucceed() {
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle().trim(), "ParaBank | Welcome | Online Banking");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(priority = 1)
    public void verifyLoginPageShouldSucceed() {
        String loginText = driver.findElement(By.cssSelector("#leftPanel h2")).getText().trim();
        Assert.assertEquals(loginText, "Customer Login");
    }

    @Test(priority = 2)
    public void loginShouldSucceed() throws InterruptedException {
        WebElement usernameEl = driver.findElement(By.name("username"));
        usernameEl.clear();
        usernameEl.sendKeys("sqa");

        WebElement passwordEl = driver.findElement(By.name("password"));
        passwordEl.clear();
        passwordEl.sendKeys("sqa");

        driver.findElement(By.cssSelector("input.button")).click();
        Thread.sleep(1000);


        String logoutLinkTxt = driver.findElement(By.linkText("Log Out")).getText().trim();
        Assert.assertEquals(logoutLinkTxt, "Log Out");
    }

}

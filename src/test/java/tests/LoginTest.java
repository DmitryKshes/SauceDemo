package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login failed");
    }
    @Test
    public void loginWithoutPasswordTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String passwordRequiredNotification = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(passwordRequiredNotification, "Epic sadface: Password is required", "No notification for password");
    }

    @Test
    public void loginWithoutLoginTest() {
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String loginRequiredNotification = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(loginRequiredNotification, "Epic sadface: Username is required", "No notification for login");
    }

    @Test
    public void loginWithFalseCredentialsTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();
        String failedLoginNotification = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(failedLoginNotification, "Epic sadface: Username and password do not match any user in this service", "No notification for invalid data");
    }
}

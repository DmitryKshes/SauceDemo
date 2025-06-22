package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    private void enterUserName(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    private void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public ProductsPage login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLogin();

        return new ProductsPage(driver);
    }
}

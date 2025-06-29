package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By removeCheckoutButton = By.id("remove-sauce-labs-backpack");
    private final By itemInCheckout = By.id("inventory_item_name");
    private final By titleCheckoutPage = By.className("title");

    public String continueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        return driver.getCurrentUrl();
    }

    public boolean removeItemFromCheckout() {
        driver.findElement(removeCheckoutButton).click();
       return driver.findElements(removeCheckoutButton).isEmpty();
    }

    public void continueCheckoutProcess() {
        driver.findElement(checkoutButton).click();
    }

    public void productInCheckout() {
        driver.findElement(itemInCheckout);
    }

    public WebElement goToCheckoutPage() {
        return  driver.findElement(titleCheckoutPage);
    }
}

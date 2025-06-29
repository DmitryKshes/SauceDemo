package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void goToCheckoutPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user","secret_sauce");
        productsPage.getToShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        WebElement title = checkoutPage.goToCheckoutPage();
        Assert.assertEquals(title.getText(), "Your Cart", "not checkout page");
    }

    @Test
    public void goToProductsPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.getToShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String currentPage = checkoutPage.continueShoppingButton();
        Assert.assertEquals(currentPage, "https://www.saucedemo.com/inventory.html", "no products page");
    }

    @Test
    public void removeProductFromCheckoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart();
        productsPage.getToShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Boolean removedItem = checkoutPage.removeItemFromCheckout();
        Assert.assertTrue(removedItem, "no removed bottom");
    }

    @Test
    public void goToCheckoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart();
        productsPage.getToShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.continueCheckoutProcess();
        String continueCheckoutPage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(continueCheckoutPage, "Checkout: Your Information", "no continue checkout page");
    }

}

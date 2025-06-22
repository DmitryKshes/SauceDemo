package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart();
        String count = productsPage.countOfProductInShoppingCart();
        Assert.assertEquals(count, "1", "not added product in cart");
    }

    @Test
    public void getToProductCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.getToProductCart();
        String cartProductUrl = driver.getCurrentUrl();
        Assert.assertEquals(cartProductUrl, "https://www.saucedemo.com/inventory-item.html?id=4", "Not valid page");
    }

    @Test
    public void deleteProductFromShoppingCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart();
        productsPage.deleteProductFromShoppingCart();
        boolean count = productsPage.cartBadgeDisabled();
        Assert.assertEquals(count, false, "not deleted");
    }

}

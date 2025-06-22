package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By productImage = By.id("item_4_img_link");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By countOfProducts = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public void openBurgerMenu() {
       driver.findElement(burgerMenu).click();
    }

    public void getToProductCart() {
        driver.findElement(productImage).click();
    }

    public void addProductToCart() {
        driver.findElement(buttonAddToCart).click();
    }

    public String countOfProductInShoppingCart() {
        return driver.findElement(countOfProducts).getText();
    }

    public void deleteProductFromShoppingCart() {
        driver.findElement(removeButton).click();
    }

    public boolean cartBadgeDisabled() {
        return !driver.findElements(By.className("shopping_cart_badge")).isEmpty();
    }

}

package PageObject.App;
import org.openqa.selenium.WebDriver;
import PageObject.Pages.*;
public class Application {
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;
    public Application(WebDriver driver) {
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
    public void open() {
        mainPage.open();
    }
    private void addProductToCart() {
        mainPage.pickProduct();
        productPage.addToCart();
    }
    public void addProductsToCart(int number) {
        for (int i = 1; i <= number; ++i) {
            addProductToCart();
            if (i != number) {
                open();
            }
        }
    }
    public void goToCart() {
        productPage.goToCart();
    }
    public int getAddedProductsQuantity() {
        return cartPage.getProductsQuantityFromTable();
    }
    public void removeProducts(int number) {
        for (int i = 1; i <= number; ++i) {
            cartPage.removeProduct();
            if (i != number) {
                cartPage.waitProductsTablesUpdated();
            }
        }
    }
}

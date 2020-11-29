package PageObject.Test;
import org.junit.Test;
public class testProduct extends TestBase {
    @Test
    public void addAndRemoveProduct(){
        app.open();
        app.addProductsToCart(3);
        app.goToCart();
        app.removeProducts(app.getAddedProductsQuantity());
    }
}

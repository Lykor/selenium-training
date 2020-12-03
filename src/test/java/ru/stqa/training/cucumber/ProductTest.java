package ru.stqa.training.cucumber;
import io.cucumber.java8.En;
public class ProductTest extends CucumberBase implements En {
    protected int count;
    public ProductTest(){
        super();
        Then("^while size of bag is not (\\d+) - add new product$", (Integer countProducts) -> {
            app.addProductsToCart(countProducts);
            count = countProducts;
        });
        And("^open bag page$", () -> {
            app.goToCart();
        });
        And("^delete all products$", () -> {
            app.removeProducts(count);
        });
        Given("^open main page$", () -> {
            app.open();
        });
    }
}

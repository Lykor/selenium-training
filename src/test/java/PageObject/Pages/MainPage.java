package PageObject.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage extends Page {
    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="#box-most-popular li.product:first-child")
    private WebElement product;
    public void open(){
        driver.get("http://localhost/litecart/en/");
    }
    public void pickProduct(){
        product.click();
    }
}

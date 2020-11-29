package PageObject.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.App.Application;
public class TestBase {
    private WebDriver driver;
    public Application app;
    @Before
    public void start() {
        driver = new ChromeDriver();
        app = new Application(driver);
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}

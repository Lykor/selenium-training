package ru.stqa.training.selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Task_7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexander\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void Seven_Solution(){
        AdminEnter();
        List<WebElement> listElements = driver.findElements(By.cssSelector("li#app- > a"));
        for (int i = 0; i < listElements.size(); i++) {
            List<WebElement> f = driver.findElements(By.cssSelector("li#app- > a"));
            f.get(i).click();
            List<WebElement> s = driver.findElements(By.cssSelector("li#app-  li a"));
            for (int j = 0; j < s.size(); j++) {
                List<WebElement> newElement = driver.findElements(By.cssSelector("li#app-  li a"));
                newElement.get(j).click();
                if (FindedElement(driver, By.cssSelector("h1"))) {
                    System.out.println("На странице есть заголовок H1");
                } else {
                    System.out.println("На странице нет заголовка H1");
                }
            }
        }
    }

    public boolean FindedElement(WebDriver driver, By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void AdminEnter(){
        driver.get(" http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}

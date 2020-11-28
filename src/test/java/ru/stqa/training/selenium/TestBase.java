package ru.stqa.training.selenium;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @Before
    public void start()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexander\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }
    public void sleep(int n)
    {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginAdmin() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}

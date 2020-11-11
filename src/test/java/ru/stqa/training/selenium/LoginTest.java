package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexander\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
    }

    @Test
    public void AdminEnter(){
        driver.get(" http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }

    @Test
    public void hrefTest(){
        driver.get("http://localhost/litecart/admin/");
        wait.until(titleIs("My Store"));
        driver.findElement(By.xpath("//a")).click();
        wait.until(titleIs("Online Store | My Store"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}

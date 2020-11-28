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

import static org.junit.Assert.assertTrue;

public class Task_8 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexander\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void Eight_Solution(){
        driver.get("http://localhost/litecart/en/");
        List<WebElement> listElements = driver.findElements(By.cssSelector(".product"));
        for (WebElement i : listElements) {
            assertTrue((i.findElements(By.cssSelector(".sticker"))).size() == 1);
            System.out.println("У товара есть стикер");
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}

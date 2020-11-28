package ru.stqa.training.selenium;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task_10_Firefox extends Task_10{

    @Before
    @Override
    public void start()
    {
        System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

    }
}

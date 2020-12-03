package ru.stqa.training.cucumber;
import PageObject.App.Application;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberBase {
    protected WebDriver driver;
    protected static Application app;
    public CucumberBase(){
        driver = new ChromeDriver();
        app = new Application(driver);
    }
}

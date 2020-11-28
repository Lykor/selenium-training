package ru.stqa.training.selenium;

import org.junit.Before;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task_10_Edge extends Task_10 {
    @Before
    @Override
    public void start(){
        System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
    }
}

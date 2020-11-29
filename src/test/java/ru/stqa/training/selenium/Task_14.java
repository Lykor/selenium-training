package ru.stqa.training.selenium;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class Task_14 extends TestBase{
    @Test
    public void checkHRefs(){
        loginAdmin();
        wait.until(titleIs("My Store"));
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("#content .button")).click();
        wait.until(titleContains("Add New Country"));
        List<WebElement> hrefs = driver.findElements(By.cssSelector("#content table:not(#table-zones) a:not(#address-format-hint)"));
        for (WebElement href : hrefs){
            String durWindow = driver.getWindowHandle();
            Set<String> activeWindows = driver.getWindowHandles();
            href.click();
            String newWindow = wait.until(OtherWindow(activeWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(durWindow);
        }
    }
    public ExpectedCondition<String> OtherWindow(Set<String> oldWindows){
        return driver -> {
            if (driver == null)
                return null;
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
}

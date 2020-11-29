package ru.stqa.training.selenium;
import java.util.Calendar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Task_11 extends TestBase{
    @Test
    public void solution(){
        driver.get("http://localhost/litecart/en/");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        String email = "samuelrooble"+hour+"_"+minute+"_"+second+"@gmail.com";
        String password = "111111";
        registration(email,password);
        logout();
        login(email,password);
        logout();
    }
    protected void registration(String email,String password){
        driver.findElement(By.cssSelector("#box-account-login a")).click();
        sleep(500);
        driver.findElement(By.name("tax_id")).sendKeys("123456789");
        sleep(500);
        driver.findElement(By.name("company")).sendKeys("OmSTU");
        sleep(500);
        driver.findElement(By.name("firstname")).sendKeys("Valery");
        driver.findElement(By.name("lastname")).sendKeys("Jarkov");
        sleep(500);
        driver.findElement(By.name("address1")).sendKeys("Omsk mira 11");
        driver.findElement(By.name("address2")).sendKeys("Omsk mira 14");
        sleep(500);
        driver.findElement(By.name("postcode")).sendKeys("64405");
        driver.findElement(By.name("city")).sendKeys("Omsk");
        sleep(500);
        driver.findElement(By.cssSelector("td span.select2-selection__arrow")).click();
        WebElement searchCountryField = driver.findElement(By.cssSelector("input.select2-search__field"));
        searchCountryField.sendKeys("United States");
        searchCountryField.sendKeys(Keys.ENTER);
        sleep(500);
        /*wait.until(textToBePresentInElementLocated(By.cssSelector("select[name=zone_code]"),"Alabama"));*/
        sleep(500);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+11122233344");
        sleep(500);
        driver.findElement(By.name("newsletter")).click();
        sleep(500);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.cssSelector("select[name=zone_code]")).click();
        WebElement searchZonesField = driver.findElement(By.cssSelector("select[name=zone_code]"));
        searchZonesField.sendKeys("AK");
        searchZonesField.sendKeys(Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));
    }
    protected void login(String email,String password){
        sleep(500);
        wait.until(presenceOfElementLocated(By.name("email")));
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));
    }

    protected void logout(){
        sleep(500);
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child a")));
        driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
        wait.until(presenceOfElementLocated(By.name("email")));
    }

}

package ru.stqa.training.selenium;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import java.io.File;
public class Task_12 extends TestBase {
    @Test
    public void addNewProduct(){
        loginAdmin();
        wait.until(titleIs("My Store"));
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        int count = driver.findElements(By.cssSelector(".dataTable tr.row")).size();
        driver.findElement(By.cssSelector("#content a.button:last-child")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".active a[href='#tab-general']")));
        driver.findElement(By.cssSelector("[name=status][value='1']")).click();
        sleep(5000);
        driver.findElement(By.name("name[en]")).sendKeys("Noname");
        driver.findElement(By.name("code")).sendKeys("123");
        sleep(500);
        driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();
        driver.findElement(By.cssSelector("[value='1-2']")).click();
        clearAndFill(By.name("quantity"), "100");
        selectByValue(By.name("sold_out_status_id"),"1");
        driver.findElement(By.cssSelector("[type=file]")).sendKeys((new File("src/main/resources/noname.jpg").getAbsolutePath()));
        driver.findElement(By.name("date_valid_from")).sendKeys("23.11.2020");
        driver.findElement(By.name("date_valid_to")).sendKeys("31.12.2020");
        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".active a[href='#tab-information']")));
        selectByValue(By.name("manufacturer_id"),"1");
        driver.findElement(By.name("keywords")).sendKeys("noname");
        driver.findElement(By.name("short_description[en]")).sendKeys("noname");
        sleep(500);
        driver.findElement(By.name("description[en]")).sendKeys("noname");
        driver.findElement(By.name("head_title[en]")).sendKeys("noname from noname");
        driver.findElement(By.name("meta_description[en]")).sendKeys("new noname");
        sleep(500);
        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".active a[href='#tab-prices']")));
        clearAndFill(By.name("purchase_price"), "50");
        selectByValue(By.name("purchase_price_currency_code"),"EUR");
        driver.findElement(By.name("prices[USD]")).sendKeys("60");
        driver.findElement(By.name("prices[EUR]")).sendKeys("50");
        driver.findElement(By.name("save")).click();
        wait.until(presenceOfElementLocated(By.className("dataTable")));
        int countNew = driver.findElements(By.cssSelector(".dataTable tr.row")).size();
        assertEquals(count + 1, countNew);
    }

    public void selectByValue(By locator, String value){
        Select field = new Select(driver.findElement(locator));
        field.selectByValue(value);
    }

    public void clearAndFill(By locator, String value){
        WebElement field = driver.findElement(locator);
        field.clear();
        field.sendKeys(value);
    }
}

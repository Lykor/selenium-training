package ru.stqa.training.selenium;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
public class Task_10 extends TestBase{
    @Test
    public void checkCardProduct(){
        driver.get("http://localhost/litecart/en/");

        WebElement product = driver.findElement(By.cssSelector("#box-campaigns .product"));

        String Name = product.findElement(By.cssSelector(".name")).getAttribute("textContent");

        WebElement regularPrice = product.findElement(By.cssSelector(".regular-price"));
        WebElement campaignPrice = product.findElement(By.cssSelector(".campaign-price"));

        Price regularPriceview = new Price(regularPrice);
        Price campaignPriceview = new Price(campaignPrice);

        product.click();

        String Name1 = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");

        WebElement regularPrice1 = driver.findElement(By.cssSelector("#box-product .regular-price"));
        WebElement campaignPrice1 = driver.findElement(By.cssSelector("#box-product .campaign-price"));

        Price regularPriceviewSecond = new Price(regularPrice1);
        Price campaignPriceviewSecond = new Price(campaignPrice1);


        assertEquals(Name, Name1); // названия товара
        //совпадения цены
        assertEquals(regularPriceview.price, regularPriceviewSecond.price);
        assertEquals(campaignPriceview.price, campaignPriceviewSecond.price);
        //зачеркнутость и серость
        assertTrue(regularPriceview.color.red == regularPriceview.color.blue && regularPriceview.color.blue == regularPriceview.color.green);
        assertTrue(regularPriceviewSecond.color.red == regularPriceviewSecond.color.blue && regularPriceviewSecond.color.blue == regularPriceviewSecond.color.green);
        //жирность и красность
        assertTrue(campaignPriceview.isFat);
        assertTrue(campaignPriceview.color.blue == 0 && campaignPriceview.color.green == 0);
        assertTrue(campaignPriceviewSecond.isFat);
        assertTrue(campaignPriceviewSecond.color.blue == 0 && campaignPriceviewSecond.color.green == 0);
        //акционная цена крупнее
        assertTrue(regularPriceview.fontSize < campaignPriceview.fontSize);
        assertTrue(regularPriceviewSecond.fontSize < campaignPriceviewSecond.fontSize);
    }
}

package ru.stqa.training.selenium;
import org.openqa.selenium.WebElement;
public class Price {
    public ColorModel color;
    public String price;
    public boolean isFat;
    public String Class;
    public String tag;
    public Double fontSize;

    public Price(WebElement element) {
        price = element.getAttribute("textContent");
        Class = element.getAttribute("class");
        tag = element.getAttribute("tagName");
        String elementColorStr = element.getCssValue("color");
        color = setColor(elementColorStr);
        String elementFontSizeStr = element.getCssValue("font-size");
        fontSize = Double.parseDouble(elementFontSizeStr.substring(0, elementFontSizeStr.length() - 2));
        String fat = element.getCssValue("font-weight");
        isFat = element.getCssValue("font-weight").compareTo("700") == 0;
    }

    private ColorModel setColor(String colors){
        String[] numbers = colors.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        ColorModel color = new ColorModel();
        color.red = r;
        color.green = g;
        color.blue = b;
        return color;
    }
}

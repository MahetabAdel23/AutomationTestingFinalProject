package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsUtils {
    public static void clickOn(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
    public static void sendData(WebDriver driver, By locator, String data) {
        driver.findElement(locator).sendKeys(data);
    }
    public static void clearData(WebDriver driver, By locator) {
        driver.findElement(locator).clear();
    }
}

package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

private BasePage(){}

    public static String getCurrentUrl(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }

    public static String getPageSource(WebDriver driver)
    {
        return driver.getPageSource() ;
    }

    public static WebElement waitElement(WebDriver driver,By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isElementDisplayed(WebDriver driver,By locator)
    {
        try{
            return driver.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public static boolean waitForIsDisplayed(WebDriver driver,By locator)
    {
        try{
            waitElement(driver,locator);
            return true;
        }
        catch (TimeoutException e)
        {
            return false;
        }
    }

    public static boolean invisibilityOfElementAfterWait(WebDriver driver,By Locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
    }

    public static WebElement ClickablietyOfElementAfterWait(WebDriver driver,By Locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(Locator));
        return element;
    }

    public static void DropDownSelect(WebDriver driver,By locator, String value)
    {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }


    public static void waitAlert(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

    }

    public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept(); // Accept the alert to close it
        return alertText;
    }

    public static void hoverOverElement(WebDriver driver,By locator)
    {
        Actions actions= new Actions(driver);
        WebElement element = waitElement(driver,locator);
        actions.moveToElement(element).perform();
    }

    public static int ReadPrice(WebDriver driver,By locator)
    {
        driver.findElement(locator).isDisplayed();
        String priceText = driver.findElement(locator).getText();
        double priceValue = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)priceValue;
    }
    public static String ReadNo(WebDriver driver, By locator) {
        driver.findElement(locator).isDisplayed();
        return driver.findElement(locator).getText();

    }



}

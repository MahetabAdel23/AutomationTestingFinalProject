package Pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserOption {

    static Logger logger = Logger.getLogger(BrowserOption.class.getName()); // Make logger static

    public static WebDriver BrowserFactory(String browser)
    {
        logger= Logger.getLogger(BrowserOption.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.


        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
                firefoxDriver.manage().window().maximize();
                logger.info("Running test in " + browser);
                return firefoxDriver;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                logger.info("Running test in " + browser);
                return new ChromeDriver(chromeOptions);

            default:
                FirefoxOptions defaultFirefoxOptions = new FirefoxOptions();
                defaultFirefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriver defaultFirefoxDriver = new FirefoxDriver(defaultFirefoxOptions);
                defaultFirefoxDriver.manage().window().maximize();
                logger.info("Running test in FirefoxDriver as " + browser + " is not recognized");
                return defaultFirefoxDriver;
        }
    }
}

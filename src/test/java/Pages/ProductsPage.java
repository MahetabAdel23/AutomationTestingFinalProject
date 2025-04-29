package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    private By JacketSearchLocacator=By.xpath("//span[@class='base']");
    private By ErrorMessageLocacator=By.xpath("//main[@id='maincontent']//div[@class='message notice']");
    private By SortByLocator=By.xpath("(//label[@for='sorter'][normalize-space()='Sort By'])[1]");

    public boolean waitForJacketSearchDisplayed()
    {

        return BasePage.isElementDisplayed(driver,JacketSearchLocacator);
    }
    public boolean waitForNoResultItemMessageDisplayed()
    {
        return BasePage.isElementDisplayed(driver,ErrorMessageLocacator);
    }
    public boolean SortElementInvisibilityAfterWait()
    {
        return BasePage.invisibilityOfElementAfterWait(driver,SortByLocator);
    }


}


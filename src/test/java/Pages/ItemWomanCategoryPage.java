package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemWomanCategoryPage {
    WebDriver driver;
    private By JacketsCheckApperanceLocator=By.xpath("//strong[text()='Jackets']");
    private By SizeOptionLocator=By.xpath("//div[normalize-space()='Size']");
    private By SizeXsLocator=By.xpath("//a[@aria-label='XS']/div[text()='XS']");
    private By SizeXsCheckLocator=By.xpath("//span[@class='filter-value' and text()='XS']");
    private By ColorOptionLocator=By.xpath("//div[normalize-space()='Color']");
    private By ColorBlackLocator=By.xpath("//a[@aria-label='Black']//div[contains(@class,'swatch-option color')]");
    private By PriceJacketLocator=By.xpath("//span[@data-price-type='finalPrice']/span[@class='price']");
    private By SortByButtonLocator=By.xpath("(//select[@id='sorter'])[1]");
    private By SelectItemSizeSmallLocator=By.xpath("(//div[@id='option-label-size-143-item-167'])[2]");
    private By SelectItemColorGreenLcator=By.xpath("//div[@class='swatch-opt-1380']//div[@id='option-label-color-93-item-53']");
    private By AddItemToCartLocator=By.xpath("(//span[contains(text(),'Add to Cart')])[2]");
    private By AddToCartSuccessfulMessageLocator=By.xpath("(//div[@class='message-success success message'])[1]");
    private By ShoppingCartLinkLocator=By.xpath("//a[normalize-space()='shopping cart']");

    /*colors*/
    private By ColorBlackCheckLocator=By.xpath("//span[@class='filter-value' and text()='Black']");


    /*item sorted*/
    private By PriceSortedJacketLocator=By.xpath("//span[@data-price-type='finalPrice']/span[@class='price']");
    private By DescenditingButtonLocator=By.xpath("(//a[@title='Set Descending Direction'])[1]");

    /*UpdatedCartPage*/
    private By UpdateSummaryQtySubtotalValueLocator=By.xpath("//tr[@class='totals sub']//span[@data-th='Subtotal']");
    private By DiscountLocator=By.xpath("//td[@data-th='Discount'] //span[@class='price']");

    By MessageChooseOptionsForYourItemLocator=By.xpath("//div[text()='You need to choose options for your item.']");
    By ItemHallLocator=By.xpath("//div[@class='column main']//li[2]");
    By AddToFavoriteLocator=By.xpath("//div[@class=\"product-social-links\"]//a[@data-action=\"add-to-wishlist\"]");
By ClikeHereToContinuousShoopingLocator=By.xpath("//a[@href='https://magento.softwaretestingboard.com/juno-jacket.html']");
    public ItemWomanCategoryPage(WebDriver driver) {
        this.driver=driver;
    }
    public boolean waitForJacketDisplayedAfterWait()
    {
       return BasePage.waitForIsDisplayed(driver,JacketsCheckApperanceLocator);
    }

    public void clickSizeOption()
    {
       driver.findElement(SizeOptionLocator).click();
    }
    public void clickSizeXS()
    {

        driver.findElement(SizeXsLocator).click();
    }

    public void chooseSizeXs()
    {
        clickSizeOption();
        clickSizeXS();
    }

    public boolean isSizeXsCheckDisplayed()
    {

        return BasePage.isElementDisplayed(driver,SizeXsCheckLocator);
    }

    public void clickColorOption()
    {

        driver.findElement(ColorOptionLocator).click();
    }
    public void clickColorBlack()
    {

        WebElement element=BasePage.ClickablietyOfElementAfterWait(driver,ColorBlackLocator);
        element.click();
    }
    public  void chooseColorBlack()
    {
        clickColorOption();
        clickColorBlack();
    }



    public void printPrice()
    {
        List<WebElement> priceElements = driver.findElements(PriceJacketLocator);
          for (int index=0;index<priceElements.size();index++)
          {
                System.out.println(priceElements.get(index).getText());//get element then get elment text
          }

    }

    public void SortByPriceValue()
    {
       BasePage.DropDownSelect(driver,SortByButtonLocator, "price");
    }


    public void clickItemSizeSmalllocator()
    {
        WebElement element=BasePage.waitElement(driver,SelectItemSizeSmallLocator);
       element.click();
    }
    public void clickItemColorGreen()
    {
        ElementsUtils.clickOn(driver,SelectItemColorGreenLcator);
    }
    public void clickAddItemToCart()
    {
        ElementsUtils.clickOn(driver,AddItemToCartLocator);
    }

    public void addItemToCart()
    {
        clickItemSizeSmalllocator();
        clickItemColorGreen();
        clickAddItemToCart();
    }
    public boolean AddToCartSuccessfulMessageDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,AddToCartSuccessfulMessageLocator);
    }

    public void navigateIntoCartPage()
    {
        driver.findElement(ShoppingCartLinkLocator).click();
    }




    /*colors*/

    public boolean isColorBlackCheckDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,ColorBlackCheckLocator);
    }



/*item sorted*/
public void printSortedPrice()
{
    List<WebElement> priceElements = driver.findElements(PriceSortedJacketLocator);
    for (int i=0;i<priceElements.size();i++)
    {
        System.out.println(priceElements.get(i).getText());//get element then get elment text
    }

}

    public boolean isDescenditingButtonDisplayed()
    {
        return BasePage.isElementDisplayed(driver,DescenditingButtonLocator) ;
    }


    /*UpdatedCartPage*/
    public boolean UpdateSummaryQtySubtotalValueDisplay() {

        return BasePage.waitForIsDisplayed(driver,UpdateSummaryQtySubtotalValueLocator);
    }

    public boolean DiscountDisplay() {

        return BasePage.waitForIsDisplayed(driver,DiscountLocator);
    }
    public int ReadUpdateSummaryQtySubtotalValue()
    {
        /*
        driver.findElement(UpdateSummaryQtySubtotalValueLocator).isDisplayed();
        String priceText = driver.findElement(UpdateSummaryQtySubtotalValueLocator).getText();
        double priceSummaryQty = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)priceSummaryQty;*/

       return BasePage.ReadPrice(driver,UpdateSummaryQtySubtotalValueLocator);
    }

    public int ReadDiscountValue()
    {
        /*
        driver.findElement(DiscountLocator).isDisplayed();
        String priceText = driver.findElement(DiscountLocator).getText();
        double priceDiscount = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)priceDiscount;*/
        return BasePage.ReadPrice(driver,DiscountLocator);

    }
    public boolean MessageChooseOptionsForYourItemDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,MessageChooseOptionsForYourItemLocator);
    }
public void  hoverOverItem()
{
    BasePage.hoverOverElement(driver,ItemHallLocator);

}

    public void clickAddToFavoriteItem()
    {
        BasePage.waitElement(driver,AddToFavoriteLocator);
        ElementsUtils.clickOn(driver,AddToFavoriteLocator);
    }
    public void clickToContinuousShoping()
    {
        BasePage.waitElement(driver,ClikeHereToContinuousShoopingLocator);
        ElementsUtils.clickOn(driver,ClikeHereToContinuousShoopingLocator);
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
WebDriver driver;

    private By QtyLocator=By.xpath("//input[@title='Qty']");
    private By PageTitleLocator=By.xpath("//span[@data-ui-id='page-title-wrapper']");
    private By ItemColPriceLocator=By.xpath("//td[@class='col price']//span[@class='price']");
    private By ItemSubtotalPriceLocator=By.xpath("//td[@class='col subtotal']//span[@class='price']");
    private By DiscountPriceLocator=By.xpath("//td[@data-th='Discount']//span[@class='price']");
    private By EditItemButtonLocator=By.xpath("//a[@title='Edit item parameters']");
    private By ClearItemCartButtonLocator=By.xpath("//a[@class='action action-delete']");
    private By NoItemInCartLocator=By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
    private By DiscountCodeButtonLocator=By.xpath("//strong[@id='block-discount-heading']");
    private By CouponCodeButtonLocator=By.xpath("//input[@id='coupon_code']");
    private By ApplyDiscountButtonLocator=By.xpath("//span[normalize-space()='Apply Discount']");
    private By InvalidDiscountCodeLocator=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private By UpdateButtonLocator=By.xpath("//span[normalize-space()='Update Shopping Cart']");
    private By ProceedToCheckoutButtonLocator=By.xpath("//span[normalize-space()='Proceed to Checkout']");
/*edit cart*/
      By UpdateCartButtonLocator=By.xpath("//button[@id='product-updatecart-button']");
      By UpdateQtyItemLocator=By.xpath("//input[@id='qty']");
    /*cart page after edit*/
      By UpdateSuccessfulyMessageLocator=By.xpath("//div[@class='message-success success message']");

/*check out process*/
     By ShippingAddressTitleLocator=By.xpath("//div[normalize-space()='Shipping Address']");
     By ShippingValueAdded=By.xpath("//tr//span[text()='Shipping']");
     By ShippingLocator=By.xpath("//span[@data-th='Shipping']");
     By UpdateSummaryQtySubtotalValueLocator=By.xpath("//tr[@class='totals sub']//span[@data-th='Cart Subtotal']");
     By TotalOrderPriceLocator=By.xpath("//td[@data-th='Order Total']/strong/span");
     By OrderSummaryTittleLocator=By.xpath("//span[text()='Order Summary']");
     By PlaceOrderButtonLocator=By.xpath("//button[@title='Place Order']");
    By PlaceOrderButtonLocator2=By.xpath("//div[@class='primary']//button[@class='action primary checkout']");
    By  PlaceOrderButtonLocator3=By.xpath("//div[@id='checkout-payment-method-load']//button[@class='action primary checkout']");
    By  PlaceOrderButtonLocator4=By.xpath ("(//button[@title='Place Order'])[1]");
    By OrderPlacedSuccessfulyMessage=By.xpath("//span[text()='Thank you for your purchase!']");
    By AlertExciedQuantityOfItemMess=By.xpath("//footer[@class='modal-footer']//button[@class=\"action-primary action-accept\"]");
    By NextButtonShipping1=By.xpath("//button[@class='button action continue primary']");

    By OrderNoLocator=By.xpath("//a[@class='order-number']//strong");
    By SmallSize=By.xpath("//div[@attribute-code='size']//div[@option-label='S']");
     public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
    }


    public void UpdateQtyValue(String qty)
    {
        driver.findElement(QtyLocator).click();
        driver.findElement(QtyLocator).clear();
        driver.findElement(QtyLocator).sendKeys(qty);
    }
    public int getQtyElement()
    {
        int qty = Integer.parseInt(driver.findElement(QtyLocator).getAttribute("value"));
        return qty;
    }
    public boolean isPageTitleDisplayed()
    {
        return BasePage.isElementDisplayed(driver,PageTitleLocator);
    }
    public int getItemPriceValue()
    {
        String priceText = driver.findElement(ItemColPriceLocator).getText();
        double price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)price;
    }
    public int getItemSubtotalPriceValue()
    {
        driver.findElement(ItemSubtotalPriceLocator).isDisplayed();
        String priceText = driver.findElement(ItemSubtotalPriceLocator).getText();
        double price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)price;
    }
    public int getDiscountPriceValue()
    {
        driver.findElement(DiscountPriceLocator).isDisplayed();
        String priceText = driver.findElement(DiscountPriceLocator).getText();
        double price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        return (int)price;
    }
    public void clickEditItemButton()
    {
        driver.findElement(EditItemButtonLocator).click();

    }
    public boolean ClearItemInCartButton()
    {
        driver.findElement(ClearItemCartButtonLocator).click();
       return driver.findElement(NoItemInCartLocator).isDisplayed();
    }

    public void clickDiscountCodeButton()
    {
        driver.findElement(DiscountCodeButtonLocator).click();
    }
    public void EnterCouponCodeValue(String CouponValue)
    {
        driver.findElement(CouponCodeButtonLocator).click();
        driver.findElement(CouponCodeButtonLocator).sendKeys(CouponValue);
    }

    public void ApplyDiscountCode()
    {
        driver.findElement(ApplyDiscountButtonLocator).click();
    }
    public void executeDiscount(String CouponValue)
    {
        clickDiscountCodeButton();
        EnterCouponCodeValue(CouponValue);
        ApplyDiscountCode();

    }
    public boolean IsInvalidDiscountCodeMessageDisplayed()
    {
        return BasePage.isElementDisplayed(driver,InvalidDiscountCodeLocator);
    }

    public void clickUpdateButton()

    {
        driver.findElement(UpdateButtonLocator).click();
    }
    public void ConfirmUpdateQty(String QTY)
    {
        UpdateQtyValue(QTY);
        clickUpdateButton();
    }

    public void clickProceedToCheckoutButton()
    {
        driver.findElement(ProceedToCheckoutButtonLocator).click();
    }

    /*edit cart*/
    public boolean isUpdateCartButtonDisplayed()

    {
        return BasePage.isElementDisplayed(driver,UpdateCartButtonLocator);
    }
    public void UpdateQtyItem(String qty)
    {
        driver.findElement(UpdateQtyItemLocator).clear();
        driver.findElement(UpdateQtyItemLocator).sendKeys(qty);
    }
    public void confirmUpdateInItemCart()
    {
        ElementsUtils.clickOn(driver,UpdateCartButtonLocator);
    }

    /*cart page after edit*/
    public boolean isUpdateSuccessfulyMessageDisplayed()
    {
        return BasePage.isElementDisplayed(driver,UpdateSuccessfulyMessageLocator);
    }
    public String ReadQtyElementAfterUpdated()
    {

        driver.findElement(QtyLocator).isDisplayed();
        String qty = driver.findElement(QtyLocator).getText();
        return qty;
    }



    public boolean ShippingAddressTitleDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,ShippingAddressTitleLocator);
    }
    public boolean validateShippingValueAdded()
    {
        return BasePage.waitForIsDisplayed(driver,ShippingValueAdded);
    }
    public int ReadShippingValue()
    {

        return BasePage.ReadPrice(driver,ShippingLocator);

    }
    public int ReadUpdateSummaryQtySubtotalValue()
    {
        return BasePage.ReadPrice(driver,UpdateSummaryQtySubtotalValueLocator);
    }
    public int ReadTotalOrderPriceValue()
    {
        return BasePage.ReadPrice(driver,TotalOrderPriceLocator);
    }
    public boolean validateOrderSummaryTittleDispalyedAfterWait()
    {
        return BasePage.waitForIsDisplayed(driver,OrderSummaryTittleLocator);
    }
    public void clickPlaceOrderButton()
    {
       if(BasePage.waitForIsDisplayed(driver,PlaceOrderButtonLocator)==true)
       {
          ElementsUtils.clickOn(driver,PlaceOrderButtonLocator);
       }
    }
    public boolean validateOrderPlacedSuccesfuly()
    {
        return BasePage.waitForIsDisplayed(driver,OrderPlacedSuccessfulyMessage);
    }

    public boolean validateTotalPriceCalulatedCorrectly() {
        int qty = getQtyElement();
        int itemPrice = getItemPriceValue();
        int itemSubtotalPrice =getItemSubtotalPriceValue();
        int TotalPrice = qty * itemPrice;

        if(TotalPrice==itemSubtotalPrice)
        {
            System.out.println("Total price in shopping is: " + TotalPrice);
            System.out.println("itemSubtotalPrice in shopping: " + itemSubtotalPrice);

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean waitUntilDiscountDisplayed()
    {
      return  BasePage.waitForIsDisplayed(driver,DiscountPriceLocator);
    }

    public void clickOnOk()
    {
        if(BasePage.waitForIsDisplayed(driver,AlertExciedQuantityOfItemMess)==true)
        { ElementsUtils.clickOn(driver,AlertExciedQuantityOfItemMess);}
    }
    public void clickNextButtonShipping1()
    {
        if(BasePage.waitForIsDisplayed(driver,NextButtonShipping1)==true)
        {
        ElementsUtils.clickOn(driver,NextButtonShipping1);
        }
    }

    public String ReadOrderNo()
    {
        BasePage.waitElement(driver,OrderNoLocator);

        return BasePage.ReadNo(driver,OrderNoLocator);
    }
    public void clickSmallSize()throws Exception
    {
        Thread.sleep(15000);
        ElementsUtils.clickOn(driver,SmallSize);
    }


}

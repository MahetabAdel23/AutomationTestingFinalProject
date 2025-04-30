package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By WomenCategoryLocator = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women.html']");
    private By TopWomenCategoryLocator = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html']");
    private By JacketsWomenCategoryLocator = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']");


    private By SelectItemSizeSmallLocator = By.xpath("(//div[@id='option-label-size-143-item-167'])[2]");
    private By SelectItemColorGreenLcator = By.xpath("//div[@class='swatch-opt-1380']//div[@id='option-label-color-93-item-53']");
    private By AddItemToCartLocator = By.xpath("(//span[contains(text(),'Add to Cart')])[2]");

    private By AddToCartSuccessfulMessageLocator = By.xpath("(//div[@class='message-success success message'])[1]");
    private By ShoppingCartLinkLocator = By.xpath("//a[normalize-space()='shopping cart']");

    private By PageTitleShoppingCartLocator = By.xpath("//span[@data-ui-id='page-title-wrapper']");

    private By ProceedToCheckoutButtonLocator = By.xpath("//span[normalize-space()='Proceed to Checkout']");

    By LogInCustomerMenuLocator= By.xpath("//div[@class='panel header']//button[@data-action='customer-menu-toggle']");
/*signin*/

    By SignInPanelButtonLocator=By.xpath("//div[@class='panel header']//a[normalize-space(text())='Sign In']");
    By SignOutLocator=By.xpath("//li[@class='customer-welcome active']//a[normalize-space(text())='Sign Out']");
    By CreateAnAccountPanelLocator=By.xpath("//div[@class='panel header']//a[text()='Create an Account']");

/*products tests*/
    private By SearchLoactor=By.xpath("//input[@id='search']");
    private By OrdersAndReturnsLoactor=By.xpath("//a[@href='https://magento.softwaretestingboard.com/sales/guest/form/']");



    public void clickSignInPanelButton() {
        driver.findElement(SignInPanelButtonLocator).click();
    }

    public void hoverOverWomenCategory() {
        BasePage.hoverOverElement(driver, WomenCategoryLocator);
    }

    public void hoverOverTopWomenCategory() {
        BasePage.hoverOverElement(driver, TopWomenCategoryLocator);
    }

    public void clickJacketsWomenCategory() {
        driver.findElement(JacketsWomenCategoryLocator).click();
    }

    public void hoverOverJacketsWomenCategory() {

        BasePage.hoverOverElement(driver, JacketsWomenCategoryLocator);
    }

    public void NavigateWomenCategoryOptions() throws Exception{
        Thread.sleep(2000);
        hoverOverWomenCategory();
        hoverOverTopWomenCategory();
        hoverOverJacketsWomenCategory();
        clickJacketsWomenCategory();
    }


    public void clickItemSizeSmalllocator() {
        WebElement element = BasePage.waitElement(driver, SelectItemSizeSmallLocator);
        element.click();
    }

    public void clickItemColorGreen() {
        driver.findElement(SelectItemColorGreenLcator).click();
    }

    public void clickAddItemToCart() {
        driver.findElement(AddItemToCartLocator).click();
    }


    public void addItemToCart() {
        clickItemSizeSmalllocator();
        clickItemColorGreen();
        clickAddItemToCart();
    }

    public void validateAddToCartSuccessfulMessageDisplayed() {
        assertTrue(BasePage.waitForIsDisplayed(driver, AddToCartSuccessfulMessageLocator), "Add to cart message is not displayed");
    }
    public void navigateIntoCartPage() {
        driver.findElement(ShoppingCartLinkLocator).click();

    }

    public boolean ValidateisPageTitleShoppingCartDisplayed() {
        return BasePage.isElementDisplayed(driver, PageTitleShoppingCartLocator);
    }
    public void clickProceedToCheckoutButton() {
        driver.findElement(ProceedToCheckoutButtonLocator).click();

    }

    By ShippingAddressTitleLocator = By.xpath("//div[normalize-space()='Shipping Address']");

    public boolean ValidateShippingAddressTitleDisplayed() {
        return BasePage.waitForIsDisplayed(driver, ShippingAddressTitleLocator);
    }
    /*TestSignIn*/

    public void clickLogInCustomerMenu()
    {
        driver.findElement(LogInCustomerMenuLocator).click();
    }
    public void clickSignOut()
    {
        driver.findElement(SignOutLocator).click();
    }
    public void clickCreateAnAccountPanel()
    {
        driver.findElement(CreateAnAccountPanelLocator).click();
    }
    public void Logout()
    {
        clickLogInCustomerMenu();
        clickSignOut();
    }
    /*products tests*/
    public void executeSearchText(String searchText) {
        driver.findElement(SearchLoactor).click();
        driver.findElement(SearchLoactor).sendKeys(searchText);
        driver.findElement(SearchLoactor).sendKeys(Keys.ENTER);

    }
    public void NavigateOrdersAndReturns() {
        driver.findElement(OrdersAndReturnsLoactor).click();
    }
}
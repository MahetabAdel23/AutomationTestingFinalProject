package TestCases.ItemsTests.ItemTests;


import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemTest {
//5TC
WebDriver driver;
    Logger logger;

    SoftAssert softAssert=new SoftAssert();
    @BeforeMethod(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        logger= Logger.getLogger(ItemTest.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.
        driver= BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");


    }
    //n1
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void ProductsTests_WomenCategoryHoverTests() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.NavigateWomenCategoryOptions();
        softAssert.assertEquals(BasePage.getCurrentUrl(driver),"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html","not Navigate to JacketCategoryPage");
        softAssert.assertAll();
    }

    //TC No2
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void ProductsTests_addItemToCartTest()throws Exception
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.NavigateWomenCategoryOptions();
        ItemWomanCategoryPage jacketWomanCategoryPage=new ItemWomanCategoryPage(driver);
        jacketWomanCategoryPage.addItemToCart();
        softAssert.assertTrue(jacketWomanCategoryPage.AddToCartSuccessfulMessageDisplayed(),"Item is not added to cart");
        jacketWomanCategoryPage.navigateIntoCartPage();
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
        softAssert.assertTrue(shoppingCartPage.isPageTitleDisplayed(),"Page title is not displayed");
        softAssert.assertAll();
    }
    //no3
    @Test(groups = {"RegressionTests","NegativeTests"})
    public void ProductsTests_addItemWithoutDataToCartTest()throws Exception
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.NavigateWomenCategoryOptions();
        ItemWomanCategoryPage jacketWomanCategoryPage=new ItemWomanCategoryPage(driver);
        jacketWomanCategoryPage.hoverOverItem();
        jacketWomanCategoryPage.clickAddItemToCart();
        softAssert.assertTrue(jacketWomanCategoryPage.MessageChooseOptionsForYourItemDisplayed(),"Item is not added to cart");
        softAssert.assertAll();
    }

 //n4
    @Test (groups = {"RegressionTests","NegativeTests"})
    public void ProductsTests_executeOrdersAndReturnsWithInvalidDataTests()throws Exception
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.NavigateOrdersAndReturns();
        softAssert.assertEquals(BasePage.getCurrentUrl(driver),"https://magento.softwaretestingboard.com/sales/guest/form/","not the same");
        OrdersAndReturnsForm ordersAndReturnsForm=new OrdersAndReturnsForm(driver);
        ordersAndReturnsForm.executeOrderReturnData("52550",1);
        softAssert.assertTrue(ordersAndReturnsForm.ValidateInvalidData(),"not displayed");
        softAssert.assertAll();
    }

   //n5
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void ProductsTests_AddToFavorateListTest()throws Exception
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage=new HomePage(driver);
        ItemWomanCategoryPage jacketWomanCategoryPage=new ItemWomanCategoryPage(driver);
        homePage.NavigateWomenCategoryOptions();
        jacketWomanCategoryPage.hoverOverItem();
        jacketWomanCategoryPage.clickAddItemToCart();
        jacketWomanCategoryPage.clickAddToFavoriteItem();
        softAssert.assertAll();
    }


    @AfterMethod()
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }


}

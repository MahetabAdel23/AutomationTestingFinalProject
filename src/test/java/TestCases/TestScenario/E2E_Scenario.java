package TestCases.TestScenario;

import TestCases.AccountTests.AddressOrderTests.AddressOrder;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class E2E_Scenario {


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(E2E_Scenario.class);
    WebDriver driver;
    Logger logger;


    SoftAssert softAssert=new SoftAssert();
    @BeforeMethod(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        logger= Logger.getLogger(AddressOrder.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

        driver= BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");

    }
    @Test(groups = {"SmokeTests","RegressionTests"})
    public void E2ETest()throws Exception
    {
       logger.info("Creat Acount");
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(13);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        MyAccountPage myAccountPage= new MyAccountPage(driver);

        logger.info("Manage Addresses");
        myAccountPage.clickManageAddressesButton();
        AddressPage addressPage= new AddressPage(driver);
        addressPage.executeAddressDataAfterSignIn(0);
        softAssert.assertTrue(addressPage.validateAddressSavesAfterSignIn(),"Address not saved");

        logger.info("Add Item to  Favorite Wishes");
        ItemWomanCategoryPage jacketWomanCategoryPage=new ItemWomanCategoryPage(driver);
        home.NavigateWomenCategoryOptions();
        jacketWomanCategoryPage.hoverOverItem();
        jacketWomanCategoryPage.clickAddItemToCart();
        jacketWomanCategoryPage.clickAddToFavoriteItem();
        jacketWomanCategoryPage.clickToContinuousShoping();


        logger.info("Filtering Jacket ITem By Color and Size");
        home.NavigateWomenCategoryOptions();
        jacketWomanCategoryPage.chooseColorBlack();
        softAssert.assertTrue(jacketWomanCategoryPage.isColorBlackCheckDisplayed(),"NOT found");
        jacketWomanCategoryPage.chooseSizeXs();
        softAssert.assertTrue(jacketWomanCategoryPage.isSizeXsCheckDisplayed(),"NOT found");

        logger.info("Add Item to Cart");
        jacketWomanCategoryPage.hoverOverItem();
        jacketWomanCategoryPage.clickAddItemToCart();
        softAssert.assertTrue(jacketWomanCategoryPage.AddToCartSuccessfulMessageDisplayed(),"Item is not added to cart");
        jacketWomanCategoryPage.navigateIntoCartPage();
        logger.info("ckeck out process");
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
        shoppingCartPage.clickProceedToCheckoutButton();
        Thread.sleep(5000);
        shoppingCartPage.clickNextButtonShipping1();
        Thread.sleep(5000);
        shoppingCartPage.clickPlaceOrderButton();
        softAssert.assertTrue(shoppingCartPage.validateOrderPlacedSuccesfuly(),"order did not placedSucessfuly");

        logger.info("Return Order");
        String OrderNo= shoppingCartPage.ReadOrderNo();
        logger.info("order number is "+OrderNo);

        logger.info("logout");
        home.Logout();

        home.NavigateOrdersAndReturns();
        softAssert.assertEquals(BasePage.getCurrentUrl(driver),"https://magento.softwaretestingboard.com/sales/guest/form/","not the same");
        OrdersAndReturnsForm ordersAndReturnsForm=new OrdersAndReturnsForm(driver);
        Thread.sleep(2000);
        ordersAndReturnsForm.executeOrderReturnData(OrderNo,13);
        softAssert.assertAll();

    }

    @AfterMethod()
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }
}

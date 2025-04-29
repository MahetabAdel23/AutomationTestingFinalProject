package TestCases.AccountTests.AddressOrderTests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressOrder {
//total tc5
    WebDriver driver;
    Logger logger;


    @BeforeMethod(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        logger= Logger.getLogger(AddressOrder.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

        driver= BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");

    }
    //no1//data1
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void AddressOrder_EditBillingAdressTest()throws Exception
    {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(1);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        AddressPage addressPage=new AddressPage(driver);
        addressPage.clickBillingEditButton();
        addressPage.executeAddressDataAfterSignIn(0);

        softAssert.assertAll();
    }
    //no2//data2
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void AddressOrder_ShippingAdressTest()throws Exception
    {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(2);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        AddressPage addressPage=new AddressPage(driver);
        addressPage.clickShippingEditButton();
        addressPage.executeAddressDataAfterSignIn(1);
         softAssert.assertAll();
    }
    //no3 //data3
    @Test(groups = {"RegressionTests","NegativeTests"})
    public void AddressOrder_AdressWithoutCheckBoxTest()throws Exception
    {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(3);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        AddressPage addressPage=new AddressPage(driver);
        addressPage.clickShippingEditButton();
        addressPage.executeAddressDataAfterSignIn(1);
        addressPage.clickChangeBillingAddressButton();
        addressPage.executeAddressDataAfterSignIn(0);
        softAssert.assertAll();

    }

//no4 //data4
    //here when i change in one(shipping/billing) the other will not be affected
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void AddressOrder_AdressWithCheckBoxTest()throws Exception
    {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(4);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        Thread.sleep(3000);
        AddressPage addressPage=new AddressPage(driver);
        addressPage.clickShippingEditButton();
        addressPage.executeAddressDataAfterSignIn(1);
        addressPage.clickAddNewAddress();
        softAssert.assertTrue(addressPage.validateAddressDefultBillingDisplayedAfterWait(),"AddressDefultBilling not displayed");
        addressPage.clickAddressDefultBilling();
        addressPage.executeAddressDataAfterSignIn(0);
        softAssert.assertAll();

    }
//no5 //data11
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void AddressOrder_ManageAddressTest()throws Exception
    {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(11);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        MyAccountPage myAccountPage= new MyAccountPage(driver);
        myAccountPage.clickManageAddressesButton();
        AddressPage addressPage= new AddressPage(driver);
        addressPage.executeAddressDataAfterSignIn(0);
        softAssert.assertTrue(addressPage.validateAddressSavesAfterSignIn(),"Address not saved");
        softAssert.assertAll();

    }


    @AfterMethod()
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }





}

package TestCases.AccountTests.SignInTests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSignIn {
    //aCCOUNT 6,7
//4tc
    WebDriver driver;
    Logger logger;


    @BeforeMethod(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        logger= Logger.getLogger(TestSignIn.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.


        driver= BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");

    }
//no1
    @Test(groups = {"NegativeTests","RegressionTests"})
    public void TestSignIn_SignIn_WithoutAcountTest ()  {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        softAssert.assertTrue(signInPage.validateIsTittleCustomerLoginDisplayed(), "Sign in page did not opened");
        signInPage.executeSignInDataSuccessfuly();
        softAssert.assertTrue(signInPage.validateIsNoAccountMessageDisplayed(),"there is no account message not displayed");
        softAssert.assertAll();

    }
//no2

    @Test(groups = {"RegressionTests","SmokeTests"})
    public void TestSignIn_SignIn_ForgetPasswordTest() {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        softAssert.assertTrue(signInPage.validateIsTittleCustomerLoginDisplayed(), "Sign in page did not opened");
        signInPage.clickForgetPasswordButton();
        signInPage.executeForgetPasswordSignIn();
        softAssert.assertTrue(signInPage.ValidateForgetPaswordMessage(),"there is no account message not displayed");
        softAssert.assertAll();
     }
//no3
    //this testcase need new account to be passed
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void TestSignIn_CreateNewAccountData() {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(6);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        softAssert.assertAll();
    }
//no4
    @Test(groups = {"RegressionTests","NegativeTests"})
    public void TestSignIn_CreateAccountExistBeforeTest() {
        SoftAssert softAssert=new SoftAssert();
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage= new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(7);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(),"not displayed");
        HomePage homePage=new HomePage(driver);
        homePage.Logout();
        homePage.clickCreateAnAccountPanel();
        createAccountPage.executeCreateAccountData(7);
        softAssert.assertTrue(createAccountPage.validateEnterWithExistAccount(),"not displayed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }


}

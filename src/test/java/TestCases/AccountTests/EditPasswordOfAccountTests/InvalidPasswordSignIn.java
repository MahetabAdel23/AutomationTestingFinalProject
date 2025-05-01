package TestCases.AccountTests.EditPasswordOfAccountTests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidPasswordSignIn {
    WebDriver driver;
    Logger logger;
    @BeforeTest(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser)
    {
        logger= Logger.getLogger(EditPasswordOfAccountTest.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

        driver= BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    //this testcase need new account to be passed
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void  SignInWithUnEditPasswordTest() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(1000);
        HomePage home = new HomePage(driver);
        home.clickSignInPanelButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAnAccountButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.executeCreateAccountData(8);
        softAssert.assertTrue(createAccountPage.validateEnterWithNewAccount(), "not displayed");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickEditButton();
        myAccountPage.ChangePasswordCheckBox();
        softAssert.assertTrue(myAccountPage.ValidateChangePasswordTitle(), "Change password Title is not displayed");
        myAccountPage.executePasswordChangedData(8);
        softAssert.assertTrue(myAccountPage.validateEditedSuccessfully(), "Customer Login Title is not displayed");

        signInPage.SignInWithUnEditPasswordAfterEditAccount(8);
        softAssert.assertTrue(signInPage.validateFaildSignIn(),"correct password ");
        softAssert.assertAll();
    }



    @AfterTest
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }
    }

package TestCases.CustomerInterest.ReviewTests;


import TestCases.AccountTests.AddressOrderTests.AddressOrder;
import Pages.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ReviewsTests {
//2tc

    WebDriver driver;
    Logger logger;

    SoftAssert softAssert=new SoftAssert();
    @BeforeMethod(alwaysRun = true)//By applying always run set to true.,We ensure that setup and teardown methods are always executed, providing the stable environment for,all tests and preventing null pointer exception here because they weren't executed.
    @Parameters("browser")
    public void setUp (@Optional("chrome") String browser) {
        logger = Logger.getLogger(AddressOrder.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

        driver = BrowserOption.BrowserFactory(browser);
        driver.get("https://magento.softwaretestingboard.com/");

    }
    //no1
    @Test(groups = {"RegressionTests","SmokeTests"})
    public void ReviewsTests_NavigateCustomerReviewsTest() {//some time this testcase work and some time not
        SoftAssert softAssert=new SoftAssert();
        BackpackPage backpackPage=new BackpackPage(driver);
        backpackPage.clickBackPackItem();
        backpackPage.clickToDisplayReview();//load 20sec
        softAssert.assertTrue(backpackPage.isCustomerReviewsDisplayed(),"CustomerReviews not opened");
        softAssert.assertAll();
    }



    @Test(dataProvider="json_parsing",groups = {"RegressionTests","SmokeTests"})
    public void ReviewsTests_AddReviewTestUsingJisonData(String data) {
        SoftAssert softAssert=new SoftAssert();
        String Id[]=data.split(",");
        BackpackPage backpackPage=new BackpackPage(driver);
        backpackPage.clickBackPackItem();
        backpackPage.clickAddReview();
        backpackPage.excecuteReview(Id[0],Id[1],Id[2]);
        softAssert.assertTrue(backpackPage.isSuccessMessageDisplayedAfterWait(),"Success message not displayed");
        softAssert.assertAll();
    }


    @DataProvider(name = "json_parsing")
    public String[] jsonReader() throws Exception {
        //parsing the file
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/java/properties/ReviewData.json");
        Object obj = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) obj;//will hold all data readed

        JSONArray array = (JSONArray) jsonObject.get("ReviewData");
        String arr[] = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject users = (JSONObject) array.get(i);
            String NickName = (String) users.get("NickName");
            String Summary = (String) users.get("Summary");
            String Review = (String) users.get("Review");
            arr[i] = NickName + "," + Summary + "," + Review;
        }
        return arr;
    }

    @AfterMethod()
    public void teardown()
    {
        logger.info("closing browser");
        driver.quit();
    }





}

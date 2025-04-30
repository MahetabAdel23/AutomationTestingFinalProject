package Pages;

import Data.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressPage {

    WebDriver driver;
    Logger logger;
    public AddressPage(WebDriver driver)
    {

        this.driver=driver;
        this.logger= Logger.getLogger(AddressPage.class.getName());
        this.logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.


    }

     By ShippingAddressTitleLocator=By.xpath("//div[normalize-space()='Shipping Address']");
     By EmailAddressLocator=By.xpath("//div[@class='control _with-tooltip']/input[@id='customer-email']");
     By FirstNameLocator=By.xpath("//input[@name='firstname']");
     By LastNameLocator=By.xpath("//input[@name='lastname']");
     By CompanyLocator=By.xpath("//input[@name='company']");
    By FirstStreetAddressFieldAfterSignINLocator=By.xpath("(//input[@id='street_1'])[1]");
    By FirstStreetAddressFieldLocator=By.xpath("//input[@name='street[0]']");
    By StateInputLocator=By.xpath ("//input[@id='region']");

    By CityLocator=By.xpath("//input[@name='city']");
     By ZipPostalCodeLocator=By.xpath("//input[@name='postcode']");
     By PhoneNumberLocator=By.xpath("//input[@name='telephone']");


     By StateProvinceLocator=By.xpath("//select[@name='region_id']");
     By CountryLocator=By.xpath("//div[@class='control']/select[@name='country_id'] ");
     By ShippingMethodsTableRateRadioLocator=By.xpath("//input[@value='tablerate_bestway']");
     By ShippingMethodsFixedRadioLocator=By.xpath ("//input[@value='flatrate_flatrate']");
     By NextButtonLocator=By.xpath("//button[@class='button action continue primary']");
    //By WarnMessageZipPostalLocator=By.xpath("//span[@data-bind='text: element.warn']");
    By WarnMessageZipPostalLocator2=By.xpath("//div[@class='message warning']");
    By SaveAddressButtonAfterSignIn=By.xpath("//span[text()='Save Address']");
    By AddressSavesAfterSignIn=By.xpath("//div[text()='You saved the address.']");

    By AddNewAddressLocator=By.xpath("//button[@title='Add New Address']");
    By AddressDefultBillingLocator=By.xpath("//input[@id='primary_billing']");

    By BillingEditButtonLocator=By.xpath("//a[@data-ui-id='default-billing-edit-link']/span[text()='Edit Address']");
    By ShippingEditButtonLocator=By.xpath("//a[@data-ui-id='default-shipping-edit-link']/span[text()='Edit Address']");
    By ChangeBillingAddressButtonLocator=By.xpath("//span[text()='Change Billing Address']");


    public void clickBillingEditButton()
    {
        driver.findElement(BillingEditButtonLocator).click();
    }
    public void clickShippingEditButton()throws Exception
    {
        Thread.sleep(1500);
        BasePage.waitElement(driver,ShippingEditButtonLocator);
        driver.findElement(ShippingEditButtonLocator).click();
    }
    public void clickChangeBillingAddressButton()
    {
        driver.findElement(ChangeBillingAddressButtonLocator).click();
    }

    public boolean ShippingAddressTitleDisplayed()
    {
      return BasePage.waitForIsDisplayed(driver,ShippingAddressTitleLocator);
    }


    public void enterEmailAddress(String email)
    {

     driver.findElement(EmailAddressLocator).sendKeys(email);
    }
    public void validateisWarnMessageZipDisplayAfterWait()
    {
        BasePage.waitElement(driver,WarnMessageZipPostalLocator2);
    }

    public boolean isFirstNameDisplay()
    {
       return BasePage.waitForIsDisplayed(driver,FirstNameLocator);
    }
    public void enterFirstName(String firstName)
    {
        WebElement element=BasePage.waitElement(driver,FirstNameLocator);
        element.sendKeys(firstName);
    }
    public void enterLastName(String lastName)
    {//driver.findElement(LastNameLocator).clear();
        driver.findElement(LastNameLocator).sendKeys(lastName);
    }
    public void enterCompany(String company)
    {
        driver.findElement(CompanyLocator).clear();
        driver.findElement(CompanyLocator).sendKeys(company);
    }
    public void enterFirstStreetAddress(String address)
    {
        driver.findElement(FirstStreetAddressFieldLocator).sendKeys(address);
    }
    public void enterFirstStreetAddressAfterSignIn(String address)
    {
        driver.findElement(FirstStreetAddressFieldAfterSignINLocator).clear();

        driver.findElement(FirstStreetAddressFieldAfterSignINLocator).sendKeys(address);
    }
    public void enterCity(String city)
    {
        driver.findElement(CityLocator).clear();
        driver.findElement(CityLocator).sendKeys(city);
    }
    public void enterZipPostalCode(String zip)
    {
        driver.findElement(ZipPostalCodeLocator).clear();
        driver.findElement(ZipPostalCodeLocator).sendKeys(zip);
    }
    public void enterPhoneNumber(String phone)
    {
        driver.findElement(PhoneNumberLocator).clear();

        driver.findElement(PhoneNumberLocator).sendKeys(phone);
    }
    public void clickNextButton()
    {
        BasePage.ClickablietyOfElementAfterWait(driver,NextButtonLocator);
        driver.findElement(NextButtonLocator).click();
    }
    public void selectAlaskaStateProvince()
    {
       WebElement element=driver.findElement(StateProvinceLocator);
      // element.clear();
        Select select = new Select(element);//select object
        select.selectByVisibleText("Alaska");
    }
    public void StateInput()
    {
        driver.findElement(StateInputLocator).sendKeys("StateProvince");
    }
    public void selectAlgeriaCountry()
    {
        WebElement element=driver.findElement(CountryLocator);
       // element.clear();
        Select select = new Select(element);//select object
        select.selectByVisibleText("Algeria");
    }

    public void clickShippingMethodsTableRateRadio()
    {
       WebElement element= BasePage.ClickablietyOfElementAfterWait(driver,ShippingMethodsTableRateRadioLocator);
        element.click();
    }
    public void clickShippingMethodsFixedRadio()
    {
        WebElement element= BasePage.ClickablietyOfElementAfterWait(driver,ShippingMethodsFixedRadioLocator);
        element.click();
    }

    /*
    public void ShippingMethodsFixedRadioLocator()
    {
        super.ClickablietyOfElementAfterWait(ShippingMethodsTableRateRadioLocator).click();
    }*/

    public boolean WaitEmailFieldDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,EmailAddressLocator);
    }
    public void executShippingDataWithoutSignIn(int rowIndex)
    {

      String email="";
      String firstName="";
      String lastName="";
      String company="";
      String address="";
      String city="";
      String zip="";
      String phone="";


        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/AddressDataWithoutSignIn.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)

                 email=row[0];
                 firstName=row[1];
                lastName=row[2];
                company=row[3];
                address=row[4];
                city=row[5];
                zip=row[6];
                phone=row[7];

            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        enterEmailAddress(email);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterFirstStreetAddress(address);
        enterCity(city);
        selectAlaskaStateProvince();
        enterZipPostalCode(zip);
        validateisWarnMessageZipDisplayAfterWait();
        selectAlgeriaCountry();
        enterPhoneNumber(phone);
        //clickShippingMethodsTableRateRadio();
        clickNextButton();
    }


    public void clickSaveAddressButtonAfterSignIn()throws Exception
    {
        Thread.sleep(1500);
        BasePage.ClickablietyOfElementAfterWait(driver,SaveAddressButtonAfterSignIn);
        driver.findElement(SaveAddressButtonAfterSignIn).click();
    }

    public void executeAddressDataAfterSignIn(int rowIndex)throws Exception
    {
        String company="";
        String phone="";
        String address="";
        String city="";
        String zip="";


        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/AddressDataAfterSignIn.csv", 5);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)

                company = row[0];
                phone=row[1];
                address=row[2];
                city=row[3];
                zip=row[4];
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        enterCompany(company);
        enterPhoneNumber(phone);
        enterFirstStreetAddressAfterSignIn(address);
        enterCity(city);
        if (BasePage.isElementDisplayed(driver,StateProvinceLocator))
        {
            selectAlaskaStateProvince();
        }
        else
        {
            StateInput();
        }
        enterZipPostalCode(zip);
        validateisWarnMessageZipDisplayAfterWait();
        selectAlgeriaCountry();
        clickSaveAddressButtonAfterSignIn();
    }

    public boolean validateAddressSavesAfterSignIn()
    {
        return BasePage.waitForIsDisplayed(driver,AddressSavesAfterSignIn);
    }

    public void clickAddNewAddress() throws Exception
    {
        Thread.sleep(1500);
        BasePage.ClickablietyOfElementAfterWait(driver,AddNewAddressLocator);
        driver.findElement(AddNewAddressLocator).click();
    }
    public boolean validateAddressDefultBillingDisplayedAfterWait()
    {
        return BasePage.waitForIsDisplayed(driver,AddressDefultBillingLocator);
    }
    public void clickAddressDefultBilling()throws Exception
    {
        Thread.sleep(1500);
    driver.findElement(AddressDefultBillingLocator).click();
    }


}

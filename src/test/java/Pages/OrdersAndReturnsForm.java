package Pages;

import Data.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class OrdersAndReturnsForm {

    WebDriver driver;

    By OrderIdInputLocator=By.xpath("//input[@id='oar-order-id']");
    By OrderBillingLastnameLocator=By.xpath("//input[@id='oar-billing-lastname']");
    By SelectLocator=By.xpath("//select[@id='quick-search-type-id']");
    By EmailInputLocator=By.xpath("//input[@id='oar_email']");
    By ContinueButtonLocator=By.xpath("//span[text()='Continue']");
    By InvalidDataMessage=By.xpath("//div[text()='You entered incorrect data. Please try again.']");
    public OrdersAndReturnsForm(WebDriver driver){
         this.driver=driver;
    }

    public void executeOrderReturnData(String orderid,int rowIndex)
    {

        String OrderBillingLastname="";
        String Email="";
        try
        {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file


            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)


                OrderBillingLastname = row[1];
                Email=row[2];
            }
        }catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        driver.findElement(OrderIdInputLocator).sendKeys(orderid);
        driver.findElement(OrderBillingLastnameLocator).sendKeys(OrderBillingLastname);
        BasePage.DropDownSelect(driver,SelectLocator,"email");
        driver.findElement(EmailInputLocator).sendKeys(Email);
        driver.findElement(ContinueButtonLocator).click();
    }


    public boolean ValidateInvalidData()
    {
        return BasePage.waitForIsDisplayed(driver,InvalidDataMessage);
    }



}

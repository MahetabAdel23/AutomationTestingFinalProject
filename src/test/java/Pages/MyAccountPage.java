package Pages;

import Data.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAccountPage {
    WebDriver driver;
    Logger logger;


    By EditButtonLocator=By.xpath("//span[text()='Edit']");
    By ChangePasswordButtonLocator=By.xpath("//a[normalize-space(text())='Change Password']");
    By ManageAddressesLocator=By.xpath("//span[text()='Manage Addresses']");

    By ChangeEmailCheckBoxLocator=By.xpath("//input[@title='Change Email']");
    By ChangePasswordCheckBoxLocator=By.xpath("//input[@title='Change Password']");
    By SaveButtonLocator=By.xpath("//button[@title='Save']");

    By CurrentPasswordLocator=By.xpath("//input[@id='current-password']");
    By NewPasswordLocator=By.xpath("//input[@id='password']");
    By ConfirmNewPasswordLocator=By.xpath("//input[@id='password-confirmation']");

    By EmailChangedLocator=By.xpath("//input[@id='email']");
    By CurrentPasswordAtEmailChangedLocator=By.xpath("//input[@id='current-password']");

    By ChangeEmailTitleLocator=By.xpath("//legend/span[text()='Change Email']");
    By ChangePasswordTitleLocator=By.xpath("//legend/span[text()='Change Password']");

    By CustomerLoginTitleAfterEditEmailLocator =By.xpath("//span[text()='Customer Login']");

    By SuccessfulyEditMessageLocator =By.xpath("//div[text()='You saved the account information.']");

    public MyAccountPage(WebDriver driver)
    {
        this.driver=driver;
       this.logger=Logger.getLogger(MyAccountPage .class.getName());
       this.logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

    }
    public void clickEditButton()
    {
        driver.findElement(EditButtonLocator).click();
    }
    public void ChangeEmailCheckBox()
    {
        driver.findElement(ChangeEmailCheckBoxLocator).click();
    }

    public void ChangePasswordCheckBox()
    {
        driver.findElement(ChangePasswordCheckBoxLocator).click();
    }



    public boolean ValidateChangeEmailTitle()
    {
       return BasePage.waitForIsDisplayed(driver,ChangeEmailTitleLocator);
    }

    public boolean ValidateChangePasswordTitle()
    {
        return BasePage.waitForIsDisplayed(driver,ChangePasswordTitleLocator);
    }

    public void executeEmailChangedData(int rowIndex)
    {
        String emailAfterEdit="";
        String CurrentPassword="";
        try
        {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)

                emailAfterEdit  = row[5];
                CurrentPassword = row[3];

            }
        }catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        driver.findElement( EmailChangedLocator).clear();
        logger.info("CurrentPassword IS " + emailAfterEdit);
        driver.findElement( EmailChangedLocator).sendKeys(emailAfterEdit);
        logger.info("CurrentPassword IS " + CurrentPassword);
        driver.findElement(CurrentPasswordAtEmailChangedLocator).sendKeys(CurrentPassword);
        driver.findElement(SaveButtonLocator).click();


    }

    public void executePasswordChangedData(int rowIndex)
    {

        String CurrentPassword="";
        String NewPassword="";
        String ConfirmNewPassword="";


        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)

                CurrentPassword = row[3];
                NewPassword=row[6];
                ConfirmNewPassword=row[7];

            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        logger.info("CurrentPassword IS " + CurrentPassword);
        driver.findElement(CurrentPasswordLocator).sendKeys(CurrentPassword);
        logger.info("NewPassword is " + NewPassword);

        driver.findElement(NewPasswordLocator).sendKeys(NewPassword);
        logger.info("ConfirmNewPassword is " + ConfirmNewPassword);
        driver.findElement(ConfirmNewPasswordLocator).sendKeys(ConfirmNewPassword);

        driver.findElement(SaveButtonLocator).click();
    }
    public boolean validateCustomerLoginTitleAfterEditEmail()
    {
       return BasePage.waitForIsDisplayed(driver, CustomerLoginTitleAfterEditEmailLocator);
    }

    public boolean validateEditedSuccessfully()
    {
        return BasePage.waitForIsDisplayed(driver, SuccessfulyEditMessageLocator);
    }


    public void clickManageAddressesButton()
    {
        driver.findElement(ManageAddressesLocator).click();
    }
}

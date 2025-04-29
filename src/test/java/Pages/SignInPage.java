package Pages;

import Data.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignInPage {

    WebDriver driver;
    Logger logger;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.logger=Logger.getLogger(SignInPage .class.getName());
        this.logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

    }

    By TittleCustomerLoginLocator = By.xpath("//span[text()='Customer Login']");
    By EmailFieldLocator = By.xpath("//input[@id='email']");
    By PasswordFieldLocator = By.xpath("//input[@id='pass' and @title='Password']");
    By ForgetPasswordButtonLocator = By.xpath("//fieldset[@class='fieldset login']//span[text()='Forgot Your Password?']");
    By SignInButtonLocator = By.xpath("//fieldset[@class='fieldset login']//span[text()='Sign In']");
    By CreateAnAccountButtonLocator = By.xpath("//a[@class='action create primary']//span[text()='Create an Account']");

    By NoAccountMessageLocator = By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']");
    By EmailDataForgetPasswordSignINLocator = By.xpath("//input[@id='email_address']");

    By ResetMyPasswordButtonLocator = By.xpath("//span[text()='Reset My Password']");
    By ConfirmMessageResetMyPasswordLocator = By.xpath("//div[contains(text(), 'you will receive an email with a link to reset your password.')]");

    By WelcomSignInSuccessfulyLocator = By.xpath("//div[@class='panel header']//span[contains(text(), 'Welcome, ')]");
    By InCorrectSignInMessageLocator = By.xpath("//div[contains(text(), 'The account sign-in was incorrect')]");

    public  boolean validateIsTittleCustomerLoginDisplayed()
    {
        return driver.findElement(TittleCustomerLoginLocator).isDisplayed();
    }
    public  void SignInWithEditEmailAccount(int rowIndex) {
        String emailAfterEdit = ""; // Initialize email
        String CurrentPassword = ""; // Initialize password

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)
                emailAfterEdit  = row[5];
                CurrentPassword = row[3];

            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        logger.info("Email after edit: " + emailAfterEdit);
        driver.findElement(EmailFieldLocator).sendKeys(emailAfterEdit);
        logger.info("CurrentPassword is  : " + CurrentPassword);
        driver.findElement(PasswordFieldLocator).sendKeys(CurrentPassword);
        driver.findElement(SignInButtonLocator).click();
    }

    public  void SignInWithUnEditEmailAfterEditItAccount(int rowIndex) {
        String emailBeforeEdit = ""; // Initialize email
        String CurrentPassword = ""; // Initialize password

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)
                emailBeforeEdit  = row[2];
                CurrentPassword = row[3];
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        logger.info("Email after edit: " + emailBeforeEdit);
        driver.findElement(EmailFieldLocator).sendKeys(emailBeforeEdit);
        logger.info("CurrentPassword is  : " + CurrentPassword);
        driver.findElement(PasswordFieldLocator).sendKeys(CurrentPassword);
        driver.findElement(SignInButtonLocator).click();
    }
    public void SignInWithEditPasswordAccount(int rowIndex) {
        String email = ""; // Initialize email
        String Editedpassword = ""; // Initialize password

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)
                email = row[2];
                Editedpassword = row[6];

            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        driver.findElement(EmailFieldLocator).sendKeys(email);
        driver.findElement(PasswordFieldLocator).sendKeys(Editedpassword);
        driver.findElement(SignInButtonLocator).click();
    }
    public void SignInWithUnEditPasswordAfterEditAccount(int rowIndex) {
        String email = ""; // Initialize email
        String UnEditedpassword = ""; // Initialize password

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)
                email = row[2];
                UnEditedpassword = row[3];

            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        driver.findElement(EmailFieldLocator).sendKeys(email);
        driver.findElement(PasswordFieldLocator).sendKeys(UnEditedpassword);
        driver.findElement(SignInButtonLocator).click();
    }

    public void executeSignInDataSuccessfuly() {
            String email = ""; // Initialize email
            String password = ""; // Initialize password

            try {
                CsvReader csvReader = new CsvReader("src/main/java/properties/signupdata.csv", 2);
                List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

                for (String[] row : rows) {
                    email = row[0];
                    password = row[1];
                }
            } catch (IOException e) {
                System.err.println("Error reading the CSV file: " + e.getMessage());
            }

            driver.findElement(EmailFieldLocator).sendKeys(email);
            driver.findElement(PasswordFieldLocator).sendKeys(password);
            driver.findElement(SignInButtonLocator).click();
    }

    public boolean validateIsNoAccountMessageDisplayed() {
        WebElement Element = BasePage.waitElement(driver,NoAccountMessageLocator);
        return Element.isDisplayed();
    }
public void clickForgetPasswordButton()
    {
        driver.findElement(ForgetPasswordButtonLocator).click();
    }
    public void executeForgetPasswordSignIn()
    {

        String password = ""; // Initialize password

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/signupdata.csv", 2);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            for (String[] row : rows) {

                password = row[0];
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        driver.findElement(EmailDataForgetPasswordSignINLocator).sendKeys(password);
        driver.findElement(ResetMyPasswordButtonLocator).click();
    }

    public boolean ValidateForgetPaswordMessage()
    {
      return   BasePage.waitForIsDisplayed(driver,ConfirmMessageResetMyPasswordLocator);
    }


    public void clickCreateAnAccountButton()
    {
        driver.findElement(CreateAnAccountButtonLocator).click();
    }
    public void WaitToClickCreateAnAccountButton()throws Exception
    {
        Thread.sleep(2000);
        driver.findElement(CreateAnAccountButtonLocator).click();
    }


    public boolean validateSignInSuccessfuly()
    {
        return BasePage.waitForIsDisplayed(driver,WelcomSignInSuccessfulyLocator);
    }
   public boolean validateFaildSignIn()
    {
        return BasePage.waitForIsDisplayed(driver,InCorrectSignInMessageLocator);
    }
}



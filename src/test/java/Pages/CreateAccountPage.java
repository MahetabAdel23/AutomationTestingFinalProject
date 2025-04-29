package Pages;

import Data.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateAccountPage {

    By FirstNameLocator = By.xpath("//input[@id='firstname']");
    By LastNameLocator = By.xpath("//input[@id='lastname']");
    By EmailLocator = By.xpath("//input[@id='email_address']");
    By PasswordLocator = By.xpath("//input[@id='password']");
    By ConfirmPasswordLocator = By.xpath("//input[@id='password-confirmation']");
    By CreateAccountButtonLocator = By.xpath("//button/span[text()='Create an Account']");
    By NewAccountTitleCreationLocator = By.xpath("//div[text()='Thank you for registering with Main Website Store.']");
    By ExistAccountConfirmMessageLocator = By.xpath("//div[contains(text(),'There is already an account with this email address')] ");
    By ButtonToSignOut = By.xpath("//div[@class='panel header']//button[@data-action='customer-menu-toggle']");
    // By SignOutButtonLocator = By.xpath("//a[@class='action sign-out']//span[text()='Sign Out']");
    WebDriver driver;
    Logger logger;
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        this.logger= Logger.getLogger(CreateAccountPage .class.getName());
        this.logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.

    }

    public void enterFirstName(String firstName) {
        driver.findElement(FirstNameLocator).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(LastNameLocator).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(EmailLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(PasswordLocator).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(ConfirmPasswordLocator).sendKeys(confirmPassword);
    }

    public void clickCreateAccountButton() {
        driver.findElement(CreateAccountButtonLocator).click();
    }

    public void executeCreateAccountData(int rowIndex) {

        String firstName = ""; // Initialize password
        String lastName = "";
        String email = "";
        String password = "";
        String confirmPassword = "";

        try {
            CsvReader csvReader = new CsvReader("src/main/java/properties/CreateAccount.csv", 8);
            List<String[]> rows = csvReader.getRows(); // Retrieve the rows from the CSV file

            //for (String[] row : rows) {
            if (rows.size() > 1) { // Ensure there is a second row
                String[] row = rows.get(rowIndex); // Access the second row (index 3 start from 0)
                firstName = row[0];
                lastName = row[1];
                email = row[2];
                password = row[3];
                confirmPassword = row[4];
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        logger.info("First Name: " + firstName);
        enterFirstName(firstName);
        logger.info("Last Name: " + lastName);
        enterLastName(lastName);
        logger.info("Email: " + email);
        enterEmail(email);
        logger.info("Password: " + password);
        enterPassword(password);
        logger.info("Confirm Password: " + confirmPassword);
        enterConfirmPassword(confirmPassword);
        logger.info("Clicking Create Account Button");
        clickCreateAccountButton();
    }
    public boolean validateEnterWithExistAccount()
    {
        return BasePage.waitForIsDisplayed(driver, ExistAccountConfirmMessageLocator);
    }
    public boolean validateEnterWithNewAccount ()
    {
        return BasePage.waitForIsDisplayed(driver,NewAccountTitleCreationLocator);
    }
}

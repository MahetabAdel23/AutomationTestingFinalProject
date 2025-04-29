package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackpackPage {
WebDriver driver;
    private By BackPackItemLocator=By.xpath("//main[@id='maincontent']//span[@data-ui-id='page-title-wrapper']");
    By BackPackItemLocator1=By.xpath("(//a[@class='product-item-photo'])[5]");

    private By ReviewLocator=By.xpath("//main[@id='maincontent']//a[@href='https://magento.softwaretestingboard.com/fusion-backpack.html#reviews']");
    private By CustomerReviewsLocator=By.xpath("//div[@id='customer-reviews']/div[1]");
    private By AddReviewLocator=By.xpath("//a[@href='https://magento.softwaretestingboard.com/fusion-backpack.html#review-form']");
    private By ReviewFormLocator=By.xpath("//legend[@class='legend review-legend']//span[1]");
    private By Radio1StarLocator =By.xpath("//label[@id='Rating_1_label']");
    private By Radio2StarLocator =By.xpath("//label[@id='Rating_2_label']");
    private By Radio3StarLocator =By.xpath("//label[@id='Rating_3_label']");
    private By Radio4StarLocator =By.xpath("//label[@id='Rating_4_label']");
    private By Radio5StarLocator =By.xpath("//label[@id='Rating_5_label']");
    private By NicknameFieldLocator=By.id("nickname_field");
    private By SummaryFieldLocator=By.id("summary_field");
    private By ReviewFieldLocator=By.id("review_field");
    private By SubmitButtonLocator=By.xpath("//form[@id='review-form']//button[@type='submit']");
    private By ReviewButtonLocator=By.xpath("//a[@id='tab-label-reviews-title']");
    private By SuccessMessageLocator=By.xpath("(//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'])[1]");

    public BackpackPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isBackPackItemDisplayed()
    {
       return BasePage.waitForIsDisplayed(driver,BackPackItemLocator);
    }
    public void clickToDisplayReview()
    {
        driver.findElement(ReviewLocator).click();
    }
    public void loadCustomerReviews()
    {
        BasePage.waitElement(driver,CustomerReviewsLocator);
    }
    public boolean isCustomerReviewsDisplayed()
    {
        BasePage.waitElement(driver,CustomerReviewsLocator);
        return BasePage.isElementDisplayed(driver,CustomerReviewsLocator);
    }


    public void clickAddReview()
    {
        driver.findElement(AddReviewLocator).click();
    }
    public boolean isReviewFormDisplayed()
    {
        return BasePage.waitForIsDisplayed(driver,ReviewFormLocator);
    }

    public void clickReviewButtonLocator()
    {
        driver.findElement(ReviewButtonLocator).click();
    }
    /*
    public void loadRadioButton5()
    {
     super.waitElement(Radio5StarLocator);
    }*/

    public void RadioButton1Select()
    {
        WebElement element= BasePage.ClickablietyOfElementAfterWait(driver,Radio1StarLocator);
        element.click();
    }
    public void excecuteReview(String nickname, String summary, String review)
    {
        RadioButton1Select();
        driver.findElement(NicknameFieldLocator).sendKeys(nickname);
        driver.findElement(SummaryFieldLocator).sendKeys(summary);
        driver.findElement(ReviewFieldLocator).sendKeys(review);
        driver.findElement(SubmitButtonLocator).click();
    }
    public boolean isSuccessMessageDisplayedAfterWait()
    {
       return BasePage.waitForIsDisplayed(driver,SuccessMessageLocator);
    }

    public void clickBackPackItem()
    {
        driver.findElement(BackPackItemLocator1).click();
    }


}

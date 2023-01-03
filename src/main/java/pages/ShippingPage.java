package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingPage {
    private static final By GET_IN_STORE_LINK = By.xpath("(//ul[@class='menu menu--checkout']/li)[2]");
    private static final By SELECT_STORE_LINK = By.xpath("(//div[@class='pickup-point-name'])[3]");
    private static final By PURCHASER_NAME = By.xpath("//input[@id='address_first_name']");
    private static final By PURCHASER_LASTNAME = By.xpath("//input[@id='address_last_name']");
    private static final By PURCHASER_PHONE = By.xpath("//input[@id='address_phone_number']");
    private static final By BILLING_PAGE_LINK = By.cssSelector("button[type='submit']");
    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean shippingPageIsOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(GET_IN_STORE_LINK));
        return true;
    }
    public void selectGetInStore(){
        driver.findElement(GET_IN_STORE_LINK).click();
    }
    public void selectStore(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_STORE_LINK));
        driver.findElement(SELECT_STORE_LINK).click();
    }
    public void enterPurchaserName(String name){
        driver.findElement(PURCHASER_NAME).sendKeys(name);
    }
    public void enterPurchaserLastname(String lastname){
        driver.findElement(PURCHASER_LASTNAME).sendKeys(lastname);
    }
    public void enterPurchaserPhone(String phone){
        driver.findElement(PURCHASER_PHONE).sendKeys(phone);
    }
    public void clickToSaveBeforeBilling() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(BILLING_PAGE_LINK));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(BILLING_PAGE_LINK));
    }
    public void clickToBilling() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(BILLING_PAGE_LINK));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(BILLING_PAGE_LINK));
    }
}
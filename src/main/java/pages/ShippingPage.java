package pages;

import driver.JsClickUtils;
import driver.ShopWaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    private static final By GET_IN_STORE_LINK = By.xpath("(//ul[@class='menu menu--checkout']/li)[2]");
    private static final By SELECT_STORE_LINK = By.xpath("(//div[@class='pickup-point-name'])[3]");
    private static final By PURCHASER_NAME = By.xpath("//input[@id='address_first_name']");
    private static final By PURCHASER_LASTNAME = By.xpath("//input[@id='address_last_name']");
    private static final By PURCHASER_PHONE = By.xpath("//input[@id='address_phone_number']");
    private static final By BILLING_PAGE_LINK = By.xpath("(//button[@type='submit'])[2]");
    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean shippingPageIsOpened() {
        ShopWaitingUtils.waitUntilElem(driver, GET_IN_STORE_LINK, 10);
        return true;
    }

    public void selectGetInStore() {
        driver.findElement(GET_IN_STORE_LINK).click();
    }

    public void selectStore() {
        ShopWaitingUtils.waitUntilElem(driver, SELECT_STORE_LINK, 10);
        driver.findElement(SELECT_STORE_LINK).click();
    }

    public void enterPurchaserName(String name) {
        driver.findElement(PURCHASER_NAME).sendKeys(name);
    }

    public void enterPurchaserLastname(String lastname) {
        driver.findElement(PURCHASER_LASTNAME).sendKeys(lastname);
    }

    public void enterPurchaserPhone(String phone) {
        driver.findElement(PURCHASER_PHONE).sendKeys(phone);
    }

    public void clickToSaveBeforeBilling() throws InterruptedException {
        Thread.sleep(2000);
        ShopWaitingUtils.waitUntilElem(driver, BILLING_PAGE_LINK, 10);
        JsClickUtils.javaScriptClick(driver, BILLING_PAGE_LINK);
    }

    public void clickToBilling() throws InterruptedException {
        Thread.sleep(2000);
        ShopWaitingUtils.waitUntilElem(driver, BILLING_PAGE_LINK, 10);
        JsClickUtils.javaScriptClick(driver, BILLING_PAGE_LINK);
    }
}
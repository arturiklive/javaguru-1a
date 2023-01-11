package pages;

import driver.ShopWaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingPage {
    private static final By SELECT_PAY_IN_STORE = By.xpath("(//ul[@class='menu menu--checkout']//label)[2]");
    private static final By TOTAL_PRICE = By.xpath("//span[@class='checkout-order-summary-total__price']");
    private final WebDriver driver;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean billingPageIsOpened() {
        ShopWaitingUtils.waitUntilElem(driver, SELECT_PAY_IN_STORE, 10);
        return true;
    }

    public void selectPayInStore() {
        ShopWaitingUtils.waitUntilElem(driver, SELECT_PAY_IN_STORE, 10);
        driver.findElement(SELECT_PAY_IN_STORE).click();
    }

    public String getTotalPrice() {
        ShopWaitingUtils.waitUntilElem(driver, TOTAL_PRICE, 10);
        return driver.findElement(TOTAL_PRICE).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }
}

package pages;

import driver.ShopWaitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private static final By PURCHASE_EMAIL = By.xpath("(//input[@class='users-session-form__input users-session-form__input--text'])[2]");
    private static final By BUTTON_AFTER_EMAIL = By.xpath("(//input[@class='users-session-form__submit'])[2]");
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean checkoutPageIsOpened(){
        ShopWaitings.enterElementTime(driver, PURCHASE_EMAIL, 10);
        return true;
    }
    public void purchaseEnterEmail(String email){
        ShopWaitings.enterElementTime(driver, PURCHASE_EMAIL, 10);
        driver.findElement(PURCHASE_EMAIL).sendKeys(email);
    }
    public void pressButtonAfterEmail(){
        if (driver.findElement(BUTTON_AFTER_EMAIL).isDisplayed()) {
            driver.findElement(BUTTON_AFTER_EMAIL).click();
        }
    }
}

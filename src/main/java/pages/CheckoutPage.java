package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private static final By PURCHASE_EMAIL = By.xpath("(//input[@class='users-session-form__input users-session-form__input--text'])[2]");
    private static final By BUTTON_AFTER_EMAIL = By.xpath("(//input[@class='users-session-form__submit'])[2]");
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean checkoutPageIsOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PURCHASE_EMAIL));
        return true;
    }
    public void purchaseEnterEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PURCHASE_EMAIL));
        driver.findElement(PURCHASE_EMAIL).sendKeys(email);
    }
    public void pressButtonAfterEmail(){
        if (driver.findElement(BUTTON_AFTER_EMAIL).isDisplayed()) {
            driver.findElement(BUTTON_AFTER_EMAIL).click();
        }
    }
}

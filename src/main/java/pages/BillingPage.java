package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillingPage {
    private static final By SELECT_PAY_IN_STORE = By.xpath("(//ul[@class='menu menu--checkout']//label)[2]");
    private static final By TOTAL_PRICE = By.xpath("//div[@class='price fr']");
    private WebDriver driver;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean billingPageIsOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_PAY_IN_STORE));
        return true;
    }
    public void selectPayInStore(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_PAY_IN_STORE));
        driver.findElement(SELECT_PAY_IN_STORE).click();
    }
    public String getTotalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_PRICE));
        return driver.findElement(TOTAL_PRICE).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }
}

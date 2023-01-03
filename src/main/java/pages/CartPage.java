package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private static final By PRODUCT_NAME_LINK = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private static final By PRODUCT_PRICE_LINK = By.xpath("//td[@id='cart-full-total-price']");
    private static final By GO_TO_CHECKOUT_LINK = By.xpath("//input[@class='main-button cart-main-button cart-main-button--large']");
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean cartIsOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_LINK));
        return true;
    }
    public String getProductNameInCart(){
        return driver.findElement(PRODUCT_NAME_LINK).getAttribute("innerHTML").replaceAll("[ \t\n\r]*", "");
    }
    public String getProductPriceInCart(){
        return driver.findElement(PRODUCT_PRICE_LINK).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }
    public void setGoToCheckout(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(GO_TO_CHECKOUT_LINK));
    }
}
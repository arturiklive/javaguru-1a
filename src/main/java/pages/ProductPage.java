package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private static final By PRODUCT_VALIDATE_SPACE = By.xpath("//div[@class='product-righter google-rich-snippet']");
    private static final By PURCHASE_VALIDATE_SPACE = By.xpath("//div[@class='title-success']");
    private static final By PRODUCT_ADD_LINK = By.id("add_to_cart_btn");
    private static final By PRODUCT_NAME_LINK = By.tagName("h1");
    private static final By PRODUCT_PRICE_LINK = By.xpath("(//span[@class='price']/span)[1]");
    private static final By GO_TO_CART_LINK = By.xpath("//a[@class='main-button']");
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_VALIDATE_SPACE));
        return true;
    }
    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_ADD_LINK));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(PRODUCT_ADD_LINK));
    }
    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_LINK));
        return driver.findElement(PRODUCT_NAME_LINK).getAttribute("innerHTML").replaceAll("[ \t\n\r]*", "");
    }
    public String getProductPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PRICE_LINK));
        return driver.findElement(PRODUCT_PRICE_LINK).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }
    public boolean isPurchaseSucceed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PURCHASE_VALIDATE_SPACE));
        return true;
    }
    public void goToCartClick(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(GO_TO_CART_LINK));
    }
}

package pages;

import driver.ShopJsClicks;
import driver.ShopWaitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        ShopWaitings.enterElementTime(driver, PRODUCT_VALIDATE_SPACE, 10);
        return true;
    }
    public void addProductToCart(){
        ShopWaitings.enterElementTime(driver, PRODUCT_ADD_LINK, 10);
        ShopJsClicks.javaScriptClick(driver, PRODUCT_ADD_LINK);
    }
    public String getProductName(){
        ShopWaitings.enterElementTime(driver, PRODUCT_NAME_LINK, 10);
        return driver.findElement(PRODUCT_NAME_LINK).getAttribute("innerHTML").replaceAll("[ \t\n\r]*", "");
    }
    public String getProductPrice(){
        ShopWaitings.enterElementTime(driver, PRODUCT_PRICE_LINK, 10);
        return driver.findElement(PRODUCT_PRICE_LINK).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }
    public boolean isPurchaseSucceed(){
        ShopWaitings.enterElementTime(driver, PURCHASE_VALIDATE_SPACE, 10);
        return true;
    }
    public void goToCartClick(){
        ShopJsClicks.javaScriptClick(driver, GO_TO_CART_LINK);
    }
}

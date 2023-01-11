package pages;

import driver.JsClickUtils;
import driver.ShopWaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static final By PRODUCT_NAME_LINK = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private static final By PRODUCT_PRICE_LINK = By.xpath("//td[@id='cart-full-total-price']");
    private static final By GO_TO_CHECKOUT_LINK = By.xpath("//input[@class='main-button cart-main-button cart-main-button--large']");
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean cartIsOpened() {
        ShopWaitingUtils.waitUntilElem(driver, PRODUCT_NAME_LINK, 10);
        return true;
    }

    public String getProductNameInCart() {
        return driver.findElement(PRODUCT_NAME_LINK).getAttribute("innerHTML").replaceAll("[ \t\n\r]*", "");
    }

    public String getProductPriceInCart() {
        return driver.findElement(PRODUCT_PRICE_LINK).getText().replaceAll("[ \t\n\r]*", "").replace("€", "");
    }

    public void setGoToCheckout() {
        JsClickUtils.javaScriptClick(driver, GO_TO_CHECKOUT_LINK);
    }
}
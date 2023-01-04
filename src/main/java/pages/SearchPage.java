package pages;

import driver.ShopJsClicks;
import driver.ShopWaitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SearchPage {
    private static int randomItemNumber =  new Random().nextInt(46) + 1;
    private static final By COOKIES_LINK = By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    private static final By SEARCH_FIELD_LINK = By.xpath("//input[@id='q']");
    private static final By SEARCH_DO_LINK = By.xpath("//button[@class='main-search-submit']");
    private static final By RANDOM_ITEM_LINK = By.xpath("(//*[@class='ks-new-product-image'])["+randomItemNumber+"]");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage(String url){
        driver.get(url);
        ShopWaitings.enterElementTime(driver, SEARCH_FIELD_LINK, 10);
        clickCookiesAgree();
    }
    public void clickCookiesAgree(){
        if (driver.findElement(COOKIES_LINK).isDisplayed()) {
            ShopWaitings.enterElementTime(driver, COOKIES_LINK, 10);
            driver.findElement(COOKIES_LINK).click();
        }
    }
    public void doSearch(String item){
        ShopWaitings.enterElementTime(driver, SEARCH_FIELD_LINK, 10);
        driver.findElement(SEARCH_FIELD_LINK).sendKeys(item);
        driver.findElement(SEARCH_DO_LINK).click();
    }
    public void selectBrand(String brand){
        String xpathLink = "//a[@class='ks-filter-link']//span[text()='"+brand+"']";
        ShopWaitings.enterElementTime(driver, By.xpath(xpathLink), 10);
        ShopJsClicks.javaScriptClick(driver, By.xpath(xpathLink));
    }
    public void selectItem(){
        ShopWaitings.enterElementTime(driver, RANDOM_ITEM_LINK, 10);
        ShopJsClicks.javaScriptClick(driver, RANDOM_ITEM_LINK);
    }
}
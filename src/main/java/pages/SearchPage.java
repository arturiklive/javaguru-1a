package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class SearchPage {
    static int randomItemNumber =  new Random().nextInt(48 - 1 + 1) + 1;
    private static final By COOKIES_LINK = By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    private static final By SEARCH_FIELD_LINK = By.xpath("//input[@id='q']");
    private static final By SEARCH_DO_LINK = By.xpath("//button[@class='main-search-submit']");
    private static final By RANDOM_ITEM_LINK = By.xpath("(//a[@class='ks-new-product-image'])["+randomItemNumber+"]");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage(String url){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD_LINK));
        clickCookiesAgree();
    }
    public void clickCookiesAgree(){
        if (driver.findElement(COOKIES_LINK).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIES_LINK));
            driver.findElement(COOKIES_LINK).click();
        }
    }
    public void doSearch(String item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD_LINK));
        driver.findElement(SEARCH_FIELD_LINK).sendKeys(item);
        driver.findElement(SEARCH_DO_LINK).click();
    }
    public void selectBrand(String brand){
        String xpathLink = "//a[@class='ks-filter-link']//span[text()='"+brand+"']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathLink)));
    }
    public void selectItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(RANDOM_ITEM_LINK));
        WebElement clickable_element = driver.findElement(RANDOM_ITEM_LINK);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", clickable_element);
    }
}

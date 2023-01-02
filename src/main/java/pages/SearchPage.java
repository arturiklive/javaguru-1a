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
    static int randomItemNumber =  new Random().nextInt(10 - 1 + 1) + 1;
    private static final String BASE_URL = "https://www.1a.lv/";
    private static final By COOKIES_LINK = By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    private static final By SEARCH_FIELD_LINK = By.xpath("//input[@id='q']");
    private static final By SEARCH_DO_LINK = By.xpath("//button[@class='main-search-submit']");
    private static final By RANDOM_ITEM_LINK = By.xpath("(//a[@class='ks-new-product-name'])["+randomItemNumber+"]");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() throws InterruptedException {
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD_LINK));
        Thread.sleep(1500);
        clickCookiesAgree();
    }
    public void clickCookiesAgree(){
        if (driver.findElement(COOKIES_LINK).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIES_LINK));
            driver.findElement(COOKIES_LINK).click();
        }
    }
    public void doSearch(String item) throws InterruptedException {
        driver.findElement(SEARCH_FIELD_LINK).sendKeys(item);
        Thread.sleep(1500);
        driver.findElement(SEARCH_DO_LINK).click();
        Thread.sleep(1500);
    }
    public void selectItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(RANDOM_ITEM_LINK));
        WebElement clickable_element = driver.findElement(RANDOM_ITEM_LINK);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", clickable_element);
        Thread.sleep(10500);
    }
}

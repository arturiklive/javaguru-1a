import driver.DriverFactory;
import model.ShopItem;
import model.ShopUser;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.SearchPage;

public class OneAShopTest {
    private static WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void buyItemTest() throws InterruptedException {

        ShopUser user = new ShopUser("Arturs", "Ziemelis", "tehnique@inbox.lv", "tests123", "29999999");
        ShopItem item = new ShopItem("laptop", "Asus");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage();
        searchPage.doSearch(item.getItemType());
        searchPage.selectItem();

        ProductPage productPage = new ProductPage(driver);
        Assertions.assertThat(productPage.isDisplayed()).isTrue();

        String getProductName = productPage.getProductName();
        String getProductPrice = productPage.getProductPrice();
        System.out.println(getProductName);
        System.out.println(getProductPrice);

        productPage.addProductToCart();
        Assertions.assertThat(productPage.isPurchaseSucceed()).isTrue();
        productPage.goToCartClick();

        Thread.sleep(5000);


//        String contactDetails = profilePage.getContactDetails();
//        SoftAssertions soft = new SoftAssertions();
//        soft.assertThat(contactDetails).contains(user.getName());
//        soft.assertThat(contactDetails).contains(user.getLastName());
//        soft.assertThat(contactDetails).contains(user.getEmail());
//        soft.assertThat(contactDetails).contains(user.getPhoneNumber());
//        soft.assertAll();

        Thread.sleep(10000);
    }

    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
import driver.DriverFactory;
import model.ShopItem;
import model.ShopUser;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

public class OneAShopTest {
    private static WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void buyItemTest() throws InterruptedException {

        ShopUser user = new ShopUser("Arturs", "Tehnique", "tehnique111@inbox.lv", "tests123", "29999999");
        ShopItem item = new ShopItem("laptop", "Asus");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.openPage("https://www.1a.lv/");
        searchPage.doSearch(item.getItemType());
        searchPage.selectBrand(item.getBrand());
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

        CartPage cartPage = new CartPage(driver);
        Assertions.assertThat(cartPage.cartIsOpened()).isTrue();

        String getProductNameInCart = cartPage.getProductNameInCart();
        String getProductPriceInCart = cartPage.getProductPriceInCart();
        System.out.println(getProductNameInCart);
        System.out.println(getProductPriceInCart);

        cartPage.setGoToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assertions.assertThat(checkoutPage.checkoutPageIsOpened()).isTrue();
        checkoutPage.purchaseEnterEmail(user.getEmail());
        checkoutPage.pressButtonAfterEmail();

        ShippingPage shippingPage = new ShippingPage(driver);
        Assertions.assertThat(shippingPage.shippingPageIsOpened()).isTrue();
        shippingPage.selectGetInStore();
        shippingPage.selectStore();
        shippingPage.enterPurchaserName(user.getName());
        shippingPage.enterPurchaserLastname(user.getLastName());
        shippingPage.enterPurchaserPhone(user.getPhoneNumber());
        shippingPage.clickToBilling();

        BillingPage billingPage = new BillingPage(driver);
        Assertions.assertThat(billingPage.billingPageIsOpened()).isTrue();
        billingPage.selectPayInStore();
        String getProductTotalPrice = billingPage.getTotalPrice();
        System.out.println(getProductTotalPrice);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(getProductNameInCart).contains(getProductName);
        soft.assertThat(getProductPriceInCart).contains(getProductPrice);
        soft.assertThat(getProductTotalPrice).contains(getProductPrice);
        soft.assertAll();

        Thread.sleep(10000);
    }

    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
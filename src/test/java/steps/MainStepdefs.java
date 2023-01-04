package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class MainStepdefs {
    public WebDriver driver = new ChromeDriver();
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    ShippingPage shippingPage = new ShippingPage(driver);
    BillingPage billingPage = new BillingPage(driver);
    SoftAssertions soft = new SoftAssertions();

    public static String expectedNameInCart;
    public static String expectedPriceInCart;
    public static String expectedPriceTotal;
    public static String actualProductName;
    public static String actualProductPrice;
    @Before
    public void setUpDriver() {
        driver.manage().window().maximize();
    }
    @Given("Go to {string}")
    public void goTo(String url){
        searchPage.openPage(url);
    }

    @And("Make a search for product type {string}")
    public void makeASearchForProductType(String itemType) {
        searchPage.doSearch(itemType);
    }

    @And("Select brand {string}")
    public void selectBrand(String brand){
        searchPage.selectBrand(brand);
    }

    @When("Select one random product")
    public void getRandomLinkAndSelectOneProduct(){
        searchPage.selectItem();
    }

    @Then("Verify if Product Page is opened")
    public void verifyIfProductPageIsOpened() {
        Assertions.assertThat(productPage.isDisplayed()).isTrue();
        actualProductName = productPage.getProductName();
        actualProductPrice = productPage.getProductPrice();
    }

    @And("Add product to cart")
    public void addProductToCart() {
        productPage.addProductToCart();
    }
    @And("Verify if purchase is succeed")
    public void verifyIfPurchaseIsSucceed() {
        Assertions.assertThat(productPage.isPurchaseSucceed()).isTrue();
    }

    @When("Click to go to Cart Page")
    public void clickToGoToCartPage() {
        productPage.goToCartClick();
    }

    @Then("Verify if Cart Page is opened")
    public void verifyIfCartPageIsOpened() {
        Assertions.assertThat(cartPage.cartIsOpened()).isTrue();
        expectedNameInCart = cartPage.getProductNameInCart();
        expectedPriceInCart = cartPage.getProductPriceInCart();
    }

    @When("Click to go to Checkout Page")
    public void clickToGoToCheckoutPage() {
        cartPage.setGoToCheckout();
    }

    @Then("Verify if Checkout Page is opened")
    public void verifyIfCheckoutPageIsOpened() {
        Assertions.assertThat(checkoutPage.checkoutPageIsOpened()).isTrue();
    }

    @And("In email field enter {string}")
    public void inEmailFieldEnter(String email) {
        checkoutPage.purchaseEnterEmail(email);
    }

    @When("Click to go to Shipping Page")
    public void clickToGoToShippingPage() {
        checkoutPage.pressButtonAfterEmail();
    }

    @Then("Verify if Shipping Page is opened")
    public void verifyIfShippingPageIsOpened() {
        Assertions.assertThat(shippingPage.shippingPageIsOpened()).isTrue();
    }

    @And("Select get product in Store")
    public void selectGetProductInStore() {
        shippingPage.selectGetInStore();
    }

    @And("Select Store")
    public void selectStore() {
        shippingPage.selectStore();
    }

    @And("Enter purchaser name {string}")
    public void enterPurchaserName(String name) {
        shippingPage.enterPurchaserName(name);
    }

    @And("Enter purchaser lastname {string}")
    public void enterPurchaserLastname(String lastname) {
        shippingPage.enterPurchaserLastname(lastname);
    }

    @And("Enter purchaser phone {string}")
    public void enterPurchaserPhone(String phone) {
        shippingPage.enterPurchaserPhone(phone);
    }

    @And("Click to save data before going to Billing Page")
    public void clickToSaveDataBeforeGoingToBillingPage() throws InterruptedException {
        shippingPage.clickToSaveBeforeBilling();
    }

    @When("Click to go to Billing Page")
    public void clickToGoToBillingPage() throws InterruptedException {
        shippingPage.clickToBilling();
    }

    @Then("Verify if Billing Page is opened")
    public void verifyIfBillingPageIsOpened() {
        Assertions.assertThat(billingPage.billingPageIsOpened()).isTrue();
    }

    @And("Select Pay in Store option")
    public void selectPayInStoreOption() {
        billingPage.selectPayInStore();
        expectedPriceTotal = billingPage.getTotalPrice();
    }

    @Then("Compare that expected product name in checkout section contains purchased actual product name")
    public void compareThatProductNameInCheckoutSectionContainsPurchasedProductName() {
        soft.assertThat(expectedNameInCart).contains(actualProductName);
    }

    @Then("Compare that expected product price in checkout section contains purchased actual product price")
    public void compareThatProductPriceInCheckoutSectionContainsPurchasedProductPrice() {
        soft.assertThat(expectedPriceInCart).contains(actualProductPrice);
    }

    @Then("Compare that expected total price in paying section contains actual product price")
    public void compareThatTotalPriceInPayingSectionContainsProductPrice() {
        soft.assertThat(expectedPriceTotal).contains(actualProductPrice);
        soft.assertAll();
    }
    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }
}
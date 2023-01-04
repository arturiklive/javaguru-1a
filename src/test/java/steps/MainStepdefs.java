package steps;

import driver.DriverFactory;
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

    @And("Get random link and select one product")
    public void getRandomLinkAndSelectOneProduct(){
        searchPage.selectItem();
    }

    @When("Verify if Product Page is opened")
    public void verifyIfProductPageIsOpened() {
        Assertions.assertThat(productPage.isDisplayed()).isTrue();
    }

    @Then("Get product name")
    public String getProductName() {
        return productPage.getProductName();
    }

    @And("Get product price")
    public String getProductPrice() {
        return productPage.getProductPrice();
    }

    @And("Add product to cart")
    public void addProductToCart() {
        productPage.addProductToCart();
    }
    @And("Verify if purchase is succeed")
    public void verifyIfPurchaseIsSucceed() {
        Assertions.assertThat(productPage.isPurchaseSucceed()).isTrue();
    }

    @And("Click to go to Cart Page")
    public void clickToGoToCartPage() {
        productPage.goToCartClick();
    }

    @When("Verify if Cart Page is opened")
    public void verifyIfCartPageIsOpened() {
        Assertions.assertThat(cartPage.cartIsOpened()).isTrue();
    }

    @Then("Get product name in Cart")
    public String getProductNameInCart() {
        return cartPage.getProductNameInCart();
    }

    @And("Get product price in Cart")
    public String getProductPriceInCart() {
        return cartPage.getProductPriceInCart();
    }

    @And("Click to go to Checkout Page")
    public void clickToGoToCheckoutPage() {
        cartPage.setGoToCheckout();
    }

    @When("Verify if Checkout Page is opened")
    public void verifyIfCheckoutPageIsOpened() {
        Assertions.assertThat(checkoutPage.checkoutPageIsOpened()).isTrue();
    }

    @Then("In email field enter {string}")
    public void inEmailFieldEnter(String email) {
        checkoutPage.purchaseEnterEmail(email);
    }

    @And("Click to go to Shipping Page")
    public void clickToGoToShippingPage() {
        checkoutPage.pressButtonAfterEmail();
    }

    @When("Verify if Shipping Page is opened")
    public void verifyIfShippingPageIsOpened() {
        Assertions.assertThat(shippingPage.shippingPageIsOpened()).isTrue();
    }

    @Then("Select get product in Store")
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

    @And("Click to go to Billing Page")
    public void clickToGoToBillingPage() throws InterruptedException {
        shippingPage.clickToBilling();
    }

    @When("Verify if Billing Page is opened")
    public void verifyIfBillingPageIsOpened() {
        Assertions.assertThat(billingPage.billingPageIsOpened()).isTrue();
    }

    @Then("Select Pay in Store option")
    public void selectPayInStoreOption() {
        billingPage.selectPayInStore();
    }

    @And("Get total price")
    public String getTotalPrice() {
        return billingPage.getTotalPrice();
    }

    @When("Compare that product name contains name from cart")
    public void compareThatProductNameContainsNameFromCart() {
        System.out.println(cartPage.getProductNameInCart());
        System.out.println(productPage.getProductName());
        soft.assertThat(cartPage.getProductNameInCart()).contains(productPage.getProductName());
    }

    @Then("Compare that product price contains price from cart")
    public void compareThatProductPriceContainsPriceFromCart() {
        soft.assertThat(cartPage.getProductPriceInCart()).contains(productPage.getProductPrice());
    }

    @Then("Compare that total price contains product price")
    public void compareThatTotalPriceContainsProductPrice() {
        soft.assertThat(billingPage.getTotalPrice()).contains(productPage.getProductPrice());
        soft.assertAll();
    }

    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }

}
package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ProductPage;
import pages.SearchPage;

public class MainStepdefs {
    public WebDriver driver = new ChromeDriver();
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    @Given("Go to {string}")
    public void goTo(String url){
        searchPage.openPage(url);
    }

    @And("Make a search for product type {string}")
    public void makeASearchForProductType(String itemType) {
        searchPage.doSearch(itemType);
    }

    @And("Select brand {string}")
    public void selectBrand(String brand) {
        searchPage.selectBrand(brand);
    }

    @And("Get random link and select one product")
    public void getRandomLinkAndSelectOneProduct() {
        searchPage.selectItem();
    }

    @When("Verify if Product Page is opened")
    public void verifyIfProductPageIsOpened() {
        Assertions.assertThat(productPage.isDisplayed()).isTrue();
    }

    @Then("Get product name")
    public void getProductName() {
        String getProductName = productPage.getProductName();
    }

    @And("Get product price")
    public void getProductPrice() {
        String getProductPrice = productPage.getProductPrice();
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
    public void getProductNameInCart() {
        String getProductNameInCart = cartPage.getProductNameInCart();
    }

    @And("Get product price in Cart")
    public void getProductPriceInCart() {
        String getProductPriceInCart = cartPage.getProductPriceInCart();
    }

    @And("Click to go to Checkout Page")
    public void clickToGoToCheckoutPage() {
        cartPage.setGoToCheckout();
    }

    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }
}
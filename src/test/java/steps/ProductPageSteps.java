package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ProductPage;

import static driver.DriverProvider.driver;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage(driver());

    @Then("Verify if Product Page is opened")
    public void verifyIfProductPageIsOpened() {
        Assertions.assertThat(productPage.isDisplayed()).isTrue();
        MainPageSteps.actualProductName = productPage.getProductName();
        MainPageSteps.actualProductPrice = productPage.getProductPrice();
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
}

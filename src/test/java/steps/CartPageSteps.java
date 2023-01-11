package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.CartPage;

import static driver.DriverProvider.driver;

public class CartPageSteps {
    CartPage cartPage = new CartPage(driver());

    @Then("Verify if Cart Page is opened")
    public void verifyIfCartPageIsOpened() {
        Assertions.assertThat(cartPage.cartIsOpened()).isTrue();
        MainPageSteps.expectedNameInCart = cartPage.getProductNameInCart();
        MainPageSteps.expectedPriceInCart = cartPage.getProductPriceInCart();
    }

    @When("Click to go to Checkout Page")
    public void clickToGoToCheckoutPage() {
        cartPage.setGoToCheckout();
    }
}

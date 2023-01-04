package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.CheckoutPage;

import static driver.DriverProvider.driver;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage = new CheckoutPage(driver());
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
}

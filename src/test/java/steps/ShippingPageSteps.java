package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ShippingPage;

import static driver.DriverProvider.driver;

public class ShippingPageSteps {
    ShippingPage shippingPage = new ShippingPage(driver());
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
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.BillingPage;

import static driver.DriverProvider.driver;

public class BillingPageSteps {
    BillingPage billingPage = new BillingPage(driver());

    @Then("Verify if Billing Page is opened")
    public void verifyIfBillingPageIsOpened() {
        Assertions.assertThat(billingPage.billingPageIsOpened()).isTrue();
    }

    @And("Select Pay in Store option")
    public void selectPayInStoreOption() {
        billingPage.selectPayInStore();
        MainPageSteps.expectedPriceTotal = billingPage.getTotalPrice();
    }
}

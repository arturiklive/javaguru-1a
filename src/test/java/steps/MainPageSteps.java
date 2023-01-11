package steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class MainPageSteps {
    public static String expectedNameInCart;
    public static String expectedPriceInCart;
    public static String expectedPriceTotal;
    public static String actualProductName;
    public static String actualProductPrice;
    SoftAssertions soft = new SoftAssertions();

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
}
package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SearchPage;

import static driver.DriverProvider.driver;

public class SearchPageSteps {
    SearchPage searchPage = new SearchPage(driver());

    @Given("Go to {string}")
    public void goTo(String url) {
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

    @When("Select one random product")
    public void getRandomLinkAndSelectOneProduct() {
        searchPage.selectItem();
    }
}

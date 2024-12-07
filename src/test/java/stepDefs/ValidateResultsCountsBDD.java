package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.MainPage.*;

public class ValidateResultsCountsBDD {
    @When("I search for the product {string}")
    public void iSearchForTheProduct(String product) throws InterruptedException {
        search_product(product);
    }

    @And("I filter the results by size {string}")
    public void iFilterTheResultsBySize(String size) throws InterruptedException {
        filter_size(size);
    }

    @And("I included filter price {string}")
    public void iIncludedFilterPrice(String price) throws InterruptedException {
        filter_price(price);
    }

    @And("I included filter brand {string}")
    public void iIncludedFilterBrand(String brand) throws InterruptedException {
        search_brand(brand);
    }

    @Then("I should see the results count")
    public void iShouldSeeTheResultsCount() throws InterruptedException {
        verify_count();
    }
}

package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.MainPage.*;
import static pages.ProductDetailsPage.*;

public class ValidateItemBDD {
    @Given("I am on the Liverpool home page")
    public void iAmOnTheHomePage() throws InterruptedException {
        locate_search_bar();
    }

    @When("I search for product {string}")
    public void iSelectAProduct(String product) throws InterruptedException {
        search_product(product);
    }

    @And("I select the first product {string}")
    public void iSelectTheFirstProduct(String product) throws InterruptedException {
        select_product(product);
    }

    @Then("I should see the product title {string}")
    public void iShouldSeeTheProductDetails(String product) throws InterruptedException {
        verify_title(product);
    }

    @And("I should see the product price")
    public void iShouldSeeTheProductPrice() throws InterruptedException {
        verify_price();
    }


}

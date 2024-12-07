package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.MainPage.*;

public class FilterCategoriesBDD {
    @When("I click on the Categories menu")
    public void iClickOnTheMenu() throws InterruptedException {
        select_categories();
    }

    @And("Place the Cursor in the {string} option")
    public void placeTheCursorInTheOption(String menu) throws InterruptedException {
        select_menu(menu);
    }

    @And("Click on the {string} option")
    public void clickOnTheOption(String subMenu) throws InterruptedException {
        select_sub_menu(subMenu);
    }

    @And("Selecting {string} brand")
    public void selectingBrand(String brand) throws InterruptedException {
        search_brand(brand);
    }

    @Then("I should see a {string} product")
    public void iShouldSeeAllTheScents(String product) throws InterruptedException {
        verify_product(product);
    }
}

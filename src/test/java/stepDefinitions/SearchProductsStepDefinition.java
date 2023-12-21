package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class SearchProductsStepDefinition {
    SearchProductPage searchProductPage = new SearchProductPage();

    @And("User search for {string}")
    public void userSearchFor(String productName) {
        ReusableMethods.sendKeysJS(searchProductPage.searchBox,
                productName + Keys.ENTER) ;
        ReusableMethods.click(searchProductPage.searchButton);
    }

    @Then("Check title contains {string}")
    public void checkTitleContains(String productName) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(productName));

    }




}

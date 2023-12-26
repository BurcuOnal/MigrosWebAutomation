package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.ExcelReader;
import utilities.ReusableMethods;


public class SearchProductsStepDefinition {
    SearchProductPage searchProductPage = new SearchProductPage();

    @And("User search for {string}")
    public void userSearchFor(String productName) {
        ReusableMethods.sendKeysJS(searchProductPage.searchBox, productName) ;
        ReusableMethods.wait(5);
        ReusableMethods.click(searchProductPage.searchButton);
        ReusableMethods.wait(5);
    }

    @Then("Check title contains {string}")
    public void checkTitleContains(String productName) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(productName));

    }


    @When("enter info from {string} excel file")
    public void enterInfoFromExcelFile(String pageName) {
        String dosyaYolu= "src/test/resources/migrosDatas.xlsx";
        ExcelReader excelReader= new ExcelReader(dosyaYolu,pageName);

        System.out.println(excelReader.getCellData(0, 0));
        System.out.println(excelReader.getCellData(0, 1));

    }
}

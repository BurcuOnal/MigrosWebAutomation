package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import pages.SearchProductPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class SearchProductsStepDefinition {

    SearchProductPage searchProductPage = new SearchProductPage();

    @And("User search for {string}")
    public void userSearchFor(String productName) {
        ReusableMethods.sendKeys(searchProductPage.searchBox, productName);
        ReusableMethods.click(searchProductPage.searchButton);
        System.out.print(Driver.getDriver().getCurrentUrl());
        ReusableMethods.wait(5);

    }

    @Then("Check currentURL contains {string}")
    public void checkCurrentURLContains(String productName) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("ta"));
    }

    @And("Add first product to the basket")
    public void addFirstProductToTheBasket() {
        ReusableMethods.javaScriptClicker(searchProductPage.firstProduct);
        searchProductPage.firstProduct.click();
        ReusableMethods.javaScriptClicker(searchProductPage.addToBasketButton);
    }

    @And("Go to basket")
    public void goToBasket() {
        ReusableMethods.moveToElement(searchProductPage.homePageBasket);
        ReusableMethods.javaScriptClicker(searchProductPage.GoToBasket);
        ReusableMethods.wait(3);
        ReusableMethods.scrollToElement(searchProductPage.totalPrice);
        ReusableMethods.wait(3);

    }


    @Then("Check if the product price and basket price are the same")
    public void checkIfTheProductPriceAndBasketPriceAreTheSame() {
        ReusableMethods.javaScriptClicker(searchProductPage.productPrice1);
        ReusableMethods.javaScriptClicker(searchProductPage.totalPrice);
        String productPriceText1 = searchProductPage.productPrice1.getText();
        String totalPriceText = searchProductPage.totalPrice.getText();
        Assert.assertEquals(productPriceText1, totalPriceText);
        System.out.println(productPriceText1+totalPriceText);

    }

    @And("Add one more different product to the basket")
    public void addOneMoreDifferentProductToTheBasket() {
    }


    @Then("Check if the basket price and total price of the products are same")
    public void checkIfTheBasketPriceAndTotalPriceOfTheProductsAreSame() {
    }


//    @When("enter info from {string} excel file")
//    public void enterInfoFromExcelFile(String pageName) {
//        String dosyaYolu= "src/test/resources/migrosDatas.xlsx";
//        ExcelReader excelReader= new ExcelReader(dosyaYolu,pageName);
//
//        System.out.println(excelReader.getCellData(0, 0));
//        System.out.println(excelReader.getCellData(0, 1));
//
//    }


}

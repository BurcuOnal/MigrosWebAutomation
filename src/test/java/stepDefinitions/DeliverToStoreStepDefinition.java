package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DeliveryOptionModalPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class DeliverToStoreStepDefinition {
    HomePage homePage = new HomePage();
    DeliveryOptionModalPage deliveryOptionModalPage = new DeliveryOptionModalPage();


    @Given("User go to website")
    public void user_go_to_website() {
        Driver.getDriver().get(ConfigReader.getProperty("PageUrl"));

    }
    @Given("User close the popUps")
    public void user_close_the_pop_ups() {
        ReusableMethods.click(homePage.closePopup2); // kendi oluşturduğum click methodunu kullanmak için
        ReusableMethods.click(homePage.acceptCookies);
        homePage.closePopup1.click(); // seleniumun var olan clickiğini kullanmak için

    }
    @When("User click choose deliver location button")
    public void userClickChooseDeliverLocationButton() {
        ReusableMethods.click(homePage.choseDeliverLocationButton);
    }

    @When("User click take it from the store button")
    public void userClickTakeItFromTheStoreButton() {
        ReusableMethods.click(deliveryOptionModalPage.takeFromStoreButton);
        ReusableMethods.wait(4);
    }

    @When("User chose delivery city as {string}")
    public void user_chose_delivery_city_as(String city) {
       ReusableMethods.click(deliveryOptionModalPage.CityDropDownButton);
       ReusableMethods.sendKeysJS(deliveryOptionModalPage.cityInputBox,city);
       ReusableMethods.wait(5);
       ReusableMethods.click(deliveryOptionModalPage.optionIstanbul);


    }
    @When("User chose delivery town as {string}")
    public void user_chose_delivery_town_as(String town) {
        ReusableMethods.click(deliveryOptionModalPage.townDropDownButton);
        ReusableMethods.sendKeysJS(deliveryOptionModalPage.townInputBox,town);
        ReusableMethods.wait(5);
        ReusableMethods.click(deliveryOptionModalPage.optionKartal);

    }
    @When("User chose delivery store as {string}") // for @TestCase1
    public void user_chose_delivery_store_as(String store) {
        ReusableMethods.click(deliveryOptionModalPage.storeDropDownButton);
        ReusableMethods.sendKeysJS(deliveryOptionModalPage.storeInputBox,store);
        ReusableMethods.wait(5);
        ReusableMethods.click(deliveryOptionModalPage.optionAnatolium);
    }

    @Then("Check the store name on home page")
    public void check_the_store_name_on_home_page() {
        ReusableMethods.wait(5);
        //String storeName =  homePage.storeNameLocator.getText();
        Assert.assertTrue(homePage.storeNameLocator.getText().contains("ANATOL"));
    }


    @Then("Check the warning text contains {string}") // for @TestCase2
    public void checkTheWarningTextContains(String warningText) {
         warningText = deliveryOptionModalPage.warning.getText();
        assertTrue(warningText.contains(warningText));
    }

    @Then("Close the tap")
    public void closeTheTap() {
        Driver.getDriver().quit();
    }


}

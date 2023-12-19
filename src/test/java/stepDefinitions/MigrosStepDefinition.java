package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DeliveryOptionModal;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MigrosStepDefinition{
    HomePage homePage = new HomePage();
    DeliveryOptionModal modal = new DeliveryOptionModal();


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
        ReusableMethods.click(modal.takeFromStoreButton);
    }

    @When("User chose delivery city as {string}")
    public void user_chose_delivery_city_as(String city) {
       ReusableMethods.click(modal.CityDropDownButton);
       ReusableMethods.sendKeysJS(modal.cityInputBox,city);
       ReusableMethods.wait(5);
       ReusableMethods.click(modal.optionIstanbul);


    }
    @When("User chose delivery town as {string}")
    public void user_chose_delivery_town_as(String town) {
        ReusableMethods.click(modal.townDropDownButton);


    }
    @When("User chose delivery store as {string}")
    public void user_chose_delivery_store_as(String store) {


    }



}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeliveryOptionModalPage {
    public DeliveryOptionModalPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "#delivery-options-modal_store .mat-mdc-card-content")
    public WebElement takeFromStoreButton;

    @FindBy(id = "delivery-options-modal_city")
    public WebElement CityDropDownButton;

    @FindBy(css = "#mat-select-0-panel > input")
    public WebElement cityInputBox;

    @FindBy(xpath = "//*[@id=\"mat-option-1\"]")
    public WebElement optionIstanbul;

    @FindBy(id = "delivery-store-modal_town")
    public WebElement townDropDownButton;

    @FindBy(xpath = "//input[@role='search']")
    public WebElement townInputBox;

    @FindBy(xpath = "//*[@id=\"mat-option-102\"]")
    public WebElement optionKartal;


    @FindBy(id = "delivery-options-modal_store")
    public WebElement storeDropDownButton;

    @FindBy(css = "input[role='search']")
    public WebElement storeInputBox;

    @FindBy(xpath = "(//span[@class='mdc-list-item__primary-text'])[1]")
    public WebElement optionAnatolium;




    @FindBy(css = "#mat-mdc-error-11")
    public WebElement warning;

}

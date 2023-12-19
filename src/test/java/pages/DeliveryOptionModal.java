package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryOptionModal {


    @FindBy(xpath = "//fe-selectable-card[@id='delivery-options-modal_store']//mat-card-content[@class='mat-mdc-card-content']")
    public WebElement takeFromStoreButton;

    @FindBy(id = "delivery-options-modal_city")
    public WebElement CityDropDownButton;

    @FindBy(css = "#mat-select-0-panel > input")
    public WebElement cityInputBox;

    @FindBy(xpath = "//*[@id=\"mat-option-1\"]")
    public WebElement optionIstanbul;

    @FindBy(id = "delivery-store-modal_town")
    public WebElement townDropDownButton;
}

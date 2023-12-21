package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "accept-all")
    public WebElement acceptCookies;


    @FindBy(css = "#header-wrapper > div.header-middle > div.popover > div > fa-icon > svg")
    public WebElement closePopup1;

    @FindBy(css = "#mat-mdc-dialog-0 > div > div > fe-product-try-ai-popup > div > div > div > fa-icon > svg")
    public WebElement closePopup2;

    @FindBy(css = "#delivery-options-search-bucket")
    public WebElement choseDeliverLocationButton;

    @FindBy(xpath = "//div[@class='delivery-options-inner-text mat-caption']")
    public WebElement storeNameLocator;


}

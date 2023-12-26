package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchProductPage {
    public SearchProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "product-search-combobox--trigger")
    public WebElement searchBox;
    @FindBy(css= "div[class='migros-search-right-button subtitle-2']")
    public WebElement searchButton;




    @FindBy(css= "sm-list-page-item:nth-child(1)")
    public WebElement firstProduct;
    // (//sm-list-page-item [@class='mdc-layout-grid__cell--span-2-desktop mdc-layout-grid__cell--span-4-tablet mdc-layout-grid__cell--span-2-phone ng-star-inserted'])[1]
    @FindBy(css= "div[class='actions'] span[class='mat-mdc-button-touch-target']")
    public WebElement addToBasketButton;

    @FindBy(id= "homepage-cart-button")
    public WebElement homePageBasket;

    @FindBy(xpath = "//button[@class='subtitle-2']")
    public WebElement GoToBasket;

    @FindBy(id = "20000007155996")
    public WebElement scrollhere;


}


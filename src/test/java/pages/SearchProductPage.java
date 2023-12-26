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

}


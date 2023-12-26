package utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static utilities.Driver.getDriver;

public class ReusableMethods {

    //HARD WAIT METHOD
    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    //Alert ACCEPT
    public static void alertAccept() {
        getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
 /*
 Select select2 = new Select(gun);
 select2.selectByVisibleText("7");

 //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
 */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }
    //Tüm Sayfa ScreenShot
    public static void screenShot(String name) {
        String date = DateTimeFormatter.ofPattern("yy.MM.dd_hh.mm").format( LocalDateTime.now() );
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/com/allovercommerce/testOutputs/screenshots/" + name + date + ".png";

        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //WebElement ScreenShot

//webelement screenshot


    public static void  screenShotOfWebElement(WebElement webElement){

        String date = DateTimeFormatter.ofPattern("yy.MM.dd_hh.mm").format( LocalDateTime.now() );
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/com/allovercommerce/testOutputs/webElementScreenshots/"+"_"+date + ".png";


        try {
            Files.write(  Paths.get(dosyaYolu) , webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    // Js Click Method
    public static void click(WebElement element) {
        scrollToElement(element);
        waitByMilliSeconds(500);
        element.click();

    }

    public static void click2(WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void click3() {
        WebElement webElement = getDriver().findElement(By.id("product-search-combobox-search-right-button"));
        scrollToElement(webElement);
        waitByMilliSeconds(500);
        webElement.click();
        waitByMilliSeconds(5000);

    }

    public static void javaScriptClicker(WebElement element) {

        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);" + "arguments[0].style.border='6px dotted blue'", element);
    }

    public static void javaScriptClicker2(WebElement element) {

        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);" + "arguments[0].style.border='6px dotted blue'", element);
    }

    public static void pressENTER() {
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ENTER).click();

    }




    public static void keysEsc(WebElement element){
        element.sendKeys(Keys.ESCAPE);
    }

    public static void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
    }


    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        scrollToElement(element);
        waitByMilliSeconds(500);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

// mouse u üzerine elementin üzerine götürüp bekleme
    public static void moveToElement(WebElement element){
        Actions actions =new Actions(getDriver());
        actions.moveToElement(element).perform();
        wait(2);
    }

    public static void textControl(WebElement element, String text){
        String warningText = element.getText();
        Assert.assertEquals (text, warningText);
    }





}
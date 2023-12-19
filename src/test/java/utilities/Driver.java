package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (Driver.driver.get() == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    Driver.driver.set(new ChromeDriver());

                    break;
                case "edge":
                    Driver.driver.set(new EdgeDriver());
                    break;
                case "safari":
                    Driver.driver.set(new SafariDriver());
                    break;
                case "firefox":
                    Driver.driver.set(new FirefoxDriver());
                    break;
                default:
                    Driver.driver.set(new ChromeDriver());
            }


            Driver.driver.get().manage().window().maximize();
            Driver.driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

           // Driver.getDriver().get(ConfigReader.getProperty("PageUrl"));
        }
        return Driver.driver.get();
    }

    public Driver() {
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }



}

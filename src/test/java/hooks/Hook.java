package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hook {
    @Before
    public void setUp() throws Exception {
        System.out.println("before method çalış");


    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", "scenario" + scenario.getName());
            Driver.closeDriver();
        }


    }
}


    /*
    Eğer sadece istediğimiz spesifik bir senaryodan önce çalışmasını istediğimiz bir kod olursa before rotasyonu parametresi
    parantezi içine tag'ı belirtiriz. sadece tagı belirttiğimiz senaryo önce veya sonra çalışır
    örn: public void setUp(@spesifikSenaryoTagı) throws Exception {....
     */

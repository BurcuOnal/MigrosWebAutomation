package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //detailed info console
        //        "html:target/default-cucumber-reports.html",// for reports
        //            "json:target/json-reports/cucumber.json",// for reports
        //            "junit:target/xml-report/cucumber.xml",// for reports
        },

        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@UserStory2",
                //seneryo taglarını kullanarak spesifik seneryolar çalıştırılabilir
       // dryrun: check if there is missing stepDef when u say true, (false default)
        dryRun = false
)
public class Runner {

}

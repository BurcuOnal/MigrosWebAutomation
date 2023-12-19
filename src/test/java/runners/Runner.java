package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@UserStory1", //seneryo taglarını kullanarak spesifik seneryolar çalıştırılabilir
       // dryrun: check if there is missing stepDef when u say true, (false default)
        dryRun = false
)
public class Runner {

}

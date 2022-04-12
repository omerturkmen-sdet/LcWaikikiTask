package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-test-report"},
        features = "@target/rerun.txt",
        glue = "stepDefinitions"
)
public class FailedTestRunner {
}

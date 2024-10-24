package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue ={"src/test/java/stepDefinitions", "src/test/java/utility"},
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
)

public class TestRunner {


}

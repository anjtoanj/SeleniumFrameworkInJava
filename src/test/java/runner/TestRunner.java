package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/HomePagev1feature.feature",
        glue ={"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
)

public class TestRunner {
}

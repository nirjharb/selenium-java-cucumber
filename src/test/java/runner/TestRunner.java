package runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"}, // Path to your feature files
        glue = {"src/test/java/stepDefinition"}, // Path to your step definition files
        plugin = {"pretty", "target/cucumber-reports/cucumber.html"}, // Report generation
        monochrome = true,
        tags = "@login"
)

public class TestRunner {

}

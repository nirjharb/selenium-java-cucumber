package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"}, // Path to your feature files
        glue = {"utility", "stepDefinition"}, // Path to your step definition files
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, // Allure Report generation
        monochrome = true,
        tags = "@login"
)

public class TestRunner {

}

package cucumber.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin="pretty",
        monochrome =  true,
        tags = "@smoke",
        glue = {"cucumber.testng.steps", "cucumber.testng.hooks"},
        features = "src/test/resources"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

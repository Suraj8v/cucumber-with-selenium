package login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"login"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

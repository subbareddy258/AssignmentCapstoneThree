package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/report/cucumber.html","json:target/report/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {


}


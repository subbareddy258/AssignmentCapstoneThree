package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue = "stepDefinitions",
        plugin = { "pretty", "json:target/cucumber.json","html:target/cucumber.html" })
public class TestRunner extends AbstractTestNGCucumberTests {


}


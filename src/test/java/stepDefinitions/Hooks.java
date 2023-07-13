package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;

import static stepDefinitions.CreateBookingStepDefinition.report;
import static stepDefinitions.CreateBookingStepDefinition.test;

public class Hooks {
    protected static ExtentReports extentReports;

    @Before
    public   void setup() {
        // Perform setup actions here

    }

    @After
    public  void tearDown() {
        report.endTest(test);
        report.flush();
    }


}

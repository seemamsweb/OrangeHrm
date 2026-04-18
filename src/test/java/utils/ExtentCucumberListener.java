package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentCucumberListener {

	static ExtentReports extent = ExtentReportManager.getExtentReport();
    static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Step Failed");
        } else {
            test.log(Status.PASS, "Step Passed");
        }
    }

    @After
    public void afterScenario() {
        extent.flush();
    }
}
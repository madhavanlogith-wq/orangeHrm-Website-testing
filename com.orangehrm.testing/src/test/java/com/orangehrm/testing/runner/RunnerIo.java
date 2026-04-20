package com.orangehrm.testing.runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\acer\\git\\orangehrm-automation\\com.orangehrm.testing\\src\\test\\java\\com\\orangehrm\\testing\\featurefile\\LeaveModule.feature"},
		glue = "com.orangehrm.testing.stepdefinition",
		dryRun = !true,
		monochrome = true,
		plugin= {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//				Tags= {"@fk"}
		}
		)
public class RunnerIo extends AbstractTestNGCucumberTests{
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}


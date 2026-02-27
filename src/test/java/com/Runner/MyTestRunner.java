package com.Runner;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =   "src/test/resources/com/features",
              // "src/test/resources/com/features/LoginPage.feature"},
        		//"src/test/resources/com/features/EmployeeOnLeaveConfiguration.feature",
        
        glue = {"stepdefination", "AppHooks"},
        		 tags = "@KPIs",
        		 plugin = {
                "pretty",
               "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
               "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        publish = true
)

	public class MyTestRunner extends AbstractTestNGCucumberTests {




}
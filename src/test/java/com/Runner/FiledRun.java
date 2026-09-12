package com.Runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//runs only file test cases 
@CucumberOptions(
        features = {"@target/rerun.txt"},
        glue = {"stepdefination", "AppHooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        publish = true
)

public class FiledRun extends AbstractTestNGCucumberTests{

	
}

package com.Runner;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.CucumberOptions;
/*
@CucumberOptions(
	    features = "src/test/resources/com/features/LoginPage.feature",
	    glue = {"stepdefination","AppHooks"},   // ✅ EXACT package name
	   
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"
        },
	    monochrome = true,
	    publish = true //reprot ko publish kr ne keliye
	)
*/

@CucumberOptions(
        features = "src/test/resources/com/features/DashboardPage.feature",
        glue = {"stepdefination", "AppHooks"},
       // tags=("@sanity"),
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
//	@BeforeClass(alwaysRun = true)
//    @Parameters({"browser", "featurePath"})
//    public void setUp(
//            @Optional("chrome") String browser,
//            @Optional("/Cucumber/src/test/resources/com/features/LoginPage.feature") String featurePath
//    ) {
//        // ----------------------------
//        // 1️⃣ Set Browser in ThreadLocal
//        // ----------------------------
//        BrowserContext.setBrowser(browser);
//
//        // ----------------------------
//        // 2️⃣ Dynamically set feature path
//        // ----------------------------
//        System.setProperty("cucumber.features", featurePath);
//
//        // ----------------------------
//        // 3️⃣ Logging
//        // ----------------------------
//        System.out.println("---------------------------------------------------");
//        System.out.println("Runner Setup Info:");
//        System.out.println("Feature Path -> " + featurePath);
//        System.out.println("Browser      -> " + browser);
//        System.out.println("---------------------------------------------------");
//    }
//
//    /**
//     * Optional: override scenarios parallelism per runner
//     * Default: sequential scenario execution within this feature
//     * Can be customized if needed:
//     *
//     * @return cucumber scenarios to run in parallel
//     */
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//	    return super.scenarios();
	//}

}
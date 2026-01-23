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


}

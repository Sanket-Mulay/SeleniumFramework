package AppHooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.plugin.event.Status;

import com.Runner.BrowserContext;
import com.qa.factory.DriverFactory;
import com.qa.utill.ConfigReader;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
    private WebDriver driver;
    private Properties prop;
    private ConfigReader configReader;
    
    @Before(value="skip_scenario")
    public void skip_scenario(Scenario scenario) {
    	System.out.println("Skipped Scenario"+scenario.getName());
    	
    	
    }

    // ✅ Cucumber Before hook (NOT @BeforeClass)
    @Before(order = 1)
    public void getProperty() throws IOException {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 2)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName); // ✅ assign driver
        driver.manage().window().maximize();   // ✅ ADD THIS LINE
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            try {
                // ✅ Wait until page fully loaded (fix black screenshot)
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(
                        wd -> ((JavascriptExecutor) wd)
                                .executeScript("return document.readyState")
                                .equals("complete")
                );

                // ✅ Small buffer wait
                Thread.sleep(500);

                // 📸 Take screenshot
                byte[] screenshot =
                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // ❌ FAILED
                if (scenario.isFailed()) {
                    scenario.attach(
                            screenshot,
                            "image/png",
                            scenario.getName() + " - Failed Screenshot"
                    );
                    System.out.println("❌ Failed screenshot attached");
                }
                // ⏭️ SKIPPED
                else if ("SKIPPED".equals(scenario.getStatus().name())) {
                    scenario.attach(
                            screenshot,
                            "image/png",
                            scenario.getName() + " - Skipped Screenshot"
                    );
                    System.out.println("⏭️ Skipped screenshot attached");
                }
                
                // ✅ PASSED
                else {
                	Thread.sleep(2000);
                    scenario.attach(
                            screenshot,
                            "image/png",
                            scenario.getName() + " - Passed Screenshot"
                    );
                    System.out.println("✅ Passed screenshot attached");
                }

            } catch (Exception e) {
                System.out.println("❌ Screenshot capture failed: " + e.getMessage());
            } finally {
                // ✅ Quit browser AFTER screenshot
              driver.quit();
            }
        }
    }
}
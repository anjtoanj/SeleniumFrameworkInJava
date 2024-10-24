package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;

import java.sql.SQLException;

public class hook {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Get browser parameter from system properties or default to Chrome
        String browser = System.getProperty("browser", "IE");

        // Initialize WebDriver based on the specified browser
        driver = DriverManager.initializeDriver(browser);
        System.out.println("=== WebDriver Initialized for Browser: " + browser + " ===");
    }

    @After
    public void tearDown(){
        // Quit WebDriver after each scenario
        DriverManager.quitDriver();
        System.out.println("=== WebDriver Closed after Scenario ===");
    }
}

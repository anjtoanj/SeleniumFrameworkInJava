package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverManager {

    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {}


    // Enum for supported browsers
    public enum BrowserType {
        CHROME,
        FIREFOX,
        IE
    }

    // Method to initialize the WebDriver
    public static WebDriver initializeDriver(String browserName) {
        if (driver == null) {

            BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
            switch (browserType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    InternetExplorerOptions options = new InternetExplorerOptions();
                    options.ignoreZoomSettings();  // Ignore the IE zoom level
                    options.introduceFlakinessByIgnoringSecurityDomains();  // Ignore protected mode
                    options.requireWindowFocus();  // Improve focus handling
                    driver = new InternetExplorerDriver(options);
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported");
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver first.");
        }
        return driver;
    }

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Resetting driver to null after quitting
        }
    }
}

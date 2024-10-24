package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverManager {

    private static WebDriver driver;

    // Method to initialize the WebDriver
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
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

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Resetting driver to null after quitting
        }
    }
}

package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.uri.Uri;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePagev1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class TCSeleniumGrid {
    public static WebDriver driver;
    private HomePagev1 homePagev1;

    @BeforeTest
    public void setUp() throws MalformedURLException {
       String huburl = "http://localhost:4444/wd/hub";
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setPlatform(Platform.WIN11);
       cap.setBrowserName("chrome");

        try {
            driver = new RemoteWebDriver(new URL(huburl),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Initialize the base page
        homePagev1 = new HomePagev1(driver);

        // Open the home page
        homePagev1.openhomePage();
    }

    @Test
    public void testHomePage() {
        Assert.assertEquals(driver.getTitle(),"Auckland Council");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after tests
        if (driver != null) {
            driver.quit();
        }
    }
}

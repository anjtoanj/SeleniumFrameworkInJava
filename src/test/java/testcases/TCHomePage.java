package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePagev1;

public class TCHomePage {
    private WebDriver driver;
    private HomePagev1 homePagev1;

   @BeforeTest
    public void setUp() {
        // Set up WebDriver (using ChromeDriver )
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

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

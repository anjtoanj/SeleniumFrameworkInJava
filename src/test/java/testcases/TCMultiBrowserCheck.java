package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePagev1;

public class TCMultiBrowserCheck {
    private WebDriver driver;
    private HomePagev1 homePagev1;

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) {
        System.out.println("Chrome Browser");
        // Set up WebDriver (using ChromeDriver )
        if (browserName.equalsIgnoreCase("Chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
         else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
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

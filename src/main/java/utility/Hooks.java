package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        // Configure ChromeOptions if needed
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Opens Chrome in maximized mode
        driver = new ChromeDriver(options) ;
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        if(driver !=null){
            driver.quit();
        }
    }
}

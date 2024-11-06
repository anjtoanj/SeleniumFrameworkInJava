package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePagev1 {
    private WebDriver driver;
    private String homePageUrl = "https://www.aucklandcouncil.govt.nz/Pages/default.aspx"; // replace with actual login URL

    // Constructor
    public HomePagev1(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to login page
    public void openhomePage() {
        driver.get(homePageUrl);
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePagev1;

public class HomePage_v1 {
    WebDriver driver ;
    HomePagev1 homePage1 ;

    @Given("User navigates to Home page of Auckland council")
    public void user_is_on_home_page() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage1 = new HomePagev1(driver);
        driver.manage().window().maximize();
        homePage1.openhomePage();
    }

    @When("User validates the homepage")
    public void user_validates_the_homepage() {
        Assert.assertEquals(driver.getTitle(),"Auckland Council");
    }

    @Then("exit the page")
    public  void exit_the_page(){
        // Close the browser after tests
        if (driver != null) {
            driver.quit();
        }
    }
}

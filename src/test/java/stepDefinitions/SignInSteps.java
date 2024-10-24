package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductCategoryPage;
import pages.SignInPage;
import hooks.TestHooks;
import pages.SignInPage;
import utility.DriverManager;

import java.util.Map;


public class SignInSteps {
    private WebDriver driver = TestHooks.driver;  // Direct reference to TestHooks.driver
    private SignInPage loginPage;
    private ProductCategoryPage homePage;

    @Given("^User navigates to the Login page$")
    public void user_navigates_to_Login_page() throws InterruptedException {
        driver = DriverManager.getDriver("ie");
        System.out.println("Driver in SignInSteps before navigation: " + driver);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        loginPage = new SignInPage(driver);

    }
    @When("^User clicked on hamburger icon$")
    public void user_clicked_hamburger_icon(){

    }

    @And("^User selected SignIn Portal$")
    public void user_selected_signIn_portal(){

    }

    @And("^User successfully enters the login details$")
    public void User_successfully_enters_login_details(DataTable dataTable) throws InterruptedException {

        // Convert DataTable to a Map
        Map<String, String> credentials = dataTable.asMap(String.class, String.class);

        // Retrieve the username and password from the DataTable
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Use the LoginPage object to enter username and password
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("^User clicked the login button$")
     public void user_clicked_login_button(){
        loginPage.clickLogin();
    }

    @Then("^User should be able to view the product category page$")
    public void User_navigates_to_product_category_page (){
        String formalShoes = homePage.validateLoginHomePage();
        Assert.assertTrue("Formal Shoes",formalShoes.contains("Formal Shoes"));
    }


}

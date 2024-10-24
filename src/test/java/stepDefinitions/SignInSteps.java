package stepDefinitions;

import hooks.hook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductCategoryPage;
import pages.SignInPage;
import utility.DriverManager;

import java.util.Map;


public class SignInSteps {

    // Get browser parameter from system properties or default to Chrome
    String browser = System.getProperty("browser", "IE");

    // Initialize WebDriver based on the specified browser
    private WebDriver driver = DriverManager.initializeDriver(browser);
    private SignInPage loginPage = new SignInPage(driver);
    private ProductCategoryPage homePage = new ProductCategoryPage(driver);


    @Given("^User navigates to the Login page$")
    public void user_navigates_to_Login_page() throws InterruptedException {
       DriverManager.getDriver(browser);
       System.out.println("Driver in SignInSteps before navigation: " + driver);
       driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

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

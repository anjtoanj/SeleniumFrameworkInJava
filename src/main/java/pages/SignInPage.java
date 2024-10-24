package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage extends BasePage {


    private By userName = By.id("usr");
    private By passWord = By.id("pwd");
    private By login = By.xpath("//*[@value=\"submit\"]");
    private By newUserRegistration = By.id("NewRegistration");
    private By hamburgerIcon = By.id("menuToggle");
  //  private By signInPortal = By.xpath("//*[@text=\"Sign In Portal\"]");;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    // Getters and Setters for usernameField
    public By getUsernameField() {
        return userName;
    }

    public void setUsernameField(By userName) {
        this.userName = userName;
    }

    // Getters and Setters for passwordField
    public By getPasswordField() {
        return passWord;
    }

    public void setPasswordField(By passWord) {
        this.passWord = passWord;
    }

    // Getters and Setters for loginButton
    public By getLoginButton() {
        return login;
    }

    public void setLoginButton(By login) {
        this.login = login;
    }

    public By getHamburgerIcon() {
        return hamburgerIcon;
    }

    public void setHamburgerIcon(By hamburgerIcon) {
        this.hamburgerIcon = hamburgerIcon;
    }

    // Getters and Setters for newUserRegistration
    public By getNewUserRegistration() {
        return newUserRegistration;
    }

    public void setNewUserRegistration(By newUserRegistration) {
        this.newUserRegistration = newUserRegistration;
    }

    // Page actions using the encapsulated locators


    public void clickHamburgerIcon() {
        driver.findElement(getHamburgerIcon()).click();
    }


    public void enterUsername(String username) {
        driver.findElement(getUsernameField()).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(getPasswordField()).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(getLoginButton()).click();
    }




}

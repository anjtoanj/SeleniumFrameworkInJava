package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryPage extends BasePage{

    private By homePageValidation = By.id("ShoeType");

    public ProductCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String validateLoginHomePage(){
        return driver.findElement(homePageValidation).getText();
    }
}

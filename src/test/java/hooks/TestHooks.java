package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;
import java.sql.SQLException;

public class TestHooks {

        public static WebDriver driver;

        @Before
        public void setUp() throws SQLException {
            driver = DriverManager.getDriver("ie");
            System.out.println("Driver initialized in TestHooks: " + driver);
        }

        @After
        public void tearDown(){
            if (driver != null) {
                DriverManager.quitDriver();
                System.out.println("Driver quit in TestHooks");  // Debug statement
            }
        }
 }



package baseTest;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static listen.Listeners.urlProperty;

public class BaseTest {

 public static WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initDriver("chrome");
        driver.get(urlProperty.getProperty("base-url"));
    }

    @AfterMethod
    public void close(){
        WebDriverFactory.quitDriver();

    }
}

package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginScreen;


public class TestHome {

WebDriver driver;

@Test
public void validateThatUserCanAddItem()  {
    //Fluent pattern + page object
    //Anoumous object
    new LoginScreen(driver)
            .login("standard_user", "secret_sauce")
            .addFirstItemToCard()
            .assertCount().logout();

}


    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void close(){
        WebDriverFactory.quitDriver();

    }
}

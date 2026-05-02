package tests;

import drivers.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginScreen;


public class TestLogin {

    //variables
    WebDriver driver;
    // method
    @Test(priority = 0)
    @Description("Validate that user can login Successfully with valid user name and password")
    @Tag("Happy SC")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    public void loginSuccessfully(){
        new LoginScreen(driver)
                .login("standard_user", "secret_sauce");
    }


    @Description("Validate that user errpr message will be displayed in cases user locked")
     @Test(priority = 1)
    @Tag("Negative SC")
    @Severity(SeverityLevel.MINOR)
    @Story("Login")
    public void loginWithLockedAccount(){
        new LoginScreen(driver)
                .login("locked_out_user", "secret_sauce");
        new LoginScreen(driver).errorMessageIsDisplayed();
    }
    // config

    @BeforeMethod
    public void setup(){
     driver= WebDriverFactory.initDriver("edge");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void close(){
        WebDriverFactory.quitDriver();
    }
}

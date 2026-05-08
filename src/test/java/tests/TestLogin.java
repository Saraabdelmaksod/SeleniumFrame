package tests;

import baseTest.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import listen.Listeners;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.LoginScreen;

import static utils.reader.ConfigHandler.urlProperty;
import static utils.reader.ConfigHandler.websiteProperty;


public class TestLogin extends BaseTest {

    // method
    @Epic("Login")
    @Feature("login with credeantionls")
    @Test(priority = 0,retryAnalyzer = Listeners.class)
    @Description("Validate that user can login Successfully with valid user name and password")
    @Tag("Happy SC")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    public void loginSuccessfully(){
        new LoginScreen(driver)
                .login(websiteProperty.getProperty("username"), websiteProperty.getProperty("password"));
        new HomeScreen(driver).assertUserIsLoggedInWithCorrectUrl(urlProperty.getProperty("home-url"));
    }


    @Epic("Login")
    @Feature("login with credeantionls")
    @Description("Validate that user errpr message will be displayed in cases user locked")
     @Test(priority = 1,retryAnalyzer = Listeners.class)
    @Tag("Negative SC")
    @Severity(SeverityLevel.MINOR)
    @Story("Login")
    public void loginWithLockedAccount(){
        new LoginScreen(driver)
                .login(websiteProperty.getProperty("invalid_username"), websiteProperty.getProperty("password"));
        new LoginScreen(driver).errorMessageIsDisplayed();
    }
    // config


}

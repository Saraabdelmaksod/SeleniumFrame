package tests;

import baseTest.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listen.Listeners;
import org.testng.annotations.Test;
import pages.LoginScreen;

import static utils.reader.ConfigHandler.websiteProperty;


public class TestHome  extends BaseTest {



    @Epic("Home")
    @Feature("home page")
@Test(retryAnalyzer = Listeners.class)
public void validateThatUserCanAddItem()  {
    //Fluent pattern + page object
    //Anoumous object
    new LoginScreen(driver)
            .login(websiteProperty.getProperty("username"), websiteProperty.getProperty("password"))
            .addFirstItemToCard()
            .assertCount().logout();
}

}

package tests;

import baseTest.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.LoginScreen;

import static utils.reader.ConfigHandler.websiteProperty;

public class TestCart extends BaseTest {
    String priceInHome;
    String priceInCart;

    @Epic("Cart")
    @Feature("Compare item price in home page and cart")
    @Test
    public void validateItemPriceInHomePageIsTheSamePriceInCart() {

        priceInHome=   new LoginScreen(driver)
                .login(websiteProperty.getProperty("username"),
                        websiteProperty.getProperty("password")).
                        getFirstItemPrice();

        priceInCart=   new HomeScreen(driver).addFirstItemToCard().getItemPrice();
        Assert.assertEquals(priceInHome,priceInCart,"Price in home page is not the same price in cart");

    }

}

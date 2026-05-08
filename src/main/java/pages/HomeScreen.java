package pages;

import bot.ActionBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomeScreen {

    private WebDriver driver;
    private ActionBot actionBot;

    private final By addToCartButton= By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private final By cartItemCount=By.className("shopping_cart_badge");
    private final By  meue=By.id("react-burger-menu-btn");
    private final By logoutButton=By.id("logout_sidebar_link");


    public HomeScreen(WebDriver driver){
        this.driver= driver;
        actionBot= new ActionBot(driver);
    }

    @Step("user validate current url")
    public HomeScreen assertUserIsLoggedInWithCorrectUrl(String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return this;
    }

    @Step("user add first item to cart")
    public HomeScreen addFirstItemToCard(){
        actionBot.click(addToCartButton);
        return this;
    }
    @Step("user validate cart count")
    public HomeScreen assertCount(){
        Assert.assertEquals(
               actionBot.getText(cartItemCount),"1");
        return this;
    }

    @Step("user log out")
    public LoginScreen logout(){
        actionBot.click(meue);
        actionBot.click(logoutButton);
        return new LoginScreen(driver);
    }

}

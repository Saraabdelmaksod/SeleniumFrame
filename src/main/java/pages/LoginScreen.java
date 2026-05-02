package pages;

import bot.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginScreen {

    // variable
    private WebDriver driver;
    private ActionBot actionBot;


    private final By userName=By.id("user-name");
    private final By password=By.id("password");
    private final By loginButton=By.id("login-button");
    private final By errorMessage=By.xpath("//div[@class='error-message-container error']");

    // constractor
    public LoginScreen(WebDriver driver){
        this.driver=driver;
        actionBot= new ActionBot(driver);
    }

    // actions (methods)
    public HomeScreen login(String user, String pass){
        actionBot.sendKey(userName,user );
        actionBot.sendKey(password,pass );
        actionBot.click(loginButton);
        return new HomeScreen(driver);
    }


    public LoginScreen errorMessageIsDisplayed(){
        Assert.assertTrue(
          driver.findElement(errorMessage).isDisplayed());
        return this;

    }

}

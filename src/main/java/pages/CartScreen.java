package pages;

import bot.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartScreen {

    private WebDriver driver;
    private ActionBot actionBot;
    private final By itemPrice=By.xpath("//div[@class='inventory_item_price']");

    public CartScreen(WebDriver driver){
        this.driver=driver;
        actionBot= new ActionBot(driver);
    }

    public String getItemPrice(){
        return actionBot.getText(itemPrice);
    }


}

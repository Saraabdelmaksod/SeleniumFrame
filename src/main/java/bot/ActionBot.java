package bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBot {

    private WebDriver driver;
    private WaitBot waitBot;
    public ActionBot(WebDriver driver){
       this.driver=driver;
        waitBot= new WaitBot(driver) ;
    }

    //click
    public void click(By locator){
        waitBot.fluentWait().until(
                d -> {
                  try {
                      WebElement element=d.findElement(locator);
                      new Actions(d).scrollToElement(element);
                      element.click();
                      return true;
                  }
                  catch (Exception e) {
                      return false;
                  }
                }
        );
    }

    public void sendKey(By locator, String text){
        waitBot.fluentWait().until(
                d -> {
                    try {
                        WebElement element=d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.sendKeys(text);
                        return true;
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
        );
    }
    public String getText(By locator){
       return waitBot.fluentWait().until(
                d -> {
                    try {
                        WebElement element=d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                       String mes= element.getText();
                        return !mes.isEmpty() ? mes : null;
                    }
                    catch (Exception e) {
                        return null;
                    }
                }
        );


}
}

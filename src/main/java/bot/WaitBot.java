package bot;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitBot {

    private WebDriver driver;

    public WaitBot(WebDriver driver){
        this.driver=driver;
    }

    public FluentWait<WebDriver> fluentWait(){
       return new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(10))
               .pollingEvery(Duration.ofMillis(100))
               .ignoring(ElementClickInterceptedException.class)
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class)
               ;
    }






}

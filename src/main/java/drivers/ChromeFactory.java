package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstractDriver{

    private ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        return options;
    }
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver(getOptions());
    }
}

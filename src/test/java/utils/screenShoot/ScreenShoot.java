package utils.screenShoot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static utils.allure.AllureUtils.addAttachmentInAllureReport;

public class ScreenShoot {

    public static void getScreenShoot(WebDriver driver, String screenName)  {

        File screenshotSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenDestination = new File("test-output/screenshot/" + screenName + ".png");
        try {
            FileUtils.copyFile(screenshotSource, screenDestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        addAttachmentInAllureReport(screenName,screenDestination.getPath()  );
        }

    }



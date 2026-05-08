package listen;
import org.testng.*;
import utils.reader.ConfigHandler;
import java.util.Properties;
import static baseTest.BaseTest.driver;
import static utils.allure.AllureUtils.*;
import static utils.screenShoot.ScreenShoot.getScreenShoot;


public class Listeners implements IInvokedMethodListener, ITestListener , IExecutionListener , IRetryAnalyzer{

    public static  Properties websiteProperty;
    public static Properties urlProperty;
    public static Properties environmentProperties;
    private int attemp;


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation");
        if( testResult.getStatus()==ITestResult.FAILURE){

                getScreenShoot(driver, testResult.getName());
            }
        }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        if (result.isSuccess()){
            System.out.println("this  is sucess");
        }
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("this fail " + result.getName() );
        Throwable error= result.getThrowable();
        System.out.println("the error" + error);

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        ConfigHandler.setAllConfig();
        websiteProperty=ConfigHandler.getWebsiteProperty();
        urlProperty=ConfigHandler.getUrlProperty();
        environmentProperties=ConfigHandler.getEnvProperty();
        cleanAllureResult();
        cleanAllureReport();
    }

    public void onExecutionFinish() {
        System.out.println("onExecutionFinish");
        setAllureEnvironment();
        createAllureReportInSingleFile();
    }

   public boolean retry(ITestResult result){

        if (result.getStatus()==ITestResult.FAILURE && attemp==0){
            attemp++;
            return true;
        }
        return false;
   }
}

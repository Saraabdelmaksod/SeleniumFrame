package listen;
import org.testng.*;


public class Listeners implements IInvokedMethodListener, ITestListener , IExecutionListener{


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation");

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
    }

    public void onExecutionFinish() {
        System.out.println("onExecutionFinish");

    }

}

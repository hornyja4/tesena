package listener;

import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success!!!!!!!!");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failure!!!!!!!!");
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}

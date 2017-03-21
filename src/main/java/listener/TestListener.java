package listener;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.*;

import java.io.File;
import java.io.IOException;

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

        //File images = new File("C:\\User\\JHornych\\Desktop\\tesena\\target\\images");
        //images.mkdir();


        DriverManager driverManager = DriverManager.getInstance();
        File screenshot = driverManager.getDriver().getScreenshotAs(OutputType.FILE);

        System.out.println(screenshot.getAbsolutePath());

        try {
            FileUtils.copyFile(screenshot, new File("..\\target\\images\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

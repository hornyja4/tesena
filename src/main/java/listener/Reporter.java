package listener;


import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Reporter implements IReporter{


    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        for (ISuite suite: suites){

            String suitName = suite.getName();
            Map suiteResults = suite.getResults();

            for (Object result: suiteResults.values()){

                ISuiteResult suiteResult = (ISuiteResult) result;
                ITestContext testContext = suiteResult.getTestContext();

                System.out.println("Passed tests for suite: " + suitName +
                        " are " + Arrays.toString(testContext.getPassedTests().getAllResults().toArray()));

            }
        }
    }
}

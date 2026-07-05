package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Execution Started : " + context.getName());
        System.out.println("========================================");
        System.out.println();

    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Execution Finished : " + context.getName());
        System.out.println("========================================");
        System.out.println();

    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println();
        System.out.println("STARTED : " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASSED  : " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED  : " + result.getMethod().getMethodName());

        if (result.getThrowable() != null) {

            result.getThrowable().printStackTrace();

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("SKIPPED : " + result.getMethod().getMethodName());

    }

}
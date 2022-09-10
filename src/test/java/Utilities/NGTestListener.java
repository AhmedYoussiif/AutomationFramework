package Utilities;


import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import  static Utilities.ExtendReport.features;

import java.io.IOException;


/**
 * Created by Karthik on 21/09/2019.
 */

public class NGTestListener implements ITestListener {
	ExtendReport extentReportUtil = new ExtendReport();


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");
        try{
            extentReportUtil.ExtentReportScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
      
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
        extentReportUtil.ExtentReport();

        //ToDo: Feature - Hard coding the feature name
        features = extentReportUtil.extent.createTest(Feature.class, "Login Feature");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extentReportUtil.FlushReport();

    }
}
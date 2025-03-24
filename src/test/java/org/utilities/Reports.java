package org.utilities;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.*;



public class Reports implements ITestListener{
 private static ExtentReports extentReport;
 private static ExtentTest extentTest;
 
 static {
	 ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
     extentReport = new ExtentReports();
     extentReport.attachReporter(htmlReporter);
 }
 @Override
 public void onTestStart(ITestResult result) {
     extentTest = extentReport.createTest(result.getMethod().getMethodName());
 }

 @Override
 public void onTestSuccess(ITestResult result) {
     extentTest.pass("Test Passed");
 }

 @Override
 public void onTestFailure(ITestResult result) {
     extentTest.fail("Test Failed: " + result.getThrowable());
 }

 @Override
 public void onFinish(ITestContext context) {
     extentReport.flush(); 
 }

 
}

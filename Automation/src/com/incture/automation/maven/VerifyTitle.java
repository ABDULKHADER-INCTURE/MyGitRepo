package com.incture.automation.maven;


//verifyTitlenewnew
import library.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitle 
{

ExtentReports report;
ExtentTest logger; 
WebDriver driver;


@SuppressWarnings("deprecation")
@Test public void verifyBlogTitle()
{

report=new ExtentReports("C:\\Report\\LearnAutomation.html");
//report.config().documentTitle("Sample Report");

report.config().reportName("INCTURE IQ AUTOMATION REPORT");
//report.config().reportHeadline("Test report for VerifyTitle generated using <b>ExtentReports</b>");



logger=report.startTest("VerifyBlogTitle");

driver=new FirefoxDriver();

driver.manage().window().maximize();
logger.assignAuthor("<b>AUTHOR : INCTURE IQ</b>");


logger.log(LogStatus.INFO, "Browser started ");

driver.get("http://www.google.co.in");

logger.log(LogStatus.INFO, "Application is up and running");

String title=driver.getTitle();
logger.log(LogStatus.INFO, "Got the tittle");

Assert.assertTrue(title.contains("test")); 

logger.log(LogStatus.PASS, "Title verification is Passed");
}


@AfterMethod
public void tearDown(ITestResult result)
{
if(result.getStatus()==ITestResult.FAILURE)
{
System.out.println(result.getMethod());
String screenshot_path=Utility.captureScreenshot(driver, "Title not Matched");
String image= logger.addScreenCapture(screenshot_path);
System.out.println(screenshot_path);
//logger.log(LogStatus.FAIL, "Title verification is Failed", image);
logger.log(LogStatus.INFO, "Image", "<b>Title verification is Failed</b>: " + image);
logger.log(LogStatus.ERROR, result.getThrowable());


}

report.endTest(logger);
report.flush();

//driver.get("C:\\Report\\LearnAutomation.html");
}
}



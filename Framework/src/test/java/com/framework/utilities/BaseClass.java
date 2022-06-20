package com.framework.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass{
	
public WebDriver driver;
public ExcelDataProvider ss;
public ConfigDataProvider cb;
public ExtentReports  report;
public ExtentTest logger;



@BeforeSuite
public void suitSetup() {
	ss=new ExcelDataProvider ();
	  cb=new ConfigDataProvider();
	//ExtentSparkReporter extent=new ExtentSparkReporter(new File("./Reports/" + Helper.getCurrentDateTime() + "_ss.html"));
	ExtentSparkReporter extent=new ExtentSparkReporter(new File("./Reports/ ExtentReports_ss.html"));
	  report=new ExtentReports();
	  report.attachReporter(extent);
}

@Parameters({"browser","urlTobeTested"})
@BeforeClass
public void setup(String browser,String url) {
	
	//driver=BrowserFactory.startApplication(driver,ss.getStringData("sheet1", 1, 0),ss.getStringData("sheet1", 1, 1));
  driver=BrowserFactory.startApplication(driver,browser,url);

}


@AfterClass
public void tearDown() {
	
	BrowserFactory.quitBrowser(driver);
}

@AfterMethod
public void tearDownMethod(ITestResult result) {
	
	
	if(result.getStatus()==ITestResult.SUCCESS) {
		
//Helper.captureScreenshot(driver);
logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
	
	
	report.flush();

}


}

package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestReport extends TestListenerAdapter {

	
     public  ExtentHtmlReporter Htmlreporter;
     public ExtentReports extent;
     public ExtentTest Xtest;
	 
	 
	 public void onStart(ITestContext testContext) {
		    
		 String RepName ="Test-Report"+System.currentTimeMillis()+".html";
		 Htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+RepName);
		 Htmlreporter.config().setDocumentTitle("Test Case Report");
		 Htmlreporter.config().setReportName("NetFlix Testing");
		 Htmlreporter.config().setTheme(Theme.DARK);
		 Htmlreporter.config().setAutoCreateRelativePathMedia(true);
		 
		 
		 extent = new ExtentReports();
		 extent.attachReporter(Htmlreporter);
		 extent.setSystemInfo("Apllication Name", "Netflix");
		 extent.setSystemInfo("Host Name", "Localhost");
		 extent.setSystemInfo("QA Name", "Prajwal");
		 extent.setSystemInfo("OS", "Windows 10");
		 
	 }

		 
	 public void onFinish(ITestContext testContext) {
		 
		 extent.flush();
		 
	 }
	 
	 
	  public void onTestSuccess(ITestResult tr) {
	    
		  Xtest = extent.createTest(tr.getName());
		  Xtest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		  Xtest.log(Status.PASS, "Test is Passed.");
	  }

	  
	  public void onTestFailure(ITestResult tr) {
		  Xtest = extent.createTest(tr.getName());
		  Xtest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		  Xtest.log(Status.FAIL, "Test is Failed.");
		  
		  String ScreenshotPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		  File Destination = new File(ScreenshotPath);
		  if(Destination.exists()) {
			  
			  try {
				  Xtest.fail("Screenshot for Failed Test : "+ Xtest.addScreenCaptureFromPath(ScreenshotPath));
			} catch (IOException e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
		  Xtest = extent.createTest(tr.getName());
		  Xtest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		  Xtest.log(Status.SKIP, "Test is Skipped.");
	  }
}

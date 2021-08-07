/**
 * 
 */
package com.customlisteners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.tests.BaseTest;
import com.utils.Reporting;

/**
 * @author mohan
 *
 */
public class ExtentListenener implements ITestListener {
	
	 WebDriver driver;
	 BaseTest bt = new BaseTest();
	
	 @Override
	 public void onTestFailure(ITestResult iTestResult) {	
		 
		//Get driver from BaseTest and assign to local webDriver variable.
		 driver  = bt.returnCurrentDriver();
	 
	    //Take base64Screenshot screenshot.
	     String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		 
		 Reporting.getCurrentTest().log(LogStatus.FAIL, Reporting.getCurrentTest().addBase64ScreenShot(base64Screenshot) + "Test case failed!");
		 
	 }

}

package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting {
	
	WebDriver driver;

	static ExtentReports eReport;
	static ExtentTest eTest;

	public Reporting(WebDriver driver) {
		this.driver = driver;
	}

	public ExtentReports getCurrentExtentReport() {
		
		if (eReport ==null)
			eReport = new ExtentReports(
				System.getProperty("user.dir") + "\\Reports\\ExecutionResults_" + System.currentTimeMillis() + ".html");
		return eReport;

	}

	public void initiateReporting(String testName, String browserType) {

		eTest = getCurrentExtentReport().startTest(testName);
		eTest.log(LogStatus.INFO, "Running this test on:- " + browserType.toUpperCase() + " browser");

	}

	public void wrapReport() {

		getCurrentExtentReport().endTest(eTest);
		getCurrentExtentReport().flush();

	}

	public void testCaseDescInReport(String string) {
		eTest.setDescription(string);
	}

	public void logInfoWithScreenshot(String message){
		
		try {
			eTest.log(LogStatus.INFO, eTest.addScreenCapture(attachPic(driver)) + message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passTestCaseWithScreenshot(String message) {
		
		try {
			eTest.log(LogStatus.PASS, eTest.addScreenCapture(attachPic(driver)) + message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public static void failTestCaseWithScreenshot(WebDriver wd, String message)  {
		
		try {
			eTest.log(LogStatus.FAIL, eTest.addScreenCapture(attachPic(wd)) + message);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static String attachPic(WebDriver wd) {
		
		try {
			File scrFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			File Dest = new File("src/../RunImages/" + System.currentTimeMillis() + ".png");
			String filePath = Dest.getAbsolutePath();
			FileUtils.copyFile(scrFile, Dest);
			return filePath;			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

		

	}

	public static ExtentTest getCurrentTest() {
		return eTest;
	}

}

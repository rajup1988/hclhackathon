/**
 * 
 */
package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.BasePage;
import com.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author mohan
 *
 */
public class BaseTest {
	
	WebDriver driver;
	Page page;
	public static final String URL = "https://healthcaresuccess.com";
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void init(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		} else {
			System.out.println("Please pass value of 'browser' between 'Chrome/Firefox' in the testng.xml...");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		page = new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

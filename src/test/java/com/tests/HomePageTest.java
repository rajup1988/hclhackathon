/**
 * 
 */
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;

/**
 * @author mohan
 *
 */
public class HomePageTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyMenu() {	
		
		HomePage homePage = page.getInstance(HomePage.class);
		
		ru.testCaseDescInReport("This test case verifies the Menu options");    	
    	
		ru.logInfoWithScreenshot("Getting the Number of Menu.."); 		
		int menuCount = homePage.getMainMenuCount();
		Assert.assertTrue(menuCount>0, "Menu count returned is not > 0!");
		System.out.println("Menu Count is:- "+menuCount);
		
		ru.logInfoWithScreenshot("Getting the Menu Name.."); 
		System.out.println(homePage.getMenuName());
		
		ru.passTestCaseWithScreenshot("'Menu Validation' Test Case Passed!");
		
	}
	
	@Test(dataProvider ="fill-details" , dataProviderClass = DataProvide.class, priority=2)
	public void verifyContactFillWithoutSubmit(String name, String lname, String org, String phNo, String email, String site, String message) {
		
		HomePage homePage = page.getInstance(HomePage.class);
		
		ru.testCaseDescInReport("This test case enters contact details without Submitting"); 
		
		ru.logInfoWithScreenshot("Filling the contact details.."); 
		homePage.enterAllDetails(name, lname, org, phNo, email, site, message);
		ru.logInfoWithScreenshot("Contact Details Filled.."); 
		
		ru.passTestCaseWithScreenshot("'Fill Contact Details Without Submit' Test Case Passed!");		
		
	}
	
	@Test(dataProvider ="fill-details-submit", dataProviderClass = DataProvide.class, priority=3)
	public void verifyContactFillWithSubmit(String name, String lname, String org, String phNo, String email, String site, String message) {
		
		HomePage homePage = page.getInstance(HomePage.class);
		
		ru.logInfoWithScreenshot("Filling the contact details.."); 
		homePage.enterAllDetails(name, lname, org, phNo, email, site, message);
		ru.logInfoWithScreenshot("Contact Details Filled.."); 
		
		homePage.clickSubmitButton();
		ru.logInfoWithScreenshot("Contact Details Submitted.."); 
		
	}
	
	

}

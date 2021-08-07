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
		
		int menuCount = homePage.getMainMenuCount();
		Assert.assertTrue(menuCount>0, "Menu count returned is not > 0!");
		//Screenshot here
		
		System.out.println(homePage.getMenuName());
		
	}
	
	@Test(dataProvider ="fill-details" , dataProviderClass = DataProvide.class, priority=2)
	public void verifyContactFillWithoutSubmit(String name, String lname, String org, String phNo, String email, String site, String message) {
		
		HomePage homePage = page.getInstance(HomePage.class);
		
		homePage.enterAllDetails(name, lname, org, phNo, email, site, message);
		//Screenshot here
		
	}
	
	@Test(dataProvider ="fill-details-submit", dataProviderClass = DataProvide.class, priority=3)
	public void verifyContactFillWithSubmit(String name, String lname, String org, String phNo, String email, String site, String message) {
		
		HomePage homePage = page.getInstance(HomePage.class);
		
		homePage.enterAllDetails(name, lname, org, phNo, email, site, message);
		//Screenshot here
		
		homePage.clickSubmitButton();
		
	}
	
	

}

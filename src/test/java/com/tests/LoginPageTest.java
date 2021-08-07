/**
 * 
 */
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

/**
 * @author mohan
 *
 */
public class LoginPageTest extends BaseTest {
	
	@Test
	public void verifyLoginWorks() {
		
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("", "");
		homePage.getHomePageHeader();
		Assert.assertEquals("actual", "expected", "String to print");
		
	}
	
	

}
 
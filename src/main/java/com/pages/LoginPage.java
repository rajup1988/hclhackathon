/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mohan
 *
 */
public class LoginPage extends BasePage {
	
	//By Locators
	private By userName = By.id("");
	private By pwd = By.id("");
	private By loginButton = By.id("");
	private By header = By.id("");		

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return getElement(userName);
	}

	/**
	 * @return the pwd
	 */
	public WebElement getPwd() {
		return getElement(pwd);
	}

	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public HomePage doLogin(String email, String password) {
		
		getUserName().sendKeys(email);
		getPwd().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
		
	}
	
	
	

}

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
public class HomePage extends BasePage {
	
	private By header = By.id("");


	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return getPageHeader(header);
	}
	
	

}

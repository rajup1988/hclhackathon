/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author mohan
 *
 */
public class Testimonials extends BasePage {
	
	private By testimonial_Name = By.xpath("//div[@id='content']//section[@class='post-entry']/div//hr/preceding::strong");
	private By testimonial_Details = By.xpath("//div[@id='content']//section[@class='post-entry']//p/em");	
	

	public Testimonials(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBrandingPageTitle() {
		return getPageTitle();
	}
	
	
	
	
}

/**
 * 
 */
package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mohan
 *
 */
public class Branding extends BasePage {
	
	private By h1_Heading = By.xpath("//article[@id='post-272']//div[@class='vc_column-inner']//div[contains(@class,'wpb_wrapper')]//h1");
	private By h2_Heading = By.xpath("//article[@id='post-272']//div[@class='vc_column-inner']//div[contains(@class,'wpb_wrapper')]//h1/following-sibling::h2");
	private By paragraph = By.xpath("//article[@id='post-272']//div[@class='vc_column-inner']//div[contains(@class,'wpb_wrapper')]//h1/following-sibling::p");

	public Branding(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBrandingPageTitle() {
		return getPageTitle();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getH1_Text() {
		return getElement(h1_Heading).getTagName();		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getH2_Text() {
		
		List<WebElement> ele=null;
		String text = null;
		
		ele = getElements(h2_Heading);
		for(WebElement el: ele) {			
			text = text + el.getText() + ";";
		}
		return text;		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getpara_Text() {
		
		List<WebElement> ele=null;
		String text = null;
		
		ele = getElements(paragraph);
		for(WebElement el: ele) {			
			text = text + el.getText() + ";";
		}
		return text;		
	}
	
	

}

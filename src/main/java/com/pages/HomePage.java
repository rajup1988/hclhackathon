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
public class HomePage extends BasePage {
	
	private By all_First_Level_Menu = By.xpath("//div[contains(@class,'navigation')] //li[contains(@class,'menu-item-level-0')]/a/span[contains(@class,'menu-target-text')]");
	private By mainMenu_Services = By.xpath("//div[contains(@class,'navigation')] //li[contains(@class,'menu-item-level-0')]/a/span[contains(text(),'Services')]");
	private By subMenu_Branding = By.xpath("//div[contains(@class,'navigation')] //li[contains(@class,'menu-item-level-1')]/a/span[contains(text(),'Branding')]");
	
	private By mainMenu_AboutUs = By.xpath("//div[contains(@class,'navigation')] //li[contains(@class,'menu-item-level-0')]/a/span[contains(text(),'About Us')]");
	private By subMenu_Testimonials = By.xpath("//div[contains(@class,'navigation')] //li[contains(@class,'menu-item-level-1')]/a/span[contains(text(),'Testimonials')]");
	
	private By footer_FirstName = By.xpath("//footer//input[@name='firstname']");
	private By footer_LastName = By.xpath("//footer//input[@name='lastname']");
	private By footer_Organization = By.xpath("//footer//input[@name='company']");
	private By footer_Phone = By.xpath("//footer//input[@name='phone']");
	private By footer_Email = By.xpath("//footer//input[@name='email']");
	private By footer_WebSite = By.xpath("//footer//input[@name='website']");
	private By footer_TextArea = By.xpath("//footer//textarea[@name='message']");
	private By footer_Submit_Button = By.xpath("//footer//input[@type='submit']");


	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getMenuName() {
		List<WebElement> menus = null;
		String menuNames = null;
		
		menus = getElements(all_First_Level_Menu);
		for (WebElement menu: menus) {
			if(!menu.getText().equals(null))
				menuNames = menuNames + menu.getText() + ";" ;			
		}
		return menuNames;
	}
	
	public int getMainMenuCount() {		
		return getElements(all_First_Level_Menu).size();
	}
	
	/**
	 * 
	 * @return
	 */
	public Branding navigateToBranding() {
		
		try {
			moveToElement(mainMenu_Services);
			getElement(subMenu_Branding).click();
			waitForPageTitle(Constants.BRANDING_PAGE_TITLE);
			return new Branding(driver);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/**
	 * 
	 * @return
	 */	
	public Testimonials navigateToTestimonials() {
		
		try {			
			moveToElement(mainMenu_AboutUs);
			getElement(subMenu_Testimonials).click();
			waitForPageTitle(Constants.TESTIMONIAL_PAGE_TITLE);
			return new Testimonials(driver);			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param name
	 */
	public void fillFirstName(String name) {
		getElement(footer_FirstName).sendKeys(name);
	}
	
	/**
	 * 
	 * @param lname
	 */
	public void fillLastName(String lname) {
		getElement(footer_LastName).sendKeys(lname);
	}
	
	/**
	 * 
	 * @param org
	 */
	public void fillOrganization(String org) {
		getElement(footer_Organization).sendKeys(org);
	}
	
	/**
	 * 
	 * @param phNo
	 */
	public void fillPhone(String phNo) {
		getElement(footer_Phone).sendKeys(phNo);
	}
	
	/**
	 * 
	 * @param email
	 */
	public void fillEmail(String email) {
		getElement(footer_Email).sendKeys(email);
	}
	
	/**
	 * 
	 * @param site
	 */
	public void fillWebsite(String site) {
		getElement(footer_WebSite).sendKeys(site);
	}
	
	/**
	 * 
	 * @param message
	 */
	public void fillMessage(String message) {
		getElement(footer_TextArea).sendKeys(message);
	}	
	
	/**
	 * 
	 */
	public void clickSubmitButton() {
		getElement(footer_Submit_Button).click();
	}
	
	/**
	 * 
	 * @param name
	 * @param lname
	 * @param org
	 * @param phNo
	 * @param email
	 * @param site
	 * @param message
	 */
	public void enterAllDetails(String name, String lname, String org, String phNo, String email, String site, String message) {
		
		try {
			fillFirstName(name);
			fillLastName(lname);
			fillOrganization(org);
			fillPhone(phNo);
			fillEmail(email);
			fillWebsite(site);
			fillMessage(message);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	

}

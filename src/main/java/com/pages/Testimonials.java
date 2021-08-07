/**
 * 
 */
package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mohan
 *
 */
public class Testimonials extends BasePage {
	
	private By testimonial_Details = By.xpath("//article/section/div//p");	
	

	public Testimonials(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getTestimonials()
	{
		List<WebElement> elements = driver.findElements(testimonial_Details);
		List<String> l = new ArrayList<String>();
		for(WebElement ele : elements)
		{
			List<WebElement> emElements = ele.findElements(By.tagName("em"));
			List<WebElement> strongElements = ele.findElements(By.tagName("Strong"));
			if(emElements.size() > 0)
			{
				for(WebElement emElement: emElements)
				{
					l.add(emElement.getText());
				}
			}
			
			if(strongElements.size() > 0)
			{
				for(WebElement strongElement: strongElements)
				{
					l.add(strongElement.getText());
				}
			}
		}
		return l;
	}
	
	
	
	
}

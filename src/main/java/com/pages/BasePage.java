package com.pages;

/**
 * @author mohan
 *
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{
	
	Actions action;

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
		
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();		
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElement(locator);
			element= driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Element cannot be found! :- " + locator.toString());
			e.printStackTrace();			
		}
		return element; 
	}

	@Override
	public void waitForElement(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch(Exception e) {
			System.out.println("Element cannot be found within 15 seconds! :- " + locator.toString());
			e.printStackTrace();
		}		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch(Exception e) {
			System.out.println("Title cannot be found within 15 seconds! :- " + title);
			e.printStackTrace();
		}			
	}

	@Override
	public List<WebElement> getElements(By locator) {
		
		List<WebElement> elements = null;
		
		try {
			waitForElement(locator);
			return elements = driver.findElements(locator);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void moveToElement(By locator) {
		WebElement ele = getElement(locator);		
		action.moveToElement(ele).build().perform();		
	}

	@Override
	public void scrollToElementView(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	

}

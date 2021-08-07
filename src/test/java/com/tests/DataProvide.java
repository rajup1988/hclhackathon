/**
 * 
 */
package com.tests;

import org.testng.annotations.DataProvider;

/**
 * @author mohan
 *
 */
public class DataProvide {
	
	@DataProvider(name="fill-details")
	public Object[][] fill_details(){
		
		//String name, String lname, String org, String phNo, String email, String site, String message
		
		return new Object[][] {
			{"Mohan"},{"Kirupa"},{"CTS"},{"83938292"},{"sidaoksda@gmail.com"},{"www.ssss.com"},{"Set 1 of data for without submission flow"},
			{"Mohan"},{"Kirupa"},{"CTS"},{"83938292"},{"sidaoksda@gmail.com"},{"www.ssss.com"},{"Set 2 of data for without submission flow"}
		};
		
	}
	
	@DataProvider(name="fill-details-submit")
	public Object[][] fill_details_submit(){
		
		
		return new Object[][] {
			{"Mohan"},{"Kirupa"},{"CTS"},{"83938292"},{"sidaoksda@gmail.com"},{"www.ssss.com"},{"Set 1 of data for submission flow"},
			{"Mohan"},{"Kirupa"},{"CTS"},{"83938292"},{"sidaoksda@gmail.com"},{"www.ssss.com"},{"Set 2 of data for submission flow"}
		};
		
	}

}

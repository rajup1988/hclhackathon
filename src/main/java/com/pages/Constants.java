/**
 * 
 */
package com.pages;

import java.util.Properties;

import com.utils.FileManager;

/**
 * @author mohan
 *
 */
public class Constants {
	
	
	public static final Properties runProp = FileManager.readPropertyFileName("src/main/resources/configfiles/run.properties");
	public static final String BRANDING_PAGE_TITLE = "Healthcare Branding Services to Differentiate You From the Competition";
	public static final String TESTIMONIAL_PAGE_TITLE = "Marketing Client Testimonials - Healthcare Success";
	
	
	public static final String TESTIMONIAL_FILE_PATH = runProp.getProperty("");
}

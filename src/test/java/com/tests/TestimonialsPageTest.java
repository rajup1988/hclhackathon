package com.tests;

import org.testng.annotations.Test;

import com.pages.Constants;
import com.pages.HomePage;
import com.pages.Testimonials;
import com.utils.FileManager;

public class TestimonialsPageTest extends BaseTest {

	@Test(priority=1)
	public void getTestimonialsTest() throws Exception {	
		
		HomePage homePage = page.getInstance(HomePage.class);
		Testimonials testimonials = homePage.navigateToTestimonials();
		FileManager.writeIntoTextFile(Constants.TESTIMONIAL_FILE_PATH, testimonials.getTestimonials());
	}
}

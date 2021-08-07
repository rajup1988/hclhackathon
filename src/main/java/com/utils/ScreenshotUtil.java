package com.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotUtil {
	
	public static void takeScreenshotAndCompare(String expectedFilePath, String pageName, WebDriver driver) throws Exception
	{
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			// Copy the element screenshot to disk
			File screenshotLocation = new File("src/main/resources/images/"+pageName+"_Actual.png");
			FileUtils.copyFile(screenshot, screenshotLocation);
			BufferedImage actualImage = ImageIO.read(screenshotLocation);
			ImageDiffer imgDiff = new ImageDiffer();
			BufferedImage expectedImage = ImageIO.read(new File(expectedFilePath));
			ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
			if(diff.hasDiff()==true)
			{
			 System.out.println("Images are Not Same");
			}
			else {
			 System.out.println("Images are Same");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger statement.
			throw new Exception(e); // preventing execution progress
		}
	}
	
	public static void captureParticularElementAndCompare(String expectedFilePath, String imageName, WebElement element) throws Exception
	{
		 try {
			File file = new File("src/main/resources/images/"+imageName+"_Actual.png");
			 FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), file);
			 BufferedImage actualImage = ImageIO.read(file);
			 ImageDiffer imgDiff = new ImageDiffer();
			 BufferedImage expectedImage = ImageIO.read(new File(expectedFilePath));
			 ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
			 if(diff.hasDiff()==true)
			 {
			    System.out.println("Images are Not Same");
			 }
			 else {
			    System.out.println("Images are Same");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger statement.
			throw new Exception(e); // preventing execution progress
		}
	}

}

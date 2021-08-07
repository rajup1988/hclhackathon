package com.utils;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

public class FileManager {
	
	public static void writeIntoTextFile(String fileName, List<String> listOfTestimonials) throws Exception
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			for(String s: listOfTestimonials)
			{
				writer.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger statement.
			throw new Exception(e); // preventing execution progress
		} finally
		{
			if(writer != null)
			{
				writer.close();
			}
		}
	}
	
	public static void readPropertyFileName(String fileName) throws Exception
	{
		Properties properties = null;
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			properties = new Properties();
			properties.load(reader);
		} catch(Exception e)
		{
			// logger statement.
			throw new Exception(e); // preventing execution progress
		} finally
		{
			{
				if(reader != null)
				{
					reader.close();
				}
			}
		}
	}

}
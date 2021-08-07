package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pages.Constants;

public class FileManager {

	public static void writeIntoTextFile(String fileName, List<String> listOfTestimonials) throws Exception {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			for (String s : listOfTestimonials) {
				writer.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger statement.
			throw new Exception(e); // preventing execution progress
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static Properties readPropertyFileName(String fileName) {
		Properties properties = null;
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			properties = new Properties();
			properties.load(reader);
		} catch (Exception e) {
			// logger statement.
		} finally {
			{
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return properties;
	}

	public static void writeIntoExcel(String content) {
		File checkFile = new File(Constants.BRANDINGPAGE_EXCEL_FILE_PATH);
    	if(!checkFile.exists()) {
    		try(FileOutputStream out = new FileOutputStream(
    				new File(Constants.BRANDINGPAGE_EXCEL_FILE_PATH));Workbook workbook = new XSSFWorkbook();) {
    			Sheet spreadsheet = workbook.createSheet("HclHackathon");
    			spreadsheet.createRow(0).createCell(0).setCellValue(content);
    			workbook.write(out);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else {
    		try (FileInputStream excelFile = new FileInputStream(new File(Constants.BRANDINGPAGE_EXCEL_FILE_PATH));Workbook workbook = new XSSFWorkbook(excelFile)){
    	        Sheet spreadsheet = workbook.getSheetAt(0);
    	        Iterator<Row> iterator = spreadsheet.iterator();
    	        int rowCount = 0;
    	        while (iterator.hasNext()) {

                    Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();
                    while (cellIterator.hasNext()) {
                    	Cell currentCell = cellIterator.next();
                        if (currentCell.getCellType() == CellType.STRING) {
                        	rowCount += 1;
                        }
                    	System.out.println(rowCount);
                    }
                }
    	        
    	        if(rowCount >= 0) {
    	        	spreadsheet.createRow(rowCount).createCell(0).setCellValue(content);
    	        }
                
    	        FileOutputStream out = new FileOutputStream(
    	                new File(Constants.BRANDINGPAGE_EXCEL_FILE_PATH));
    	        workbook.write(out);
    	        out.close();
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}

	}

}

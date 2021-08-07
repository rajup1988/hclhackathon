package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelUtility {

	private static final String FILE_NAME = "src//main//resources//Write.xlsx";
	
    @Test
    public static void Write(String content)
    {
    	/*File checkFile = new File(FILE_NAME);
    	if(checkFile.exists()) {
    		System.out.print("Exist");
    	} else {
    		FileOutputStream out = new FileOutputStream(
	                new File(FILE_NAME));
	        workbook.write(out);
	        out.close();
    	}*/
		try (FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));Workbook workbook = new XSSFWorkbook(excelFile)){
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
	                new File(FILE_NAME));
	        workbook.write(out);
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    public static void main(String[] args) {
    	Write("test string");
    }


}




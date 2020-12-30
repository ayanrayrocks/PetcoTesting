package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
   
	public static FileInputStream fism = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;
	 
	public static String getCellData(String sheetName, int colNum, int rowNum) throws IOException {
		fism = new FileInputStream("Pecto.xlsx");
		workbook = new XSSFWorkbook(fism);
		String value=null;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		if (row == null)
			return "";
		cell = row.getCell(colNum);
		if (cell == null)
			return "";

		switch (cell.getCellType())               
		{  
		case STRING:    //field that represents string cell type  
		   value= cell.getStringCellValue();  
		    break; 
		case NUMERIC:    //field that represents number cell type  
		   value = String.valueOf(cell.getNumericCellValue());  	
		   break; 
	  
		}
	       return value;	
		} 
}

package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	public static String TestDateName = "TestDate.xlsx";
	public static String ElementLocationExcelFileName = "ElementLocation.xlsx";

	public static String TestDataExcelFileName = "TestData.xlsx";

	 static final String currentDir = System.getProperty("user.dir");

	public static String ExcelPath_TedDate =currentDir + "\\src\\test\\java\\Utilities\\"+TestDateName;
	public static String ReadExcel(String ExcelName,int Sheet, int Row ,int cell) throws IOException 
	{  
		String Data= null;
		try  
		{  
			 String ExcelPath_ElementLocation =currentDir + "\\src\\test\\java\\Utilities\\"+ExcelName;

			File file = new File(ExcelPath_ElementLocation);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  


			Data = wb.getSheetAt(Sheet).getRow(Row).getCell(cell).toString();  

		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		return Data;

	}
	public void WriteInExcel(String SheetName,Map < String, Object[] > subjectdata) throws EncryptedDocumentException, IOException {
	      //Create blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook();
	      //Create a blank sheet
	      XSSFSheet spreadsheet = workbook.createSheet( SheetName);
	      //Create row object
	      XSSFRow row;
	      //This data needs to be written (Object[])
	      //Iterate over data and write to sheet
	      Set < String > keyid = subjectdata.keySet();
	      int rowid = 0;    
	      for (String key : keyid) {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = subjectdata.get(key);
	         int cellid = 0;
	         
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);	         }
	      }
	      //Write the workbook in file system	      
	      FileOutputStream out = new FileOutputStream(
	         new File(ExcelPath_TedDate));

	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");

		
	}

}

package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclRead {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static FileInputStream f1;
	private static String filepath = "D:\\Java\\workspace\\Buffalocart\\src\\test\\resources\\ExcelReadOperation.xlsx" ;
	
	public static String getDatafromExcel(int rownum, int col) throws Exception {
		 f1 = new FileInputStream(filepath);
		 workbook = new XSSFWorkbook(f1);
		 sheet = workbook.getSheetAt(0);
		 Row row = sheet.getRow(rownum);
		 Cell cell =row.getCell(col);		 	 
		 return cell.getStringCellValue();
		 //return Sheet.getRow(rowNum).getCell(col).getStringCellValue();
		 
	}
	public static String getNumericDatafromExcel(int rownum, int col) throws Exception {
		 f1 = new FileInputStream(filepath);
		 workbook = new XSSFWorkbook(f1);
		 sheet = workbook.getSheetAt(0);
		 Row row = sheet.getRow(rownum);
		 Cell cell =row.getCell(col); 	
		 int val = (int)cell.getNumericCellValue();
	     return String.valueOf(val);	 		 
	}
	public static String getTicketDatafromExcel(int rownum, int col,int sheetnum) throws Exception {
		 f1 = new FileInputStream(filepath);
		 workbook = new XSSFWorkbook(f1);
		 sheet = workbook.getSheetAt(sheetnum);
		 Row row = sheet.getRow(rownum);
		 Cell cell =row.getCell(col); 	
		 int val = (int)cell.getNumericCellValue();
	     return String.valueOf(val);	 		 
	}

}

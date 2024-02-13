package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook wb;
	 public static XSSFSheet sh;
	 public static FileInputStream f;
	 
	 public static String getString(int i, int j, String filePath,String sheet) throws IOException
	 {
		 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
		 wb = new XSSFWorkbook(f);
		 sh = wb.getSheet(sheet);
		 Row r= sh.getRow(i);
		 org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		 return c.getStringCellValue();
		 
	 }
	 
	 public static String getNumeric(int i, int j, String filePath,String sheet) throws IOException
	 {
		 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
		 wb = new XSSFWorkbook(f);
		 sh = wb.getSheet(sheet);
		 Row r= sh.getRow(i);
		 org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		 int value = (int) c.getNumericCellValue();
		 return String.valueOf(value);
		 
	 }
	 
	 public static ArrayList<String> getString(String filePath,String sheet) throws IOException {
		 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
		 wb = new XSSFWorkbook(f);
		 sh = wb.getSheet(sheet);
		 ArrayList<String>excelrows=new ArrayList<String>();
		 int rowcount=sh.getLastRowNum()-sh.getFirstRowNum();
		 for(int i=0;i<=rowcount;i++) {
			 Row row=sh.getRow(i);
			 int cellcount=row.getLastCellNum();
			 for(int j=0;j<=cellcount;j++) {
				 excelrows.add(row.getCell(j).getStringCellValue());
			 }
		 }
		 return excelrows;
	 }
}



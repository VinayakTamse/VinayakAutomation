package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestBase.TestBase;

public class ReadExcelUtils{
	
	public static FileInputStream file;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static Row row;
	public static Cell cell;
	
	public static int getRowNo(String xlfile, String Sheet) throws Exception	{
		file = new FileInputStream(xlfile);
		book = new XSSFWorkbook(file);
		sheet = book.getSheet(Sheet);
		int rowNo = sheet.getLastRowNum();
		file.close();
		return rowNo;
		
	}
	
	public static int getCellNo(String xlfile, String Sheet, int rowNo) throws Exception	{
		file = new FileInputStream(xlfile);
		book = new XSSFWorkbook(file);
		sheet = book.getSheet(Sheet);
		row = sheet.getRow(rowNo);
		int cellNo = row.getLastCellNum();
		file.close();
		return cellNo;
	}
	
	public static String getCellData(String xlfile, String Sheet, int rowNo, int cellNo) throws Exception {
		file = new FileInputStream(xlfile);
		book = new XSSFWorkbook(file);
		sheet = book.getSheet(Sheet);
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		String data;
		try	{
			DataFormatter format = new DataFormatter();
			String cellData = format.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e)	{
			data="";
		}
		
		file.close();
		return data;
	}

}

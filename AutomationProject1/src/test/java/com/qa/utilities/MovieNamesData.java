package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MovieNamesData {

	
	public static FileInputStream FileLoc;
	public static XSSFWorkbook wbook;
	public static XSSFSheet wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//get row count
	public static int getRowCount(String Xfile, String XSheet) throws IOException {
		FileLoc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(FileLoc);
		wsheet = wbook.getSheet(XSheet);
		
		int rowcount = wsheet.getLastRowNum();
		return rowcount;
	}
	
	//get Cell count
	public static int getCellCount(String Xfile, String XSheet, int rowcount) throws IOException {
		FileLoc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(FileLoc);
		wsheet = wbook.getSheet(XSheet);
		row = wsheet.getRow(rowcount);
		
		int cellcount = row.getLastCellNum();
	
		return cellcount;
	}
	
	//get Cell Data
	public static String getCellData(String Xfile, String XSheet, int rowcount , int cellcount) throws IOException {
		FileLoc = new FileInputStream(Xfile);
		wbook = new XSSFWorkbook(FileLoc);
		wsheet = wbook.getSheet(XSheet);
		row = wsheet.getRow(rowcount);
		cell = row.getCell(cellcount);
		
		DataFormatter formatter = new DataFormatter();
		String celldata = formatter.formatCellValue(cell);
		return celldata;
		
	}
}

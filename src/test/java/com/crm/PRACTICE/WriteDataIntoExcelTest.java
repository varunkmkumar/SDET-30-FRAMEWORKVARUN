package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelTest {
	
	
@Test
public void writeDataIntoExcelTest() throws Throwable {
	//step1:open file in read mode
	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Frame.xlsx");
	
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.createRow(4);
	
	//craete cell to write new data
	Cell ce = ro.createCell(0);
	
	//set a cell value
	ce.setCellValue("varu");
	
	//open the file write mode
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Frame.xlsx");
	wb.write(fos);
	
	
	
	
}
}

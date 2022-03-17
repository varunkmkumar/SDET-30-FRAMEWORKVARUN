package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelTest {
	@Test
	public void readDataFromExcelTest() throws Throwable {
		//Step1: load excel file
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Frame.xlsx");
		
		//Step2: create work book
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3:get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//step4: get the row
		Row ro = sh.getRow(2);
		
		
		//step5:get the cell
		Cell ce = ro.getCell(1);
		
		//step6:read the data from cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		
	}

}

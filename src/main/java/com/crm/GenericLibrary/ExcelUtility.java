package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author LENOVO
 *
 */
public class ExcelUtility {
	/**
	 * this methoid will read data from excel sheet and return the value when sheet name 
	 * row no nad cell no is spoecifeid
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String SheetName,int rowNo, int cellNo) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook eb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = eb.getSheet(SheetName);
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.getCell(cellNo);
		String valu = ce.getStringCellValue();
		return valu;
		
	}

	/**
	 * this method will write data into excle
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
	 public void writeDataintiExcelSheet(String SheetName,int rowNo, int cellNo, String value ) throws Throwable {
		 FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
			Workbook eb=WorkbookFactory.create(fis);
			org.apache.poi.ss.usermodel.Sheet sh = eb.getSheet(SheetName);
			Row ro = sh.getRow(rowNo);
		Cell cel = ro.createCell(cellNo);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
	eb.write(fos);
		
	 
		 
	 }
	 
	 /**
	  * thhis method will return last row number
	  * @param SheetName
	  * @return
	  * @throws EncryptedDocumentException
	  * @throws IOException
	  */
	 public int getrowCount(String SheetName) throws EncryptedDocumentException, IOException {
		 FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
			Workbook eb=WorkbookFactory.create(fis);
			org.apache.poi.ss.usermodel.Sheet sh = eb.getSheet(SheetName);
			int row = sh.getLastRowNum();
			return row;
			
			
	 }
	  
	 
	 /**
	  * this method will read data multipe data from excel with the help of sheetname 
	  * and return 2 dimensional Object[][]
	  * @param sheetname
	  * @return
	  * @throws Throwable
	  */
	 
	 public Object[][] readMultipleDataFromExcel(String sheetname) throws Throwable
	 {
		 
		 FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		 Workbook wb=WorkbookFactory.create(fis);
		 org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetname);
		 int lastRow = sh.getLastRowNum();
		 int lastCell = sh.getRow(0).getLastCellNum();
		 
		 
		 Object[][] data=new Object[lastRow][lastCell];
		 
		

		for(int i=0;i<lastRow; i++)
		 {
			 for(int j=0; j<lastCell; j++)
			 {
			 data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			 }
			
		 }
		 return data;
		 
		  }

}

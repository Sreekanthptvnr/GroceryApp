package com.generalUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	 FileInputStream f;
	 XSSFWorkbook w;
	 XSSFSheet s;
	
	public String ReadStringData(int i,int j) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestSheet.xlsx");		
		w=new XSSFWorkbook(f);
		s=w.getSheet("Sheet1");
		Row r=s.getRow(i);
		Cell c=r.getCell(j);
		return c.getStringCellValue();
	}
	
//	public  String ReadIntegerData(int i,int j) throws IOException {
//		
//		f=new FileInputStream(("user.dir")+"\\src\\main\\resources\\Testsheet.xlsx");		
//		w=new XSSFWorkbook(f);
//		s=w.getSheet("Sheet1");
//		Row r=s.getRow(i);
//		Cell c=r.getCell(j);
//		int a=(int) c.getNumericCellValue();
//		return String.valueOf(a);
//		
//		
//	}
}

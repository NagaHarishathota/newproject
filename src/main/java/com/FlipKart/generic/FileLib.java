 package com.FlipKart.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib 
{
	public String readPropData(String propPath,String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(Key, "Incorrect key");
		return propValue;
	}
	
	public String getData(String Path,String Sheet, int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(fis);
		String val = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		return val;
	}
	
	public void readData(String Path,String Sheet,int row,int cell,String text) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(row).getCell(cell).setCellValue(text);
		FileOutputStream fos=new FileOutputStream(Path);
		wb.write(fos);
	}
	
	public int getRowCount(String Path,String Sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(fis);
		int rc=wb.getSheet(Sheet).getLastRowNum();
		return rc;
	}
	
	public int getCellCount(String Path,String Sheet,int row) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(fis);
		int cc=wb.getSheet(Sheet).getRow(row).getLastCellNum();
		return cc;
	}
}

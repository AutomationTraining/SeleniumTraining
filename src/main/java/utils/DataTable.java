package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataTable {

	public String path;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	XSSFRow row;
	XSSFCell cell;
	
	public DataTable(String path, String sheet)
	{
		this.path = path;
		try
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			worksheet = workbook.getSheet(sheet);
		}catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public String getData(int rowNum, String colName)
	{
		int colNum =0;
		row = worksheet.getRow(0);
		try
		{
			for(int i=0;i<=row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colName))
				{
					colNum = i;
					break;
				}
			}
			
			row = worksheet.getRow(rowNum-1);
			return row.getCell(colNum).getStringCellValue();
		}catch(Exception e)
		{
			e.getMessage();
			return null;
		}
	}
}

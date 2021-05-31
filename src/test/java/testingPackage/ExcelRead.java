package testingPackage;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelRead {
	
	ArrayList <String> value;
	
	@Test
	public void readData() throws IOException
	{
		
		value = new ArrayList<>();
		File file = new File(System.getProperty("user.dir")+"\\TestData.xlsx");
		
		FileInputStream ft = new FileInputStream(file);
		
		XSSFWorkbook xs = new XSSFWorkbook(ft);
		
		XSSFSheet sheet = xs.getSheetAt(0);
		
		Iterator <Row> it = sheet.rowIterator();
		
		while(it.hasNext())
			{
			String Item = it.next().getCell(1).toString();
			
			if (!(Item.equals("Item")))
			value.add(Item);
			
		}
		
		System.out.println(value);
	}

}

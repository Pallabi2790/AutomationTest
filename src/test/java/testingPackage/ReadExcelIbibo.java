package testingPackage;

import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import java.io.*;

public class ReadExcelIbibo {
	
	ArrayList <String> Cities;
	//ArrayList <String> Destination;
	
	
	
	//@Test
	public ArrayList <String> readData() throws IOException
	{
		Cities = new ArrayList<String>();
		File file = new File (System.getProperty("user.dir") + "\\FlightData.xlsx");
		
		FileInputStream ft = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook (ft);
		
		XSSFSheet xs = wb.getSheet("Sheet1");
		
		Iterator <Row> it = xs.iterator();
		int index = 0;
		
		while(it.hasNext())		
		{
		
			
			String value = it.next().getCell(index).toString()+" ";
		if((!(value.trim().equals(null)))&&(!(value.trim().equals("Cities"))))
		{
		    
			Cities.add(value.trim());
		}
		
		}
		
		return Cities;
		
	}

}

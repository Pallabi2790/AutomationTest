package testingPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	
	static ArrayList<Object> Item;
	static ArrayList<Object> ItemQty;
	static ArrayList<ArrayList<Object>> AllItems;
	
	static Map map;  
	
	
	
	/**
	 * @param args
	 * @throws IOException
	 */
	
	@Test
	public static void main(String args[]) throws IOException
	{
		File file = new File("C:\\Users\\aroy1\\eclipse-workspace\\seleniumTesting\\TestData.xlsx");			
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook xs = new XSSFWorkbook(inputStream);		
		XSSFSheet xw = xs.getSheet("testsheet");
		
		//map.clear();
		 map = new HashMap<Integer, ArrayList<String>>();
		Item = new ArrayList<Object>();
		ItemQty = new ArrayList<Object>();
		
		
				
		
		int rowindex = 1;
		
		int numberOfRows = (xw.getLastRowNum()-xw.getFirstRowNum()) +1;
		
		
		
		
		while(numberOfRows>1)
		{
		
			
			int colposition = 0;
			int numberOfCols = (xw.getRow(0).getLastCellNum()-xw.getRow(0).getFirstCellNum()) ;
			
			
			while(numberOfCols>0)
		{
					
			
			if(!((xw.getRow(rowindex).getCell(colposition).toString().equals("NA"))))
			{
				
				String ColumnHeader = (xw.getRow(0).getCell(colposition).toString());
				String value = (xw.getRow(rowindex).getCell(colposition)+" ").toString();
			
				if(ColumnHeader.equals("Item"))
			{
				Item.add(value);
				
			}
			else if(ColumnHeader.equals("Qty"))
			{
				Item.add(value);
			}
			}
			
			colposition = colposition +1;
			numberOfCols = numberOfCols -1;			
		}
			rowindex = rowindex + 1;
			numberOfRows = numberOfRows -1;
			
		map.put(rowindex, Item);
			
		System.out.println(map);	
		}
		

		System.out.println(map);
		
		//return AllItems;
	}

}


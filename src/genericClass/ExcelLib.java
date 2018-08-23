package genericClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	static final String filePath = "./testdata/TestData.xlsx";
	
	public static String readData(String sheet, int row, int cell)
	{
		String value = null;
		
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));			
			String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			value = new String(data);
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return value;
		
	}

}

package genericClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLib 
{
	static String filePath = "./configuration/config.properties";
	
	public static String getValue(String key)  
	{
		String value = null;
		
		try 
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(filePath)));
			value = prop.getProperty(key);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}

}

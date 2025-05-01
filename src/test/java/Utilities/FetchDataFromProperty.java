package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantData.constantData;



public class FetchDataFromProperty {
	public static Properties properties;
	
	public static Properties readDataFromProperty() throws IOException
	{
		FileReader reader=new FileReader(constantData.PropertyFilePath);
		Properties properties=new Properties();
		properties.load(reader);
		return properties;
		
		
	}
	
	public static String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public static String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}

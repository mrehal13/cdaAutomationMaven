package com.att.cd.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyReader{

	Properties prop;
	
	public PropertyReader() 
	{
		prop = new Properties();
		FileInputStream fi = null;
		
		try
		{
			fi = new FileInputStream("/Users/mandeeprehal/eclipse-workspace/cdaAutomation/src/main/resources/Configuation.properties");
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
	
		try
		{
			prop.load(fi);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getBrwser()
	{
		System.out.println("insie getBrwser metho of property " + prop.getProperty("browser"));
		return prop.getProperty("browser");
	}
	
}

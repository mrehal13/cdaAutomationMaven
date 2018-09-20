package com.att.cd.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver driver = null;
	
	public static WebDriver initalize(String ww)
	{	 
		System.setProperty("webdriver.gecko.driver", "//Users//mandeeprehal//eclipse-workspace//CDexpire//jars//geckodriver");
		//PropertyReader PropR = new PropertyReader();
		//String brw = PropR.getBrwser();		 
		//System.out.println("in browserfact: " + PropR.getBrwser());
		
		if(ww == "firefox")
		{
			driver = new FirefoxDriver();
		}
		return driver;
	 }
}

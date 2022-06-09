package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	
	public ConfigDataProvider() {
		
		File src=new File("./ConfigurationFiles/Config.properties");
		
		
	try{
		
	FileInputStream Exc=new FileInputStream(src);
 pro=new Properties();
pro.load(Exc);
	
	}

	catch(Exception e) {
		
		System.out.println("File not found" + e.getMessage());
		}
}
	
public String 
getDataFromConfig(String property)	{

	return pro.getProperty(property);
	
}

public String getBrowser()	{

	return pro.getProperty("Browser");
	
}	
public String getUrl()	{

	return pro.getProperty("url");
	
}	


}

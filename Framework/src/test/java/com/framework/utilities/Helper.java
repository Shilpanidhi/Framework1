package com.framework.utilities;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path="./Screenshots/" + getCurrentDateTime()+ "_ss.png";
		
	 try {
		//FileHandler.copy(src,new File("./Screenshots/" + getCurrentDateTime()+ "_ss.png"));
		 FileHandler.copy(src,new File(path));
		 System.out.println("Able to capture screenshot" );
		}
		
	catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Unable to capture screenshot" + e.getMessage());
	}
	 
	 
	 return path;
	 
	}
	public static String getCurrentDateTime() {
		DateFormat curFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		return curFormat.format(currentDate);
		
	}
	
	
	
	
	
}
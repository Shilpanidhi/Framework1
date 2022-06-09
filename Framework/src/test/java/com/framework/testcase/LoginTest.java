package com.framework.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.pages.LoginPages;
import com.framework.utilities.BaseClass;
import com.framework.utilities.Helper;

public class LoginTest extends BaseClass {
	


	@Test
	public void LoginApp()  {
		
	logger=report.createTest("Login to facebook");
	
	LoginPages FE=PageFactory.initElements(driver,LoginPages.class);
	logger.info("Startting Application");
	
	FE.loginToFacebook(ss.getStringData("sheet1", 0, 0),cb.getDataFromConfig("pwd") );
	//FE.loginToFacebook("svsuprithshimoga@gmail.com","umavijay");
	logger.pass("Login passed");
	}

}

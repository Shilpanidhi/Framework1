package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {
	WebDriver driver;
	
	public void Loginpages(WebDriver driver1) {
		this.driver=driver1;
		
	}

	
	@FindBy(name="email") WebElement Email;
	@FindBy(name="pass") WebElement password;
	@FindBy(name="login") WebElement Login;

	
public void loginToFacebook(String id,String pwd) 
{
	Email.sendKeys(id);
	password.sendKeys(pwd);
	Login.click();
	
	
}
}

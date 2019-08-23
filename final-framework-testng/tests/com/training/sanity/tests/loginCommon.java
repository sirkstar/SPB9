package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;

import com.training.pom.LoginPOM;

public class loginCommon {
	private WebDriver driver;
	private LoginPOM loginPOM = new LoginPOM(driver); 

	
	public void loginmtd() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
	}

}

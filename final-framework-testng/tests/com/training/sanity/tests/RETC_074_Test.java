package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.BlogPage;
import com.training.pom.ContactPage;
import com.training.pom.DashboardPage;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.ProfilePOM;
import com.training.pom.PropertiesPage;
import com.training.pom.UsersPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_074_Test{

	private static WebDriver driver;
	private LoginPOM loginPOM;
	private DashboardPage dash;
	private UsersPage user;
//	private MainPage mainpage;
//	private ContactPage contactpage;
	private static Properties properties;
	private String baseUrl;
	private Logger logger;
//	private ScreenShot screenshot;

	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		properties = new Properties();
		FileInputStream instream = new FileInputStream("./resources/others.properties");
		properties.load(instream);
		PropertyConfigurator.configure("./resources/log4j.properties");
		driver=DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		dash = new DashboardPage(driver);
		user = new UsersPage(driver);
//		login = new loginCommon();
//		mainpage = new MainPage(driver);
//		contactpage = new ContactPage(driver);
		baseUrl=properties.getProperty("baseURL");
//		screenshot = new ScreenShot(driver);
//		driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		logger=Logger.getLogger("RETC_074");
		logger.info("Before Method initialized...");
		logger.info("Base URL opened");		
	}
	
	@Test(dataProvider = "excel-inputs_RETC_074", dataProviderClass=LoginDataProviders.class)
	public void contactForm(String username, String rolechange) throws InterruptedException {
		logger.info("RETC_074 starting");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
		dash.clickusersmain();
		dash.clickallusers();
//		Thread.sleep(2000);
		user.userSearch(username);
		logger.info("clicking the user's checkbox");
		user.clickUserCheckbox(username);
//		Thread.sleep(3000);
		logger.info("Selecting the role to be changed");
		user.selectroletobechanged(rolechange);
		logger.info("Clicking the change role button");
		user.clickchangebutton();
		logger.info("Assert the role change message");
		user.assertresultmessages();
		user.userSearch(username);
		logger.info("Assert to ensure the new role change got in effect");
		user.assertrolechanged(username, rolechange);
		driver.close();
	}
}

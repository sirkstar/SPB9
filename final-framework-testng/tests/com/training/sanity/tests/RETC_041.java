package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BlogPage;
import com.training.pom.DashboardPage;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.ProfilePOM;
import com.training.pom.PropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_041 {

	private static WebDriver driver;
	private MainPage mainpage;
	private BlogPage blog;
	private LoginPOM login;
	private DashboardPage dash;
	private static Properties properties;
	private String baseUrl;
	private Logger logger;
	private ScreenShot screenshot;

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
		mainpage = new MainPage(driver);
		blog=new BlogPage(driver);
		login=new LoginPOM(driver);
		dash=new DashboardPage(driver);
		baseUrl=properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
		driver.get(baseUrl);
		logger=Logger.getLogger("RETC_041");
		logger.info("Before Method initialized...");
		logger.info("Base URL opened");		
	}
	
	@Test(priority=0)
	public void blogcomment() {
		logger.info("add comment in Blog for New Launch staring...");
		mainpage.clickBlog();
		blog.clickReadMore();
		blog.addComments("good");
		blog.commenterAuthor("krishna");
		blog.commenterEmail("krishnakumar@gmail.com");
		blog.clickPostBtn();
		driver.close();
	}
	
	@Test(priority=1)
	public void adminlogin() throws InterruptedException {
		
		logger.info("admin login starting...");
		login.userLogin("admin", "adminuser@12345");
		dash.clickCommentsMenu();
		dash.assertcomment();
		Thread.sleep(2000);
	}
}

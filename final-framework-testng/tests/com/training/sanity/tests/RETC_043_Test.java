package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
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
import com.training.pom.PropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_043_Test {

	private static WebDriver driver;
	private static Properties properties;
//	private MainPage mainpage;
//	private BlogPage blog;
	private LoginPOM login;
	private DashboardPage dash;
	private PostsPage posts;
	private Logger logger;
	private String baseUrl;
//	private ScreenShot screenshot;

//	public static WebDriver getDriver() {
//		return driver;
//	}
	
	@Test//(priority=1)
	public void validatecomments() throws InterruptedException {
		logger.info("admin login starting...");
		login.userLogin("admin", "adminuser@12345");
		logger.info("RETC_042 Starting... Adding new Post");
		posts.hoverPost();
		Thread.sleep(1000);
		dash.clickAddNewPost();
		posts.sendtitleofnewpost("New Launches");
		Thread.sleep(1000);
		posts.sendbodyofnewpost("New Launch in Home");
		Thread.sleep(2000);
		posts.clickAddNewPost();
		Thread.sleep(5000);
		posts.clicknewlaunchlink();
		Thread.sleep(2000);
		dash.clickDashboard();
		posts.assertnewpost();
		driver.close();
		logger.info("RETC_042 run completes");
	}
	
	@BeforeTest
	public void setup() throws Exception {
		properties = new Properties();
		FileInputStream instream = new FileInputStream("./resources/others.properties");
		properties.load(instream);
		
		PropertyConfigurator.configure("./resources/log4j.properties");
		driver=DriverFactory.getDriver(DriverNames.CHROME);
//		mainpage = new MainPage(RETC_041.getDriver());
//		blog=new BlogPage(RETC_041.getDriver());
		baseUrl=properties.getProperty("baseURL");
		driver.get(baseUrl);
		logger=Logger.getLogger("RETC_042");
		login=new LoginPOM(driver);
		dash=new DashboardPage(driver);
		posts=new PostsPage(driver);
//		screenshot = new ScreenShot(RETC_041.getDriver());
		logger.info("Before Method initialized...");		
	}
}

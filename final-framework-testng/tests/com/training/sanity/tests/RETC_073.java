package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.Helper;

public class RETC_073 {

	private static WebDriver driver;
	private MainPage mainpage;
	private ContactPage contactpage;
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
		contactpage = new ContactPage(driver);
		baseUrl=properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
//		driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		logger=Logger.getLogger("RETC_071");
		logger.info("Before Method initialized...");
		logger.info("Base URL opened");		
	}
	
	@Test(dataProvider = "db-inputs_073", dataProviderClass=LoginDataProviders.class)
	public void contactForm(String userName, String userEmail, String subjectLine, String userMessage) throws InterruptedException {
		logger.info("add comment in Blog for New Launch staring...");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
		mainpage.clickContactUs();
		contactpage.sendUserName(userName);
		Thread.sleep(1000);
		contactpage.sendEmail(userEmail);
		Thread.sleep(2000);
		contactpage.sendSubjectLine(subjectLine);
		Thread.sleep(3000);
		contactpage.sendActualMessage(userMessage);
		Thread.sleep(5000);
		contactpage.clickSubmitbtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Closed the Browser after RETC_073");
	}
}

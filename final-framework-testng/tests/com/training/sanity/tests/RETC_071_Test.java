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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.Helper;

public class RETC_071_Test {

	private static WebDriver driver;
	private MainPage mainpage;
	private ContactPage contactpage;
	private Helper helper;
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
		helper = new Helper();
		baseUrl=properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver);
//		driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		logger=Logger.getLogger("RETC_071");
		logger.info("Before Method initialized...");
		logger.info("Base URL opened");		
	}
	
	@Test(dataProvider = "excel-inputs-test", dataProviderClass=LoginDataProviders.class)
	public void contactForm(String userName, String userEmail, String subjectLine, String userMessage) throws InterruptedException {
		logger.info("add comment in Blog for New Launch staring...");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
		mainpage.clickContactUs();
		
		helper.highlightElement(driver, contactpage.name);
//		js.executeScript("arguments[0].setAttribute('style', 'background: Orange;');", contactpage.name);
		Thread.sleep(2000);
		contactpage.sendUserName(userName);
		
		helper.highlightElement(driver, contactpage.email);
//		js.executeScript("arguments[0].setAttribute('style', 'background: Orange;');", contactpage.email);
		Thread.sleep(2000);
		contactpage.sendEmail(userEmail);
		
		helper.highlightElement(driver, contactpage.subjectline);
//		js.executeScript("arguments[0].setAttribute('style', 'background: white;');", contactpage.subjectline);
		Thread.sleep(2000);
		contactpage.sendSubjectLine(subjectLine);
		
		helper.highlightElement(driver, contactpage.messagecontent);
//		js.executeScript("arguments[0].setAttribute('style', 'background: Green;');", contactpage.messagecontent);
		Thread.sleep(2000);
		contactpage.sendActualMessage(userMessage);
		
		contactpage.clickSubmitbtn();
	
		driver.close();
	}
}

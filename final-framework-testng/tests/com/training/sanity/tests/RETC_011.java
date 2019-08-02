package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AdminMenuPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_011 {

	private static WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Logger logger;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		//Log4j code
		logger = Logger.getLogger("RETC_011");
		PropertyConfigurator.configure("./resources/log4j.properties");
		// Initializing Driver
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		logger.info("URL opened");
	}

	@Test
	public void loginTest() throws InterruptedException {
		// Login with valid user credentials
		logger.info("Passing login credentials");
		loginPOM.userLogin("admin", "adminuser@12345");
		// Capture Screenshot
		screenShot.captureScreenShot("RETC_011_Home Page");
		// Assertion of the Logged in Page
		String expected = "Dashboard ‹ Real Estate — WordPress";
		String actual = loginPOM.validateHomePageTitle();
		assertEquals(actual, expected);
		logger.info("Assertion completed");
	}
}

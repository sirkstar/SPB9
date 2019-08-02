package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProfilePOM;
import com.training.pom.AdminMenuPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_015 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminMenuPOM AdminMenu;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		AdminMenu = new AdminMenuPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Closed the Browser after RETC_015");
	}

	@Test
	public void logoutTest() throws InterruptedException {
		// Login with valid credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
		// Assertion of the Logged in Page
		String expected = "Dashboard ‹ Real Estate — WordPress";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
		// Logout
		AdminMenu.hoverAdmin();
		screenShot.captureScreenShot("RETC_015");
		AdminMenu.clickLogOut();
	}
}

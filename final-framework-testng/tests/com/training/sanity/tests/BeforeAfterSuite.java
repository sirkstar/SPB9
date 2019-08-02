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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProfilePOM;
import com.training.pom.AdminMenuPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class BeforeAfterSuite {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProfilePOM ProfilePOM;
	private ProfilePOM GenPassword;
	private AdminMenuPOM AdminMenu;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		ProfilePOM = new ProfilePOM(driver);
		GenPassword = new ProfilePOM(driver);
		AdminMenu = new AdminMenuPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
		@AfterSuite
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}

/*	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
//		driver = new ChromeDriver();
		loginPOM = new LoginPOM(driver); 
		ProfilePOM = new ProfilePOM(driver);
		GenPassword = new ProfilePOM(driver);
		AdminMenu = new AdminMenuPOM(driver);
		baseUrl = properties.getProperty("baseURL");
//		driver.get("http://realestatem1.upskills.in/admin");
		screenShot = new ScreenShot(driver); 
		// open the browser 
//		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
*/	
	@Test (priority = 0)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		screenShot.captureScreenShot("First");
		loginPOM.clickLoginBtn(); 
		System.out.println("Test till login complete...");
//		screenShot.captureScreenShot("First");
		String expected = "Dashboard ‹ Real Estate — WordPress";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
//		Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Real Estate — WordPress");
/*		
//		-----------------------------------
		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();
//		ProfilePOM.editprofile();
		ProfilePOM.sendLastName("manzoor");
		ProfilePOM.sendPhone("9876543210");
		ProfilePOM.clickSubmitBtn();
		ProfilePOM.dashboard();

		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();
		GenPassword.genPassword();
		GenPassword.sendNewPassword("manzoor");
		GenPassword.clickSubmitBtn();
//		Thread.sleep(5000);
		GenPassword.dashboard();
//		Thread.sleep(5000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		-------------------
		try {
			Alert alert = driver.switchTo().alert();		
			
			// Capturing alert message.    
			String alertMessage= driver.switchTo().alert().getText();		
					
			// Displaying alert message		
			System.out.println(alertMessage);	
//			Thread.sleep(5000);
					
			// Accepting alert		
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unexpected alert not present");  
		}	
//		---------------------
//		Thread.sleep(5000);
		AdminMenu.hoverAdmin();
		AdminMenu.clickLogOut();
//	-----------------------------------
*/	}
	@Test (priority = 1)
	public void RETC_013() {
		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();
//		ProfilePOM.editprofile();
		ProfilePOM.sendLastName("manzoor");
		ProfilePOM.sendPhone("9876543210");
		ProfilePOM.clickSubmitBtn();
		ProfilePOM.dashboard();
	}
	@Test (priority = 2)
	public void RETC_014() {
		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();
		GenPassword.genPassword();
		GenPassword.sendNewPassword("manzoor");
		GenPassword.clickSubmitBtn();
		GenPassword.dashboard();
		try {
			Alert alert = driver.switchTo().alert();		
			
			// Capturing alert message.    
//			String alertMessage= driver.switchTo().alert().getText();		
					
			// Displaying alert message		
//			System.out.println(alertMessage);	
//			Thread.sleep(5000);
					
			// Accepting alert		
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unexpected alert not present");  
		}	
	}
	@Test (priority=3)
	public void RETC_015() {
		AdminMenu.hoverAdmin();
		AdminMenu.clickLogOut();
	}
	
}

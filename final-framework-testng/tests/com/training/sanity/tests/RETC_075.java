package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminMenuPOM;
import com.training.pom.BlogPage;
import com.training.pom.ContactPage;
import com.training.pom.DashboardPage;
import com.training.pom.JavaScriptMethods;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.ProfilePOM;
import com.training.pom.PropertiesPage;
import com.training.pom.UsersPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_075{

	private static WebDriver driver;
	private LoginPOM loginPOM;
	private DashboardPage dash;
	private PostsPage posts;
	private AdminMenuPOM admin;
	private MainPage main;
	private JavaScriptMethods js;
	private static Properties properties;
	private String baseUrl;
	private Logger logger;
//	private ScreenShot screenshot;

	public static WebDriver getDriver() {
		return driver;
	}
		
	@Test(dataProvider = "excel-inputs_RETC_074", dataProviderClass=LoginDataProviders.class)
	public void contactForm(String username, String rolechange) throws InterruptedException {
		logger.info("RETC_074 starting");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
		dash.hoverPostsMenu();
		dash.clickAddNewPost();
		dash.clickAddNewCategory();
		dash.sendTxtNewcategory("Plots");
		dash.selectParentCategory();
		dash.clickBtnAddNewCategory();
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		posts.sendtitleofnewpost("vihar");
		Thread.sleep(2000);
		posts.sendbodyofnewpost("New Launch in Plots");
		Thread.sleep(5000);
		dash.checkboxChildCategory();
		js.scrollTop();
		Thread.sleep(2000);
		posts.clickPublish();
		
		admin.hoverAdmin();
		admin.clickLogOut();
		
		main.clickRealEstateLogo();
		js.scrollBy300();
		
		// Perform the click operation that opens new window
		String winHandleBefore = driver.getWindowHandle();
		
		main.sendSearchText("vihar");
		main.selectsearchresult();
		Thread.sleep(3000);
			
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

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
		posts = new PostsPage(driver);
		admin = new AdminMenuPOM(driver);
		main = new MainPage(driver);
		js = new JavaScriptMethods();
		baseUrl=properties.getProperty("baseURL");
//		screenshot = new ScreenShot(driver);
		driver.navigate().to(baseUrl);
		logger=Logger.getLogger("RETC_074");
		logger.info("Before Method initialized...");
		logger.info("Base URL opened");		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Closed the Browser after RETC_075");
	}

}

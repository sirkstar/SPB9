package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminMenuPOM;
import com.training.pom.BlogPage;
import com.training.pom.DashboardPage;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.PropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_042_Test {

	private static WebDriver driver;
	private static Properties properties;
//	private MainPage mainpage;
//	private BlogPage blog;
	private LoginPOM login;
	private DashboardPage dash;
	private AdminMenuPOM admin;
//	private PostsPage posts;
	private Logger logger;
	private String baseUrl;
	private PropertiesPage prop;
//	private ScreenShot screenshot;

//	public static WebDriver getDriver() {
//		return driver;
//	}
	
	@Test//(priority=1)
	public void validatecomments() throws InterruptedException {
		logger.info("admin login starting...");
		login.userLogin("admin", "adminuser@12345");
	
		logger.info("RETC_043 Starting... Adding new Post");
		dash.hoverPropertiesMenu();
		dash.clickaddnewprop();
		Thread.sleep(2000);
		prop.sendPropTitle("new launch");
		prop.sendBodyofNewprop("new launch");
		Thread.sleep(3000);
		
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.title)
		
		prop.clickPublishBtn();
		Thread.sleep(5000);
		prop.clickViewNewProp();
		Thread.sleep(2000);
		prop.assertNewProp();
		Thread.sleep(1000);
		prop.clickbacktodashboard();
		Thread.sleep(1000);
		dash.clickDashboard();
		logger.info("RETC_043 run completes");
		
		admin.hoverAdmin();
		admin.clickLogOut();
		Thread.sleep(2000);
		driver.close();
		
		
/*		try {
			Alert alert = RETC_041.getDriver().switchTo().alert();

			// Capturing alert message.
			String alertMessage = RETC_041.getDriver().switchTo().alert().getText();

			// Displaying alert message
			System.out.println(alertMessage);

			// Accepting alert
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unexpected alert not present");
		}
*/		
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
		admin = new AdminMenuPOM(driver);
//		posts=new PostsPage(driver);
		prop = new PropertiesPage(driver);
//		screenshot = new ScreenShot(RETC_041.getDriver());
		logger.info("Before Method initialized...");		
	}
}

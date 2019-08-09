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
import com.training.pom.AdminMenuPOM;
import com.training.pom.BlogPage;
import com.training.pom.DashboardPage;
import com.training.pom.FeaturesPage;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.PropertiesPage;
import com.training.pom.RegionPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_045_Test {

	private static WebDriver driver;
	private static Properties properties;
	private LoginPOM login;
	private DashboardPage dash;
	private PropertiesPage prop;
	private RegionPage region;
	private Logger logger;
	private String baseUrl;
	private AdminMenuPOM AdminMenu;
	
	@Test
	public void createPropertyBasedonRegionCreated() throws InterruptedException {
		logger.info("admin login starting...");
		login.userLogin("admin", "adminuser@12345");
		
		logger.info("RETC_045 Starting... Adding new Post");
		dash.hoverPropertiesMenu();
		dash.clickregionmenu();
		
		region.sendregionname("Electronic city");
		region.sendregionslug("Electronic city");
		region.selectParentreg();
		region.sendregiondesc("New Launches of villas, apartments, flats");
		region.clickaddregion();
		Thread.sleep(1000);
		
		dash.propaddnew();
		prop.sendPropTitle("prestige");
		Thread.sleep(1000);
		prop.sendBodyofNewprop("home town");
		Thread.sleep(1000);
		prop.selectregion();
		Thread.sleep(2000);
		prop.scrollup();
		
		prop.movetopublishmenu();
		
		Thread.sleep(5000);
		prop.assertviewpostdisplayed();
		logger.info("RETC_045 run completes");
		AdminMenu.hoverAdmin();
		AdminMenu.clickLogOut();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@BeforeTest
	public void setup() throws Exception {
		properties = new Properties();
		FileInputStream instream = new FileInputStream("./resources/others.properties");
		properties.load(instream);
		
		PropertyConfigurator.configure("./resources/log4j.properties");
		driver=DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl=properties.getProperty("baseURL");
		driver.get(baseUrl);
		
		logger=Logger.getLogger("RETC_045");
		login=new LoginPOM(driver);
		dash=new DashboardPage(driver);
		prop = new PropertiesPage(driver);
		region=new RegionPage(driver);
		AdminMenu = new AdminMenuPOM(driver);
		logger.info("Before Method initialized...");		
	}
}

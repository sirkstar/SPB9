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
import com.training.pom.FeaturesPage;
import com.training.pom.LoginPOM;
import com.training.pom.MainPage;
import com.training.pom.PostsPage;
import com.training.pom.PropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_044_Test {

	private static WebDriver driver;
	private static Properties properties;
	private LoginPOM login;
	private DashboardPage dash;
	private FeaturesPage feature;
	private PropertiesPage prop;
	private Logger logger;
	private String baseUrl;
	
	@Test
	public void validatecomments() throws InterruptedException {
		logger.info("admin login starting...");
		login.userLogin("admin", "adminuser@12345");
		
		logger.info("RETC_044 Starting... Adding new Post");
		dash.hoverPropertiesMenu();
		dash.clickfeaturesmenu();
		feature.sendfeaturename("New Launches");
		feature.sendfeatureslug("launch");
		feature.sendfeaturedescription("New Launches of villas, apartments, flats");
		feature.clickaddnewfeaturebtn();
		feature.propaddnew();
		prop.sendPropTitle("prestige");
		prop.sendBodyofNewprop("home town");
		prop.selectfeature();
		Thread.sleep(2000);
		prop.scrollup();
		
		prop.movetopublishmenu();
		
		Thread.sleep(2000);
//		prop.clickPublishBtn();
		Thread.sleep(5000);
		prop.assertviewpostdisplayed();
		logger.info("RETC_044 run completes");
		
		driver.close();
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
		
		logger=Logger.getLogger("RETC_044");
		login=new LoginPOM(driver);
		dash=new DashboardPage(driver);
		prop = new PropertiesPage(driver);
		feature = new FeaturesPage(driver);
		
		logger.info("Before Method initialized...");		
	}
}

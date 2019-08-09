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

public class RETC_043 {
	private DashboardPage dash;
	private PropertiesPage prop;
	private Logger logger;

	@BeforeTest
	public void setup() throws Exception {
		dash = new DashboardPage(RETC_041.getDriver());
		prop = new PropertiesPage(RETC_041.getDriver());
		logger = Logger.getLogger("RETC_043");
		logger.info("Before Method initialized...");
	}

	@Test
	public void validateProperties() throws InterruptedException {
		logger.info("RETC_043 Starting... Adding new Post");
		dash.hoverPropertiesMenu();
		dash.clickaddnewprop();
		Thread.sleep(1000);
		prop.sendPropTitle("new launch");
		prop.sendBodyofNewprop("new launch");
		Thread.sleep(3000);
		prop.clickPublishBtn();
		Thread.sleep(5000);
		prop.clickViewNewProp();
		Thread.sleep(2000);
		prop.assertNewProp();
		prop.clickbacktodashboard();
		dash.clickDashboard();
		Thread.sleep(2000);
		logger.info("RETC_043 run completes");
	}
}

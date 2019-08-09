package com.training.sanity.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.DashboardPage;
import com.training.pom.FeaturesPage;
import com.training.pom.PropertiesPage;

public class RETC_044 {

	private DashboardPage dash;
	private FeaturesPage feature;
	private PropertiesPage prop;
	private Logger logger;

	@BeforeTest
	public void setup() throws Exception {
		dash = new DashboardPage(RETC_041.getDriver());
		feature = new FeaturesPage(RETC_041.getDriver());
		prop = new PropertiesPage(RETC_041.getDriver());
		logger = Logger.getLogger("RETC_044");
		logger.info("Before Test initialized...");
	}

	@Test
	public void validateFeatures() throws InterruptedException {

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
		Thread.sleep(5000);
		prop.assertviewpostdisplayed();
		logger.info("RETC_044 run completes");
		dash.clickDashboard();
	}
}

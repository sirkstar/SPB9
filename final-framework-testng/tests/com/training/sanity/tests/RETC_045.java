package com.training.sanity.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.pom.AdminMenuPOM;
import com.training.pom.DashboardPage;
import com.training.pom.PropertiesPage;
import com.training.pom.RegionPage;

public class RETC_045 {

	private DashboardPage dash;
	private PropertiesPage prop;
	private RegionPage region;
	private AdminMenuPOM AdminMenu;
	private Logger logger;

	@BeforeTest
	public void setup() throws Exception {
		dash = new DashboardPage(RETC_041.getDriver());
		prop = new PropertiesPage(RETC_041.getDriver());
		region = new RegionPage(RETC_041.getDriver());
		AdminMenu = new AdminMenuPOM(RETC_041.getDriver());
		logger = Logger.getLogger("RETC_045");
	}

	@AfterSuite
	public void tearDown() throws Exception {
		RETC_041.getDriver().quit();
		System.out.println("Closed the Browser after RETC_045");
	}

	@Test
	public void validateRegions() throws InterruptedException {

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
//		dash.clickDashboard();
		Thread.sleep(1000);
		AdminMenu.hoverAdmin();
		AdminMenu.clickLogOut();
		Thread.sleep(1000);
	}
}

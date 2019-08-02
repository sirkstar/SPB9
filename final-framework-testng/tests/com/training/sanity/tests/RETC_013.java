package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
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

public class RETC_013 {
	private ProfilePOM ProfilePOM;
	private AdminMenuPOM AdminMenu;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		ProfilePOM = new ProfilePOM(RETC_011.getDriver());
		AdminMenu = new AdminMenuPOM(RETC_011.getDriver());
		screenShot = new ScreenShot(RETC_011.getDriver());
	}

	@Test
	public void profileDataUpdate() throws InterruptedException {
		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();
		// Assertion on the page
		String expected = "Profile ‹ Real Estate — WordPress";
		String actual = RETC_011.getDriver().getTitle();
		assertEquals(actual, expected);
		// edit profile;
		ProfilePOM.sendLastName("manzoor");
		ProfilePOM.sendPhone("9876543210");
		// Capture Screenshot
		screenShot.captureScreenShot("RETC_013");
		ProfilePOM.clickSubmitBtn();
		ProfilePOM.dashboard();
	}
}

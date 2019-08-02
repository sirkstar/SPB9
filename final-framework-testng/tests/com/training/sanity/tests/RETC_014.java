package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
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

public class RETC_014 {

	private ProfilePOM GenPassword;
	private AdminMenuPOM AdminMenu;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		GenPassword = new ProfilePOM(RETC_011.getDriver());
		AdminMenu = new AdminMenuPOM(RETC_011.getDriver());
		screenShot = new ScreenShot(RETC_011.getDriver());
	}

	@AfterTest
	public void tearDown() throws Exception {
		RETC_011.getDriver().close();
		System.out.println("Closed the Browser after RETC_014");
	}

	@Test
	public void changePassword() throws InterruptedException {
		// Hover to admin menu
		AdminMenu.hoverAdmin();
		AdminMenu.clickEditProf();

		// Assertion on the page
		String expected = "Profile ‹ Real Estate — WordPress";
		String actual = RETC_011.getDriver().getTitle();
		assertEquals(actual, expected);

		// Edit Profile to generate and change the password
		GenPassword.genPassword();
		GenPassword.sendNewPassword("manzoor");
		// Capture Screenshot
		screenShot.captureScreenShot("RETC_014");
		GenPassword.clickSubmitBtn();
		GenPassword.dashboard();
		try {
			Alert alert = RETC_011.getDriver().switchTo().alert();

			// Capturing alert message.
			String alertMessage = RETC_011.getDriver().switchTo().alert().getText();

			// Displaying alert message
			System.out.println(alertMessage);

			// Accepting alert
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unexpected alert not present");
		}
		// Logout
		AdminMenu.hoverAdmin();
		AdminMenu.clickLogOut();
	}
}

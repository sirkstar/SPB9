package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AdminMenuPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProfilePOM;
import com.training.pom.RecoverpwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_012 {

	private WebDriver driver;
	private String baseUrl;
	private RecoverpwdPOM recoverpwd;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		// Init Browser
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		recoverpwd = new RecoverpwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterTest
	public void tlearDown() throws Exception {
		driver.close();
		System.out.println("Closed the Browser after RETC_012");
	}

	@Test
	public void passwordRecoveryTest() throws InterruptedException {

		recoverpwd.clickLostPwd();
		recoverpwd.enterEmailforRecovery();
		Thread.sleep(2000);
		recoverpwd.clickResetPwd();
		Thread.sleep(2000);

		// Capture Screenshot
		screenShot.captureScreenShot("RETC_012");

		// Assertion of the Logged in Page
		String expected = "Confirmation email sent to your inbox, Kindly validate by clicking on the link provided in the email";
		// String expected = "The email could not be sent.\nPossible reason: your host
		// may have disabled the mail() function.";
		String actual = recoverpwd.webElemMessage().getText();
		Assert.assertEquals(actual, expected);
	}
}

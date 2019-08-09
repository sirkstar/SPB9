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

public class RETC_042 {

	private DashboardPage dash;
	private PostsPage posts;
	private Logger logger;

	@BeforeTest
	public void setup() throws Exception {
		dash=new DashboardPage(RETC_041.getDriver());
		posts=new PostsPage(RETC_041.getDriver());
//		screenshot = new ScreenShot(RETC_041.getDriver());
		logger=Logger.getLogger("RETC_042");
		logger.info("Before Method initialized...");		
	}
	
	@Test
	public void validatePosts() throws InterruptedException {
		
		logger.info("RETC_042 Starting... Adding new Post");
		posts.hoverPost();
		Thread.sleep(1000);
		dash.clickAddNewPost();
		posts.sendtitleofnewpost("New Launches");
		Thread.sleep(1000);
		posts.sendbodyofnewpost("New Launch in Home");
		Thread.sleep(2000);
		posts.clickAddNewPost();
		Thread.sleep(5000);
		posts.clickAllPosts();
		try {
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
		posts.clicknewlaunchlink();
		Thread.sleep(2000);
		posts.assertnewpost();
		logger.info("RETC_042 run completes");
	}
}

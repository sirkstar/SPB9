package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RealEstatePage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public RealEstatePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//RealEstate page -  WebElements/Web Objects
	@FindBy(xpath = "//h3[contains(text(),'vihar')]")
	private WebElement posttext;
		
	// RealEstate Page - Actions/Methods
	public void assertPostText() { 
//		this.posttext.click(); '
		String actText = "vihar";
		String expText = posttext.getText().toString();
		Assert.assertEquals(actText, expText);
		System.out.println("The Text in the post is as expected");
	}
}

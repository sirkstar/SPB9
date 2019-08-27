package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public ContactPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Contact page -  WebElements/Web Objects
	@FindBy(xpath = "//input[@placeholder='Your Name']")
	public WebElement name;
		
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Subject']")
	public WebElement subjectline;
		
	@FindBy(xpath = "//textarea[@placeholder='Message']")
	public WebElement messagecontent;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Send']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//div[contains(@role,'alert')][not(contains(@class,'screen-reader-response'))]")
	private WebElement alerttext;
	
	// Contact Page - Actions/Methods
	public void sendUserName(String userName) { 
		this.name.sendKeys(userName); 
	}
	
	public void sendEmail(String userEmail) { 
		this.email.sendKeys(userEmail); 
	}
	
	public void sendSubjectLine(String subjectLine) { 
		this.subjectline.sendKeys(subjectLine); 
	}
	
	public void sendActualMessage(String userMessage) { 
		this.messagecontent.sendKeys(userMessage); 
	}
	
	public void clickSubmitbtn() { 
		this.submitbtn.click(); 
	}
	
	public void assertalerttext() {
		String expText = "One or more fields have an error. Please check and try again.";
		String actText = alerttext.getText().toString();
		System.out.println(actText);
		Assert.assertEquals(actText, expText);
	}
	
}

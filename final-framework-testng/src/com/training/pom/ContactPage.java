package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
//	@FindBy(xpath="//div[contains(@class,'category-uncategorized')]//a[contains(text(),'Read More')]")
//	private WebElement readmore;
//	
//	@FindBy(xpath="//input[@name='login']")
//	private WebElement loginBtn;
	
/*	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
*/	
/*	public ProfilePOM userLogin(String userName, String password) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.password.clear();
		this.password.sendKeys(password);
		this.loginBtn.click();
		return new ProfilePOM(driver);
	}
*/
//	public String validateHomePageTitle() {
//		return this.driver.getTitle(); 
//	}
//	public void clickLoginBtn() { 
//		this.loginBtn.click(); 
//	}
}

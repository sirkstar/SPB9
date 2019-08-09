package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public MainPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@id='responsive']//a[contains(text(),'Blog') and contains(@href,'blog')]")
	private WebElement blog;
	
	public void clickBlog() { 
		this.blog.click(); 
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

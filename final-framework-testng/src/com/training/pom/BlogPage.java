package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public BlogPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'category-uncategorized')]//a[contains(text(),'Read More')]")
	private WebElement readmore;
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement addcomments; 
	
	@FindBy(xpath="//input[@id='author']")
	private WebElement commentauthor; 
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement commentemail; 
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement btnpostcomment; 
	
	@FindBy(xpath="//body[@id='error-page']")
	private WebElement errorpge; 
	
	public void clickReadMore() { 
		this.readmore.click(); 
	}

	public void addComments(String newcomments) {
		this.addcomments.clear();
		this.addcomments.sendKeys(newcomments);
	}
	
	public void commenterAuthor(String author) {
		this.commentauthor.clear();
		this.commentauthor.sendKeys(author);
	}
	
	public void commenterEmail(String email) {
		this.commentemail.clear();
		this.commentemail.sendKeys(email);
	}
	
	public void clickPostBtn() { 
		this.btnpostcomment.click(); 
	}
	
	public String errorPage() { 
		String errorText=this.errorpge.getText();
		return errorText;
	}
	
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
}

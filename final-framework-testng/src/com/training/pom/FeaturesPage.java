package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FeaturesPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public FeaturesPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//WebObjects/WebElements
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement featurename;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement featureslug;
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement featuredescription;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement btnaddnewfeature;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement propaddnew;
	
	//Methods/Actions
	
	public void sendfeaturename(String featurename) {
		this.featurename.clear();
		this.featurename.sendKeys(featurename);
	}
	
	public void sendfeatureslug(String featureslug) {
		this.featureslug.clear();
		this.featureslug.sendKeys(featureslug);
	}
	
	public void sendfeaturedescription(String featuredesc) {
		this.featuredescription.sendKeys(featuredesc);
	}
	
	public void clickaddnewfeaturebtn() {
		this.btnaddnewfeature.click();
	}
	
	public void propaddnew() {
		this.propaddnew.click();
	}
/*	
	public void sendtitleofnewpost(String title) {
		this.titleofnewpost.clear();
		this.titleofnewpost.sendKeys(title);
	}
	
	public void sendbodyofnewpost(String body) {
		this.bodyofnewpost.clear();
		this.bodyofnewpost.sendKeys(body);
	}
	
	public void clickAddNewPost() {
		this.publishnewpost.click();
	}
	
	public void sendUserName(String userName) {
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
	public String validateHomePageTitle() {
		return this.driver.getTitle(); 
	}
/*	public void clickLoginBtn() { 
		this.loginBtn.click(); 
	}*/
}

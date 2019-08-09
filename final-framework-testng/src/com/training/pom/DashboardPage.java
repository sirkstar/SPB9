package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public DashboardPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Dashboard - WebElement
	@FindBy(xpath="//div[contains(text(),'Dashboard')]")
	private WebElement dashboard;
	
	//Dashboard Method(s)
		public void clickDashboard() {
			this.dashboard.click();
		}
		
	//Posts Menu - WebObjects/WebElements
		
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement postsmenu; 
	
	@FindBy(xpath="//a[contains(text(),'All Posts')]")
	private WebElement allpostsmenu;
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement postsaddnew;
	
	@FindBy(xpath="//tr[1]//td[1]//strong[contains(text(),'krishna')]")
	private WebElement author;
	
	@FindBy(xpath="//tr[1]//td[1]//a[contains(text(),'krishnakumar@gmail.com')]")
	private WebElement authemail;
	
	@FindBy(xpath="//tr[1]//td[2]//p[contains(text(),'good')]")
	private WebElement comment;
	
	@FindBy(xpath="//tr[1]//td[3]//a[contains(text(),'New Launch')]")
	private WebElement category;
	
	// Posts - Methods/Actions
	public void hoverPostsMenu() {
		Actions movetoPosts = new Actions(driver);
		movetoPosts.moveToElement(postsmenu).build().perform();
	}
	
	public void clickAddNewPost() {
		this.postsaddnew.click();
	}
	
	public void assertcomment() {
		boolean result = comment.getText().equals("good") && 
				author.getText().equals("krishna") &&
				authemail.getText().equals("krishnakumar@gmail.com");// &&
//				category.getText().equals("New Launches");
			Assert.assertTrue(result);
	}
	
	//Comments Menu - WebObjects/WebElements
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement commentsmenu;

	//Comments - Methods:
	public void clickCommentsMenu() {
		this.commentsmenu.click();
	}
	
	//Properties Menu - WebObjects/WebElements
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propertiesmenu; 
	
	@FindBy(xpath="//a[contains(text(),'All Properties')]")
	private WebElement propallproperties; 
	
	@FindBy(xpath="//a[contains(@href,'property')][contains(text(),'Add New')]")
	private WebElement propertiesaddnew;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement propaddnew;

	//Properties - Methods/Actions:
	public void hoverPropertiesMenu() {
		Actions movetoProperties = new Actions(driver);
		movetoProperties.moveToElement(propertiesmenu).build().perform();
	}
	
	//add new from the hover menu - properties list
	public void clickaddnewprop() {
		this.propertiesaddnew.click();
	}
	
	//add new from expanded Properties list
	public void propaddnew() {
		this.propaddnew.click();
	}
	
	//Features SubMenu - WebElements
	@FindBy(xpath="//a[contains(text(),'Features')]")
	private WebElement propfeatures;

	//Features - Methods/actions
		public void clickfeaturesmenu() {
			this.propfeatures.click();
		}
	
	//Regions SubMenu - WebElements
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement propregions; 
	
	//Regions - Methods/actions
	public void clickregionmenu() {
		this.propregions.click();
	}
	
	//MISC WebElements
	@FindBy(xpath="//input[@id='author']")
	private WebElement commentauthor; 
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement commentemail; 
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement btnpostcomment; 
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement addcomments3; 
	
	@FindBy(xpath="//body[@id='error-page']")
	private WebElement errorpge; 
		
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

	public String validateHomePageTitle() {
		return this.driver.getTitle(); 
	}
	public void clickLoginBtn() { 
		this.loginBtn.click(); 
	}*/
}

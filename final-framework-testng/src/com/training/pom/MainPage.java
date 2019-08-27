package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public MainPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Main page -  WebElements/Web Objects
	@FindBy(xpath = "//ul[@id='responsive']//a[contains(text(),'Blog') and contains(@href,'blog')]")
	private WebElement blog;
		
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactus;
	
	@FindBy(xpath = "//a[contains(text(),'Real Estate')]")
	private WebElement logorealestate;
	
	@FindBy(xpath = "//input[@placeholder='Search here for Properties..']")
	private WebElement search;
	
	@FindBy(xpath = "//div[@class='promagnifier']/div[@class='innericon']/*[1]")
	private WebElement searchicon;
	
//	@FindBy(xpath = "//a[@class='asl_res_url'][contains(text(),'vihar')]")
	@FindBy(xpath = "//a[contains(text(),'vihar')]//span[@class='overlap']")
	private WebElement selectsearch;
	
	// Main Page - Actions/Methods
	public void clickBlog() { 
		this.blog.click(); 
	}
	
	public void clickContactUs() { 
		this.contactus.click(); 
	}
	
	public void clickRealEstateLogo() {
		this.logorealestate.click();
	}
	
	public void sendSearchText(String searchtext) {
		this.search.sendKeys(searchtext);
	}
		
	public void selectsearchresult() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(selectsearch).build().perform();
		Thread.sleep(3000);
		this.selectsearch.click();
	}
	
	public void clickSearchicon() {
		this.searchicon.click();
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

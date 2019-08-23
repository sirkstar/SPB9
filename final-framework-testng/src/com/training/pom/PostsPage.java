package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PostsPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public PostsPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath="//a[contains(text(),'All Posts')]")
	private WebElement allpostsmenu;
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement hoverpostlink;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleofnewpost;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement bodyofnewpost; 
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishnewpost; 
	
	@FindBy(xpath="//tr[1]//td[1]//a[text()='New Launches']")
	private WebElement clicknewlaunches;

	//Methods/actions
	public void hoverPost() {
		Actions actionpost = new Actions(driver);
		actionpost.moveToElement(hoverpostlink).build().perform();
	}
	
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
	
	public void clickPublish() {
		this.publishnewpost.click();
	}
	
	public void clickAllPosts() {
		this.allpostsmenu.click();
	}
	
	public void clicknewlaunchlink() {
		this.clicknewlaunches.click();
	}
	
	public void assertnewpost() throws InterruptedException {
		Boolean assertnewpost = bodyofnewpost.getText().equals("New Launch in Home");
//								&& titleofnewpost.getText().equals("New Launches");
		Assert.assertTrue(assertnewpost);
	}

	public String validateHomePageTitle() {
		return this.driver.getTitle(); 
	}
	
	//Category - WebElements/Web Objects
	@FindBy(xpath="//a[@id='category-add-toggle']")
	private WebElement addnewcategorylink; 
	
	@FindBy(xpath="//input[@id='newcategory']")
	private WebElement newcategory; 
	
	@FindBy(xpath="//select[@id='newcategory_parent']")
	private WebElement newcategoryparent; 
	
	@FindBy(xpath="//input[@id='category-add-submit']")
	private WebElement btnaddnewcategory; 
	
	@FindBy(xpath="//div[@id='taxonomy-category']//label[contains(text(),'Test1')]/input[contains(@name,'post_category')]")
	private WebElement selectcategory; 
	
	//Category - Methods/Actions
	public void clickaddnewcategorylink() {
		this.addnewcategorylink.click();
	}
	
	public void clickaddnewcategorylink1() {
		this.addnewcategorylink.click();
	}
	
	public void clicknewlaunchlink1() {
		this.clicknewlaunches.click();
	}
	
}

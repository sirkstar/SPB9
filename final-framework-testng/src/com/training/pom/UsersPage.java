package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.utility.Helper;

public class UsersPage {
	private WebDriver driver;
	
//	Initializing the page objects
	public UsersPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//WebObjects/WebElements
	public void userSearch(String xlParam) throws InterruptedException {
		this.usersearchtxtbox.sendKeys(xlParam);
		this.btnusersearchsubmit.click();
//		Thread.sleep(2000);
	}
	public void clickUserCheckbox(String xlParam) throws InterruptedException 
	{ 
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement checkbox = driver.findElement(By.xpath("//td[contains(text(),'"+xlParam+"')]/preceding-sibling::th/input"));
		WebElement checkbox = driver.findElement(By.xpath("//a[contains(text(),'"+xlParam+"')][contains(text(),'gmail')]/parent::td/preceding-sibling::th/input"));
//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", checkbox);
//		Thread.sleep(5000);
/*	
		String textbefore = "//td[contains(text(),'";
		String textafter = "')]/preceding-sibling::th";
		String text = xlParam; // column heading in Excel
		String xpathtext = textbefore+text+textafter;

		WebElement checkbox = driver.findElement(By.xpath(xpathtext));
*/		
		checkbox.click();
		js.executeScript("window.scrollTo(0,document.body.scrollTop);");
		}
	
	@FindBy(xpath="//select[@id='new_role']")
	private WebElement selectChangerole;
	
	@FindBy(xpath="//input[@id='changeit']")
	private WebElement btnchangerole;
	
	//WebElements for assertion
	@FindBy(xpath="//p[contains(text(),'Changed roles')]")
	private WebElement msgchangerole;
	
	@FindBy(xpath="//td[contains(text(),'amala')]/following-sibling::td[2]")
	private WebElement rolecheck;
	
	public void assertrolechanged(String user, String exprole) throws InterruptedException 
	{ 
//		WebElement changedrole = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/following-sibling::td[2]"));
		WebElement changedrole = driver.findElement(By.xpath("//td[contains(@class,'email')]//a[contains(text(),'"+user+"')][contains(text(),'gmail')]/following::td[1]"));
		String actrole = changedrole.getText().toString();
//		Assert.assertEquals(actrole, exprole);
		Assert.assertTrue(actrole.equalsIgnoreCase(exprole));
	}
	
	@FindBy(xpath="//input[@id='user-search-input']")
	private WebElement usersearchtxtbox;
	
	@FindBy(xpath="//input[@id='search-submit']")
	private WebElement btnusersearchsubmit;
	
	//Methods/Actions
	
	public void selectroletobechanged(String role) {
		Select rolechange = new Select(this.selectChangerole);
//		rolechange.selectByVisibleText(role);
		
		int index = 0;
	    for (WebElement option : rolechange.getOptions()) {
	        if (option.getText().equalsIgnoreCase(role))
	            break;
	        index++;
	    }
	    rolechange.selectByIndex(index);
	    
	}
	
	public void clickchangebutton() {
		this.btnchangerole.click();
	}
	
	public void assertresultmessages() {
		Assert.assertTrue(this.msgchangerole.isDisplayed());
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

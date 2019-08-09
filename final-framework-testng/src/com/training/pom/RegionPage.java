package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegionPage {
	private WebDriver driver; 
	
//	Initializing the page objects
	public RegionPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//WebObjects/WebElements
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement newregionname;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement newregionslug;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentregion;
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement newregiondesc;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement addnewregionbtn;
	
	@FindBy(xpath="//ul[@id='property_featurechecklist']//label[contains(text(),'New Launches')]")
	private WebElement addregions;
	
	//Methods/Actions
	
	public void sendregionname(String regname) {
		this.newregionname.clear();
		this.newregionname.sendKeys(regname);
	}
	
	public void sendregionslug(String regslug) {
		this.newregionslug.clear();
		this.newregionslug.sendKeys(regslug);
	}
	
	public List<String> parentreg() {
		List<String> parentreglist = new ArrayList<String>();
		Select parentreg = new Select(parentregion);
		int parentregsize = parentreg.getOptions().size();
		for (int i = 0; i < parentregsize; i++) {
			parentreg.selectByIndex(i);
			String arr1 = parentreg.getFirstSelectedOption().getText();
			parentreglist.add(arr1);
		}
		System.out.println(parentreglist);
		return parentreglist;
	}
	
	public void selectParentreg() {
		Select parentregsel = new Select(parentregion);
		parentregsel.selectByVisibleText("None");
	}
	
	public void sendregiondesc(String regdesc) {
		this.newregiondesc.clear();
		this.newregiondesc.sendKeys(regdesc);
	}
	
	public void clickaddregion() {
		this.addnewregionbtn.click();
	}
	
	
	
	@FindBy(xpath="//h2[contains(text(),'new launch')]")
	private WebElement propverificationtext1;
	
	@FindBy(xpath="//p[contains(text(),'new launch')]")
	private WebElement propverificationtext2;
	
	@FindBy(xpath="//a[@class='back-to-listings']")
	private WebElement backtodashboard;
	
	@FindBy(xpath="//ul[@id='property_featurechecklist']//label[contains(text(),'New Launches')]")
	private WebElement addFeature;
	
	@FindBy(xpath="//h2[@class='hndle ui-sortable-handle']//span[contains(text(),'Features')]")
	private WebElement featurehead;
	
//	@FindBy(xpath="//h2//span[contains(text(),'Features')]/preceding::div[@id='submitdiv']//div[@id='publishing-action']//input[@type='submit']")
//	private WebElement traverse2publish;
	
	@FindBy(xpath="//h2//span[contains(text(),'Features')]//preceding::div[8]/input[2]")
	private WebElement move2publish;
	
	
//	public void clickViewNewProp() {
//		this.viewnewprop.click();
//	}
	
	public void assertNewProp() {
		Boolean result = propverificationtext1.getText().contains("new launch")
				&& propverificationtext2.getText().equals("new launch");
		Assert.assertTrue(result);
	}
	
	public void clickbacktodashboard() {
		this.backtodashboard.click();
	}
	
	public void selectfeature() {
		this.addFeature.click();
	}
	
//	public void assertviewpostdisplayed() {
//		Assert.assertTrue(this.viewnewprop.isDisplayed());
//	}
//	
	public void scrollup() throws InterruptedException {

		//script scrolling option
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");
//		js.executeScript("arguments[0].scrollIntoView();", publishnewprop);
	}
	
	public void movetopublishmenu() {
		this.move2publish.click();
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

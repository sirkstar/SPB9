package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePOM {
	private WebDriver driver; 
	
	public ProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Howdy,')]")
	private WebElement admin;
	
	@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
	private WebElement editprof;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastname;

	@FindBy(xpath="//input[@id='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//button[contains(text(),'Generate Password')]")
	private WebElement pwdgen;
	
	@FindBy(xpath="//input[@id='pass1-text']")
	private WebElement pwdchange;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//div[contains(text(),'Dashboard')]")
	private WebElement dash;
	
	public void editprofile() {
		Actions movetoadmin = new Actions(driver);
		movetoadmin.moveToElement(admin).build().perform();
		editprof.click();
	}	
	
	public void sendLastName(String lastname) {
		this.lastname.clear(); 
		this.lastname.sendKeys(lastname); 
	}
	
	public void sendPhone(String phonenum) {
		this.phone.clear();
		this.phone.sendKeys(phonenum);
	}
	public void clickSubmitBtn() {
		this.submitbtn.click(); 
	}
	public void genPassword() {
		this.pwdgen.click();
	}
	public void sendNewPassword(String newpassword) {
		this.pwdchange.clear();
		this.pwdchange.sendKeys(newpassword);
	}
	public void dashboard() {
		this.dash.click();
	}
}
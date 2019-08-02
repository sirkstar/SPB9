package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMenuPOM {
	private WebDriver driver; 
	
	public AdminMenuPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Howdy,')]")
	private WebElement admin;
	
	@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
	private WebElement editprof;
	
	@FindBy(xpath="//a[@class='ab-item'][contains(text(),'Log Out')]")
	private WebElement logout;
	
	public void hoverAdmin() {
		Actions movetoadmin = new Actions(driver);
		movetoadmin.moveToElement(admin).build().perform();
	}
	
	public void clickEditProf() {
		this.editprof.click();
	}
	
	public void clickLogOut() {
		this.logout.click();
	}
}

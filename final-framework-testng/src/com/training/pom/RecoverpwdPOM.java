package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoverpwdPOM {
	private WebDriver driver; 
//    JavascriptExecutor js = (JavascriptExecutor) driver;

	public RecoverpwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='sign-in']")
	private WebElement logregister;
	
	@FindBy(xpath = "//input[@name='login']")
	private WebElement submitbtn;
	
//	//a[contains(@href,'lostpassword')]
	
//	@FindBy(xpath = "//a[contains(text(),'Lost Your Password?')]")
//	private WebElement lostpwd; 
	
	@FindBy(xpath = "//body[contains(@class,'page-template-default')]//input[@name='rememberme']")
	private WebElement rememberme; 
	
//	//input[@name='rememberme']
	
	@FindBy(xpath = "//p[@class='lost_password']//a[contains(@href,'lostpassword')]")
	private WebElement lostpwd; 
	
	
//	//form[@method='post'][@class='login][contains(@action,'wp-login.php')]
//	@FindBy(xpath = "//form[@method='post'][@class='login][contains(@action,'wp-login.php')]")
//	private WebElement loginbanner; 
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement resetbtn;
	
	@FindBy(xpath="//body[@id='error-page']")
	private WebElement message;
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement qweqwe;
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement qeda;
		
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.email.clear();
		this.email.sendKeys(userName);
	}
	
//	public void sendPassword(String password) {
//		this.password.clear(); 
//		this.password.sendKeys(password); 
//	}
//	
	
	public void clickLoginRegister() {
		this.logregister.click(); 
	}

	public WebElement sendLostPwd() {
		return lostpwd;
	}
	public void clickLostPwd() throws InterruptedException {

		//script scrolling option
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
//		js.executeScript("arguments[0].scrollIntoView();", lostpwd);
		Thread.sleep(2000);
		this.lostpwd.click();
        
//		js.executeScript("window.scrollBy(0,600)");
//        WebDriverWait wait2 = new WebDriverWait(driver, 10);
//        wait2.until(ExpectedConditions.elementToBeClickable(this.lostpwd));//By.xpath("//a[contains(text(),'Lost Your Password?')]")));
		
	}
	
	public void clickRememberMe() throws InterruptedException {
		//script scrolling option
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rememberme);
		Thread.sleep(3000);
//		this.lostpwd.click(); 
	}
	
	public void enterEmailforRecovery() {
		this.email.sendKeys("iamkayal11@gmail.com");
	}
	
	public void clickResetPwd() {
		this.resetbtn.click(); 
	}
	
	public String captureMessage() {
		String msg = this.message.getText();
//		System.out.println("The Message displayed in pwd recovery page: "+msg);
		return msg;
	}
	
	public WebElement webElemMessage() {
		return message;
	}

}

package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptMethods {
	WebDriver driver;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void scrollTop() {
		js.executeScript("window.scrollTo(0,document.body.scrollTop)");
	}
	public void scrollBy300() {
		js.executeScript("window.scrollBy(0,300);");
	}
}

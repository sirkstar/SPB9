package com.training.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

	public void highlightElement(WebDriver driver, WebElement element) { 

        JavascriptExecutor js = ((JavascriptExecutor) driver); 

        js.executeScript("arguments[0].setAttribute('style','background-color: yellow; border: 2px solid red;')", element); 

        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        js.executeScript("arguments[0].setAttribute('style','border: 2px solid white;')", element); 

    }
	
}

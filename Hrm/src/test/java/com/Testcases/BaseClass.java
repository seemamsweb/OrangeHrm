package com.Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static class BaseTests {
		 
	    public static WebDriver driver;
	    public WebDriverWait wait;
	       
	    @BeforeTest
	    public void setup() throws Exception {
	           
	    	 driver = WebDriverManager.chromedriver().create();
	         driver.get("https://opensource-demo.orangehrmlive.com/");
	         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	         driver.manage().window().maximize();
	    }
	       
	    @AfterTest
	     public  void closeBrowser() {
	             
	       driver.close();     
	               
	      }
	
}
}
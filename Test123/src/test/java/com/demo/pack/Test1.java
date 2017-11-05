package com.demo.pack;

import org.testng.annotations.Test;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Test1 {
	
	public WebDriver driver;
  @Test
  public void testGoogle() {
	  driver.get("https://www.google.co.in/");
	  
  }
 
 @Parameters("sBrowser") 
 @BeforeMethod
  public void beforeMethod(String sBrowser) {
	 if (sBrowser.equalsIgnoreCase("firefox")) {
		 System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		 
		 driver=new FirefoxDriver();
		
	}
	 else if (sBrowser.equalsIgnoreCase("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  driver=new ChromeDriver();
	}
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}

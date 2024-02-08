package com.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

public class BaseTest {


	WebDriver driver;
	
	public Page page;
	
	@BeforeMethod
	@Parameters(value={ "browser" })
	public void setUpTest(String browser){
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("no browser is defined in xml file");
		}
		
		driver.get("https://app.hubspot.com/login");
		
		try{
			Thread.sleep(6000);
		}catch(Exception e)
		{
			System.out.println("throw some time out exception");
			e.printStackTrace();
		}
		
		page = new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

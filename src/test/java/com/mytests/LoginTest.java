package com.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest(){
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
	}
	
	@Test(priority=3)
	public void doLoginTest(){
		HomePage homepage = page.getInstance(LoginPage.class).doLogin("naveenanimation20@gmail.com", "Test@12345");
		String header = homepage.getHomePageHeader();
		String title = homepage.getPageTitle();
		System.out.println("Home page header title: " + header + "| Home page title: " + title);
		Assert.assertEquals(header, "Academy");
		Assert.assertEquals(title, "HubSpot - Academy");
	}

}

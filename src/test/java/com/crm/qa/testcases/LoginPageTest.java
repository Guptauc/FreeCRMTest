package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lgnpg;
	HomePage homepage;
	SoftAssert obj=new SoftAssert();
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 lgnpg=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitle()
	{
		String title=lgnpg.ValidateFirstPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=3,enabled=true)
	
	public void loginTest()
	{
		//lgnpg.ClickOnlogin();
		homepage=lgnpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void loginPageTest()
	{
		lgnpg.ClickOnlogin();
	}
	
	
	@AfterTest(enabled=true)
	public void tearDown()
	{
		driver.quit();
	}
	

}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[1]/main/section[1]/a/span[1]")
	WebElement signup;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement submit;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}		
	
	//Actions
	public String ValidateFirstPageTitle()
	{
		return driver.getTitle();
	}
	
	public void ClickOnlogin()
	{
		login.click();
	}
	
	public HomePage login(String usrnm, String pass)
	{
		
		login.click();
		username.sendKeys(usrnm);
		password.sendKeys(pass);
		submit.click();
		
		return new HomePage();
		
	}
	

}

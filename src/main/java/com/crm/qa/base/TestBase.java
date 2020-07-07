package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtill;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
	
			FileInputStream ip;
			try {
				ip = new FileInputStream("C:\\Users\\Ujjwal Gupta\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							    
		
	}
	
	public static void initialization()
	{
	String brwosername=prop.getProperty("browser");
	if(brwosername.equals("Chrome")) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");  
	       
		  driver=new ChromeDriver();
		
	}
	
	else if(brwosername.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");  
	       
		  driver=new InternetExplorerDriver();
	}
	
          driver.manage().window().maximize(); 
          driver.manage().timeouts().pageLoadTimeout(TestUtill.Page_load_time,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  driver.get(prop.getProperty("url"));
		  
		  
		  
		  
	}
	

}

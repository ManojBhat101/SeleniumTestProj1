package com.learnautomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class mavenDemo {

	@Parameters("Browser")
	@Test
	public void testHello(String browserName) 
	{
		System.out.println("Parameter value is "+browserName);
		WebDriver driver=null;
		if(browserName.contains("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.contains("Edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/sshakti/login.do");
		Assert.assertTrue(driver.getTitle().contains("actiTIME"),"Title doesnot match");
		driver.quit();
	}
}

package com.learnautomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class testInHeadlessMode 
{
	@Test
	public void headlessTest()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in");
		System.out.println("Title is "+driver.getTitle());
		driver.quit();
	}
}

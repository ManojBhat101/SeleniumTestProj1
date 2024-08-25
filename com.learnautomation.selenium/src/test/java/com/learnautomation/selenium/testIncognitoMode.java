package com.learnautomation.selenium;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class testIncognitoMode 
{
	@Test
	public void incognitoModeTest()
	{
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito","--start-maximized");
		
		options.addArguments(Arrays.asList("--incognito","--start-maximized"));	//,"--headless=new"
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in");
		System.out.println("Title is "+driver.getTitle());
		driver.quit();
	}
}

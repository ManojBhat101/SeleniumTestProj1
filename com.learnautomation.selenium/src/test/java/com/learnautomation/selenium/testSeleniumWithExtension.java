package com.learnautomation.selenium;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//SLF4J -> Simple Logging Facade for Java - Logging framework
public class testSeleniumWithExtension 
{
	@Test
	public void getExtension()
	{
		ChromeOptions options = new ChromeOptions();	
//		options.addArguments(Arrays.asList("--incognito","--start-maximized"));
//		options.addExtensions(new File("./Extensions/SelectorsHub.crx"));
		//we can use List to store multiple extensions
		//ad block extension usage
		options.addExtensions(Arrays.asList(new File("./Extensions/SelectorsHub.crx"),new File("./Extensions/Privacy Ad Blocker.crx")));
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println("Title is "+driver.getTitle());
		driver.quit();
		
	}
}

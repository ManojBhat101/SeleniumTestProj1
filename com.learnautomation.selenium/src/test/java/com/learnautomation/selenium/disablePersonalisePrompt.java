package com.learnautomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class disablePersonalisePrompt {

	public static void main(String[] args) 
	{
		//to continue in guest profile
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--guest");
		//to run edge in headless mode
		options.addArguments("--headless=new");
		
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println("Title is "+driver.getTitle());
	}
}

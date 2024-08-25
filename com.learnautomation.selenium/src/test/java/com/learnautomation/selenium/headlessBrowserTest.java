package com.learnautomation.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class headlessBrowserTest 
{
	@Test
	public void verifyFacebookTitle()
	{
		WebDriver driver = new HtmlUnitDriver();
//		WebDriver driver = new HtmlUnitDriver(true); by giving value as true it supports JS
		driver.get("https://www.facebook.com/");
		String fbTitle = driver.getTitle();
		Assert.assertTrue(fbTitle.contains("Facebook"));
	}
}

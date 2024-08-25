package com.learnautomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mavenDemo {
	
	@Test
	public void testHello() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/sshakti/login.do");
		Assert.assertTrue(driver.getTitle().contains("actiTIME"),"Title doesnot match");
		driver.quit();
	}
}

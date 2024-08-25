package com.learnautomation.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class myAppWithExtentReport 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeClass
	public void startBrowser()
	{
//		logger = ExtentReports.get(myAppWithExtentReport.class);
//		logger.init("C:\\Users\\Admin\\Pictures\\mjSelenium\\Reports\\ExtentReport\\advanceReport.html",true);
//		logger.startTest("Verify Login into Application");
		
		driver = new ChromeDriver();
	}
	
	@Test(description="This Test case will start my application")
	public void startApp()
	{
		driver.manage().window().maximize();
//		logger.log(LogStatus.INFO,"Browser is up& running");
		driver.get("https://online.actitime.com/sshakti/login.do");
//		logger.log(LogStatus.INFO,"App is up & running");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String URL = driver.getCurrentUrl();
//		logger.log(LogStatus.INFO,"Url captured");
		Assert.assertTrue(URL.contains("login.do"));
//		logger.log(LogStatus.INFO,"Url is verified");
		
//		logger.attachScreenshot("C:\\Users\\Admin\\Desktop\\quote1.jpg");
	}
	
	@Test(dependsOnMethods="startApp",description="This Test case will login into my application")
	public void loginApp()
	{
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("shivamshakti555@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("LujgPmev");
		driver.findElement(By.xpath("//div[normalize-space()='Login']")).click();
		
		boolean status = driver.findElement(By.xpath("//div[normalize-space()='Users']")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test(dependsOnMethods="loginApp", description="This Test case will logout from my application")
	public void logoutApp() throws Exception 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='logoutLink'])[1]")).click();
		String title = driver.getTitle();
//		Assert.assertEquals(title, "actiTIME - Login");
		Assert.assertTrue(title.contains("actiTIME - Login"));
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
//		logger.endTest(null);
	}
}

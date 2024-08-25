package com.learnautomation.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class myAppWithExtentReport2 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	
	@Test(description="This Test case will start my application")
	public void startApp()
	{
		report = new ExtentReports("C:\\Users\\Admin\\Pictures\\mjSelenium\\Reports\\ExtentReport\\manoj2.html");
		logger = report.startTest("Verify URL of my app");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser Started");
		driver.get("https://online.actitime.com/sshakti/login.do");
		logger.log(LogStatus.INFO, "App is up & running");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("login.do"));	//login.do
		logger.log(LogStatus.PASS, "URL Verified");
	}
	
	@Test(dependsOnMethods="startApp",description="This Test case will login into my application")
	public void loginApp() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("shivamshakti555@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("LujgPmev");
		driver.findElement(By.xpath("//div[normalize-space()='Login']")).click();
		logger.log(LogStatus.INFO, "Successfully logged into app");
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//div[normalize-space()='Users']")).isDisplayed();
		Assert.assertTrue(status);
		logger.log(LogStatus.PASS, "Verified Logged in or not");
	}
	
	@Test(dependsOnMethods="loginApp", description="This Test case will logout from my application")
	public void logoutApp() throws Exception 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='logoutLink'])[1]")).click();
		logger.log(LogStatus.INFO, "Successfully logged out from app");
		String title = driver.getTitle();
//		Assert.assertEquals(title, "actiTIME - Login");
		Assert.assertTrue(title.contains("manoj"));	//actiTIME - Login
		logger.log(LogStatus.PASS, "Verified Logged out from app");
	}
	
	
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path = utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification",image);
		}
		report.endTest(logger);
		report.flush();
		
		driver.get("C:\\Users\\Admin\\Pictures\\mjSelenium\\Reports\\ExtentReport\\manoj2.html");
	}
	 
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
}

package com.learnautomation.selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
  @Test
  public void f() {
	  int a=100;
	  int b=100;
	  Assert.assertEquals(a, b);
	  System.out.println("===Test Done===");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("===Starting the Test===");
  }

  @AfterMethod
  public void afterClass(ITestResult result) {
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
//		  com.learnautomation.selenium.sendEmail();
		  System.out.println("Test Failed and Email sent");
	  }
  }
}

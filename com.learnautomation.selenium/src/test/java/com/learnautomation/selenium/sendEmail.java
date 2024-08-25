package com.learnautomation.selenium;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class sendEmail {

	public static void main(String[] args) throws Exception {
		System.out.println("Test Started");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("selenium77mj@gmail.com", "Test#991"));
		email.setSSLOnConnect(true);
		email.setFrom("mj@gmail.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail from selenium... :-)");
		email.addTo("manojbht101@gmail.com");
		email.send();
		System.out.println("Email Sent");
	}
}

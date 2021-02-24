package com.doc.qa.util;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.doc.qa.base.TestBase;



public class SocialLogin  extends TestBase {
	
	public SocialLogin() throws AWTException, InterruptedException{
		PageFactory.initElements(driver, this);
		
	}
	String parentWinHandle;
	
	@FindBy(id="email")
	WebElement fb_email;
	
	@FindBy(id="pass")
	WebElement fb_password;
	
	
	
	public void fbLogin() throws IOException, InterruptedException{
		//Enter Emailid
		fb_email.sendKeys("test.vizag01@yahoo.com");
		Thread.sleep(2000);
		// Enter Password Enter your password
		fb_password.sendKeys("Sherwin@1"+Keys.ENTER);
		Thread.sleep(10000);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username or email']")
	WebElement twitter_email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement twitter_password;
	
	public void twitterLogin() throws IOException, InterruptedException{
		//Enter Emailid
		twitter_email.sendKeys("test.vizag01@gmail.com");
		Thread.sleep(2000);
		// Enter Password Enter your password
		twitter_password.sendKeys("sherwin123"+Keys.ENTER);
		Thread.sleep(3000);
	}
	
	
}

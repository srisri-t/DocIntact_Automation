package com.doc.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.doc.qa.base.TestBase;



public class YahooMail  extends TestBase {
	
	@FindBy(xpath = "//input[@id='login-username']" )
	WebElement yahoo_username;
	
	@FindBy(xpath = "//input[@id='login-passwd']" )
	WebElement yahoo_password;
	
	@FindBy(xpath = "//span[contains(text(),'Docintact Password Reset OTP')]")
	WebElement otp_mail_click;
	
	@FindBy(xpath = "//p[contains(text(),'Your One Time Password is')]")
	WebElement get_otp;
	String OTP;
	String parentWinHandle;

	public YahooMail() throws AWTException, InterruptedException{
		PageFactory.initElements(driver, this);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_N);
		parentWinHandle = driver.getWindowHandle();
        Set<String> winHandles = driver.getWindowHandles();
        
        // Loop through all handles
        for(String handle: winHandles)
        {
            if(!handle.equals(parentWinHandle)){
            driver.switchTo().window(handle);
            Thread.sleep(1000);
            System.out.println("Title of the new window: " + driver.getTitle());
            }
        }
	    Thread.sleep(2000);
		driver.get("https://login.yahoo.com?.src=ym&.lang=en-AU&.intl=au&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
	}
	
	public void YahooLogin(String uname,String password) throws IOException, InterruptedException{
		yahoo_username.sendKeys(uname);
		Thread.sleep(1000);
		yahoo_username.sendKeys(Keys.RETURN);
		yahoo_password.sendKeys(password);
		Thread.sleep(1000);
		yahoo_password.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
	}
	
	public  String get_otp() throws InterruptedException, IOException
	{
		YahooLogin(prop.getProperty("Forgotpassword_mailid"),prop.getProperty("ya_password"));
		otp_mail_click.click();
		OTP=get_otp.getText();
		String St=OTP;
		String[] OTP1 = St.split("is ");
		OTP = OTP1[1]; // Otp number
		System.out.println(OTP);
		close_newdrive();
		return OTP;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Docintact Account  Confirmation ')]")
	WebElement verify_mail_open;
	
	@FindBy(xpath = "//a[contains(text(),'Verify Email Address ')]")
	WebElement verify_link_text;
	
	public String verify_email() throws IOException, InterruptedException {
		YahooLogin("testautomation.vizag@yahoo.com",prop.getProperty("ya_password"));
		Thread.sleep(1000);
		verify_mail_open.click();
		Thread.sleep(1000);
		String verify_link_url=verify_link_text.getAttribute("href");
		close_newdrive();
		return verify_link_url;	
	}
	
	public void close_newdrive() throws InterruptedException
	{
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentWinHandle);
	}
	
}

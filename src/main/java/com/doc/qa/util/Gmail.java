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



public class Gmail  extends TestBase {
	
	public Gmail() throws AWTException, InterruptedException{
		PageFactory.initElements(driver, this);
		
	}
	String parentWinHandle;
	public void opengmail() throws AWTException, InterruptedException {
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
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	
	
	@FindBy(xpath = "//input[@aria-label='Email or phone']")
	WebElement email;
	
	@FindBy(xpath = "//input[@aria-label='Enter your password']")
	WebElement password;
	
	public void googleLogin() throws IOException, InterruptedException{
		email.sendKeys("test.rushikonda1@gmail.com"+Keys.ENTER);
		Thread.sleep(2000);
		// Enter Password Enter your password
		password.sendKeys("rushikonda1@"+Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void get_verify_mail() 
	{
		
	}
	public void close_gmail() throws InterruptedException
	{
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentWinHandle);
	}
}

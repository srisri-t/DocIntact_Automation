package com.doc.qa.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.doc.qa.base.TestBase;
import com.doc.qa.util.Gmail;
import com.doc.qa.util.SocialLogin;
import com.doc.qa.util.YahooMail;



public class LoginPage extends TestBase{
	


	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	@FindBy(xpath = "//span[@class='close-into']")
	WebElement welcome_close;
	
	
	// Home-> Singin Page
	@FindBy(xpath = "//button[contains(@class,'sign-in-')]")
	private WebElement homepage_Signin_btn;
	@FindBy(name = "username")
	private WebElement username_txt;
	@FindBy(name = "password")
	private WebElement password_txt;
	@FindBy(xpath = "//button[contains(@class,'btn btn')]")
	public WebElement signin_btn;
	
	@FindBy(xpath = "//i[text()='forgot password?']")
	WebElement forgotpassword_link;

	@FindBy(xpath = "//input[@id='ForgetPasswordemail']")
	WebElement forgotpassword_email;
	
	@FindBy(xpath = "//input[@id='otpfield']")
	WebElement otp_enter;
	
	@FindBy(xpath = "//button[@class='btn btn-sm sign-in0li12 txtun']")
	WebElement otp_click;
	
	@FindBy(xpath = "//input[contains(@placeholder,'New Password')]")
	WebElement new_password;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Confirm Password')]")
	WebElement cnf_password;
	
	@FindBy(xpath = "//button[contains(@class,'submit-but tx-un')]")
	WebElement reset_password;
	
	@FindBy(xpath = "//button[contains(@text,'Submit')]")
	WebElement reset_submit;
	
	@FindBy(xpath = "//div[@class='avatar-container']")
	WebElement profile_click;
	
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement chg_password;
	
	@FindBy (xpath="//input[@placeholder='Old Password']")
	WebElement old_password;
	
	@FindBy(xpath="//input[@placeholder='New Password']")
	WebElement new1_password;
	
	@FindBy (xpath="//input[@placeholder='Confirm Password']")
	WebElement cnf1_password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement chng_sub;
	
	
	@FindBy (partialLinkText ="Sign Out")
	WebElement signout_button;
	
	public MyFilesPage signin(String id, String password) throws InterruptedException {
		homepage_Signin_btn.click();
		Thread.sleep(2000);
		username_txt.sendKeys(prop.getProperty(id));
		Thread.sleep(2000);
		password_txt.sendKeys(prop.getProperty(password));
		Thread.sleep(1000);
		signin_btn.click();
		Thread.sleep(1000);
		if(welcome_close.isDisplayed())
		{
			welcome_close.click();
		}
		return new MyFilesPage();
		
	}
	@FindBy(xpath = "//button[@class='btn btn-gplus ico-gplus']")
	WebElement google_icon;
	public  void googlesignin() throws InterruptedException, AWTException, IOException {
		homepage_Signin_btn.click();
		Thread.sleep(2000);
		google_icon.click();
		Thread.sleep(3000);
		Gmail gmail=new Gmail();
		gmail.googleLogin();
		Thread.sleep(3000);
		if(welcome_close.isDisplayed())
		{
			welcome_close.click();
		}
	}
	
	@FindBy(xpath = "//button[@class='btn btn-fb ico-fb']")
	WebElement fb_icon;
	public  void fb_signin() throws InterruptedException, AWTException, IOException {
		homepage_Signin_btn.click();
		Thread.sleep(2000);
		fb_icon.click();
		Thread.sleep(3000);
		SocialLogin soc_log=new SocialLogin();
		soc_log.fbLogin();
		Thread.sleep(3000);
		if(welcome_close.isDisplayed())
		{
			welcome_close.click();
		}
		
	}
	@FindBy(xpath = "//button[@class='btn btn-tw ico-twtr']")
	WebElement twitter_icon;
	
	public  void twitter_signin() throws InterruptedException, AWTException, IOException {
		homepage_Signin_btn.click();
		Thread.sleep(2000);
		twitter_icon.click();
		Thread.sleep(3000);
		SocialLogin soc_log=new SocialLogin();
		soc_log.twitterLogin();
		Thread.sleep(3000);
		if(welcome_close.isDisplayed())
		{
			welcome_close.click();
		}
		
	}
	
	
public void forget_password() throws InterruptedException, IOException, AWTException {
	
	homepage_Signin_btn.click();
	Thread.sleep(3000);
	forgotpassword_link.click();
	forgotpassword_email.sendKeys(prop.getProperty("Forgotpassword_mailid"));
	Thread.sleep(3000);
	forgotpassword_email.sendKeys(Keys.BACK_SPACE);
	Thread.sleep(3000);
	forgotpassword_email.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	
	YahooMail yahoo=new YahooMail();
	String OTP=yahoo.get_otp();
	Thread.sleep(1000);	
	otp_enter.sendKeys(OTP);
	otp_click.click();
	Thread.sleep(1000);
	new_password.sendKeys(prop.getProperty("ya_password"));
	cnf_password.sendKeys(prop.getProperty("ya_password"));
	Thread.sleep(1000);
	reset_password.click();	
}

public void change_password(String oldp, String newp) throws InterruptedException {
	profile_click.click();
	chg_password.click();
	Thread.sleep(2000);
	old_password.sendKeys(oldp);
	Thread.sleep(2000);
	new1_password.sendKeys(newp);
	Thread.sleep(2000);
	cnf1_password.sendKeys(newp);
	Thread.sleep(2000);
	chng_sub.click();
	Thread.sleep(4000);
}



public void signout() throws InterruptedException {
	
	profile_click.click();
	Thread.sleep(3000);
	signout_button.click();
}

}

package com.doc.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.doc.qa.base.TestBase;
import com.doc.qa.util.YahooMail;





public class AddEmployee extends TestBase{
	
	// Initializing the Page Objects:
		 public AddEmployee() {
			 
			PageFactory.initElements(driver, this);
		}
		 
		 
		 //Add Employee
		 
		 @FindBy (xpath = "//a[contains(text(),'Employees')]")
		 WebElement emp_but;
		 
		 @FindBy (xpath = "//button[contains(text(),'Add Employee')]")
		 WebElement emp_add;
		 
		 @FindBy (xpath = "//input[@name='fname']")
		 WebElement emp_fname;
		 
		 @FindBy (xpath = "//input[@name='lname']")
		 WebElement emp_lname;
		 
		 @FindBy (xpath = "//input[@name='email']")
		 WebElement emp_mail;
		 
		 @FindBy (xpath = "//input[@name='mobilenumber']")
		 WebElement emp_mobile;
		 
		 @FindBy (xpath = "//select[@name='department']")
		 WebElement dep_drpdwn;
		 
		 @FindBy (xpath = "//label[contains(text(),'Male')]")
		 WebElement rd_but;
		 
		 @FindBy (xpath = "//button[@class='add-btn side_bg']")
		 WebElement sub_btn;
		 
		 //search for employee
		 
		 @FindBy (xpath = "//div[@class='input-group mb-3 row mar-t-11']//input[@placeholder='Search']")
		 WebElement search_box;
		 
		

	public void submit_employee() throws InterruptedException {
		
		Thread.sleep(2000);
	    emp_but.click();	
		Thread.sleep(2000);
		emp_add.click();
		Thread.sleep(2000);
		emp_fname.sendKeys("AutomatedScript");
		Thread.sleep(2000);
		emp_lname.sendKeys("QA");
		Thread.sleep(2000);
		emp_mail.sendKeys("testautomation.vizag@yahoo.com");
		Thread.sleep(2000);
		emp_mobile.sendKeys("9638527410");
		Thread.sleep(2000);
		Select sec=new Select(dep_drpdwn);
		sec.selectByVisibleText("QA1");
		Thread.sleep(2000);
		rd_but.click();
        Thread.sleep(2000);
        sub_btn.click();
        Thread.sleep(7000);
	}
     public void search_emp() throws InterruptedException {
        
    	 search_box.clear();
    	 Thread.sleep(2000);
        search_box.sendKeys("AutomatedScript");
        Thread.sleep(2000);
        search_box.sendKeys(Keys.ENTER);
	}
    
     String verify_link_url;
     
 	@FindBy(xpath = "//input[@placeholder='Enter Password']")
 	WebElement docintact_password;
 	
 	@FindBy(xpath = "//input[@placeholder='Enter Confirm Password']")
 	WebElement docintact_confirm_password;
 	
 	@FindBy(xpath = "//input[@name='agreetoSign']")
 	WebElement agreetosign;
 	
 	@FindBy(xpath = "//button[@type='submit']")
 	WebElement signup_docintact;
     public void EmployeeActivation() throws AWTException, InterruptedException, IOException
     {
    		String parentWinHandle;
    		YahooMail yahoo=new YahooMail();
    		verify_link_url=yahoo.verify_email();
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
    		driver.get(verify_link_url);
    		
    		docintact_password.sendKeys(prop.getProperty("ya_password"));
    		Thread.sleep(1000);
    		docintact_confirm_password.sendKeys(prop.getProperty("ya_password"));
    		Thread.sleep(1000);
    		agreetosign.click();
    		Thread.sleep(1000);
    		signup_docintact.click();
    		Thread.sleep(1000);
    		
    		 driver.close();
    		 Thread.sleep(1000);
    		 driver.switchTo().window(parentWinHandle);
    			
     }
     
     //Edit Employee
	 @FindBy (xpath = "//i[@mattooltip='Update']")
	 WebElement edit_but;
	 
	 //Edit page
	 @FindBy (xpath = "//input[contains(@name,'lname')] [contains(@class,'form-control ng-untouched ng-pristine ng-valid')]")
	 WebElement last_name;
	 
	 //Update button
	 @FindBy (xpath = "//button[contains(text(),'Update')]")
	 WebElement update_but;
     public void EditEmployee() throws InterruptedException
     {
    	 search_emp();
    	 Thread.sleep(2000);
    	 Actions action=new Actions(driver);
    	 action.moveToElement(status).build().perform();
    	 edit_but.click();
    	 Thread.sleep(1000);
    	 last_name.sendKeys("Automation");
    	 Thread.sleep(2000);
    	 update_but.click();
    	 
     }
     
     
     //Status
     @FindBy(xpath = "//div[@class='slider round']")
     WebElement status;
     
     @FindBy(xpath = "//span[contains(text(),'Yes')]")
     WebElement alert_pop;
     
     public void Status() throws Throwable {
    	 search_emp();
    	 Thread.sleep(2000);
    	 System.out.println(status.getText());
    	 if(status.equals("Active")) {
    		 status.click();
    		 Thread.sleep(1000);
    		 alert_pop.click();
    		 Thread.sleep(3000);
    	 }
    	 
    	 else {
    		 status.click();
    		 Thread.sleep(1000);
    		 alert_pop.click();
    		 
    		 Thread.sleep(3000);
    	 }
    		 
    	 
     }
     
     
     //Delete Employee
     @FindBy (xpath = "//i[@mattooltip='Delete']")
     WebElement delete_but;
     
     @FindBy(xpath = "//span[contains(text(),'Delete')]")
     WebElement confirm_delete_but;
     
     public void DeleteEmployee() throws InterruptedException  {
    	 
    	 Thread.sleep(2000);
    	 Actions action=new Actions(driver);
    	 action.moveToElement(status).build().perform();
    	 delete_but.click();
    	 Thread.sleep(1000);
    	 confirm_delete_but.click();
    	 Thread.sleep(2000);
    	 
     }
     
  
    
    
     
     
     
     
//     @FindBy(xpath = "//input[@placeholder='Search mail']")
//     WebElement search_gmail;
//     
//     @FindBy(xpath = "//span[contains(text(),'Docintact Account  Confirmation')]")
//     WebElement click_mail;
//     
//     @FindBy(xpath = "//a[contains(text(),'Verify Email Address ')]")
//     WebElement validate_mail;
//     public void emp_gmail_activation() throws AWTException, InterruptedException, IOException{
//    	 Gmail gmail=new Gmail();
//    	 gmail.opengmail();
//    	 Thread.sleep(3000);
//    	 gmail.googleLogin();
//    	 Thread.sleep(3000);
//    	 search_gmail.sendKeys("Docintact Account  Confirmation"+Keys.ENTER);
//    	 Thread.sleep(2000);
//    	 click_mail.click();
//    	 Thread.sleep(1000);
//    	 validate_mail.click();
//    	 Thread.sleep(7000);
//    	 
////    	 gmail.close_gmail();
    	 
//     }
     
     
}

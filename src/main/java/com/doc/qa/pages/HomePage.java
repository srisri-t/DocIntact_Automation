package com.doc.qa.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.doc.qa.base.TestBase;






public class HomePage extends TestBase {


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath ="//a[contains(text(),'Home')]")
     public WebElement Home_button;

	@FindBy(xpath="//button[contains(text(),'Start Your Account')]")
	public WebElement start_button;

	@FindBy (xpath="//button[contains(text(),'Cancel')]")
	public WebElement cnl_button;

	@FindBy (xpath = "//a[contains(text(),'Features')]" )
	public WebElement feature_button;

	@FindBy (xpath = "//button[contains(@class,'start-file-share-but')]")
	public WebElement file_button;

	@FindBy (xpath = "//a[contains(text(),'About Us')]")
	public WebElement about_button;

	@FindBy (xpath = "//a[contains(text(),'Verification')]")
	public WebElement verf_button;

	@FindBy (xpath = "//img[@class='strat-free-trail-inpt-gap rem-sh ng-star-inserted']")
	public WebElement upload_button;

	@FindBy (xpath = "//a[contains(text(),'Contact Us')]")
	public WebElement contact_button;

	@FindBy(xpath = "//button[@class='try-now']")
	public WebElement trynow;


	public void headerlinks_button_validation() throws InterruptedException, AWTException
	{
		//Home

        Home_button.click();
        Thread.sleep(500);
        start_button.click();
        Thread.sleep(500);
        String value ="Select Your Option";

		try {
			Assert.assertEquals("Select Your Option",value);
			System.out.println("Pass");
		}
		catch (Exception e) {
			System.out.println("Fail");
		}
          cnl_button.click();
	     Thread.sleep(500);



		//Feature

		feature_button.click();
		Thread.sleep(500);
        file_button.click();
        Thread.sleep(500);
        String value_1 ="Select Your Option";

		try {
			Assert.assertEquals("Select Your Option",value_1);
			System.out.println("Pass");
		}
		catch (Exception e) {
			System.out.println("Fail");
		}
          cnl_button.click();
          Thread.sleep(500);
          String curr_url=driver.getCurrentUrl();
          if(curr_url.equalsIgnoreCase(prop.getProperty("url")))
          {
        	  feature_button.click();
        	  Thread.sleep(1500);
        	  trynow.click();
        	  Thread.sleep(1500);
        	  cnl_button.click();
        	  Thread.sleep(1500);
          }


		//About us

		about_button.click();
		Thread.sleep(1500);
		start_button.click();
		Thread.sleep(1500);
        String value_2 ="Select Your Option";

		try {
			Assert.assertEquals("Select Your Option",value_2);
			System.out.println("Pass");
		}
		catch (Exception e) {
			System.out.println("Fail");
		}
          cnl_button.click();
          Thread.sleep(500);


		//Verification

	    verf_button.click();
	    Thread.sleep(500);
        upload_button.click();
        Thread.sleep(500);
		Robot one = new Robot();
		Thread.sleep(500);
		one.keyPress(KeyEvent.VK_TAB);
		one.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		one.keyPress(KeyEvent.VK_TAB);
		one.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		one.keyPress(KeyEvent.VK_TAB);
		one.keyRelease(KeyEvent.VK_TAB);
		one.keyPress(KeyEvent.VK_ENTER);
		one.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

		//Contact Us
		contact_button.click();
	}

	//Header links

	@FindBy (xpath = "//section[@class='first-section tophead-bg fixedheader']")
	WebElement header_link;

	public void header_link_validation() {

		List<WebElement> links = header_link.findElements(By.tagName("a"));
		System.out.println("Number of links:" +links.size());
		for(WebElement link:links)
		{
			try {
			String str=link.getText();
			if(str.equalsIgnoreCase("Sign In")) {
				break;
				}
			System.out.println(link.getText()+" - "+ link.getAttribute("href"));
			link.click();
			Thread.sleep(3000);
			}
			catch (Exception e)
			{e.printStackTrace();
			}
		}


	}


	// Footer links

	@FindBy (xpath = "//footer[contains(@class,'footer')]")
	WebElement footer_link;

	public void footer_link_validation()
	{
		List<WebElement> links = footer_link.findElements(By.tagName("a"));
		System.out.println("Number of links:" +links.size());
		for(WebElement link:links)
		{
			try {
			System.out.println(link.getText()+" - "+ link.getAttribute("href"));
			link.click();
			Thread.sleep(3000);
			}
			catch (Exception e)
			{e.printStackTrace();
			}
		}


	}

	//Document Download

	String file_name;

	@FindBy (xpath = "//a[contains(text(),'Sent Files')]")
	WebElement sent_file_btn;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	WebElement dwn_btn;

	@FindBy (xpath = "//input[@type='checkbox']")
	WebElement box_check;

	@FindBy (xpath = "//button[contains(text(),'Download')]")
    WebElement download;


	public void filename() throws InterruptedException, IOException
	{
		//create File object with dirpath and dname


	}

public static void move(String fname) throws IOException
{
      try {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM HH-mm-ss");
		  LocalDateTime now = LocalDateTime.now();
		  String timestamp = dtf.format(now);
          new File(System.getProperty("user.dir")+"\\DocIntact_Downloads\\"+timestamp).mkdir();

        Path temp = Files.move
        (Paths.get(System.getProperty("user.dir")+"\\DocIntact_Downloads\\"+fname),
        Paths.get(System.getProperty("user.dir")+"\\DocIntact_Downloads\\"+timestamp+"\\"+fname));

        if(temp != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
      } catch(Exception e)
      {
          e.printStackTrace();
       }


}

	public void document_download() throws InterruptedException {
		String download_dir_path=System.getProperty("user.dir")+"\\DocIntact_Downloads";
		File download_dir=new File(download_dir_path);
		if(!download_dir.exists())
		{
			download_dir.mkdirs();
		}

		Thread.sleep(2000);
		sent_file_btn.click();

		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//img[@id='filesList']"));
		 System.out.println("Number of elements:" +elements.size());
		 Thread.sleep(1000);
		 Actions builder = new Actions(driver);
		 builder.contextClick(elements.get(0));
		 builder.build().perform();
		 Thread.sleep(2000);
		 dwn_btn.click();
		 Thread.sleep(2000);
		 box_check.click();
		 Thread.sleep(2000);
		 download.click();
		 Thread.sleep(1000);
		 waitUntilFileToDownload(System.getProperty("user.dir")+"\\DocIntact_Downloads");
	}

	//Document Verification
	String message_name;

	public void document_verification() throws InterruptedException, AWTException, IOException {

	    File f = new File(System.getProperty("user.dir"), "DocIntact_Downloads");

	    //if directory exists,then
	    if(f.exists())
	    {
	        //get the contents into arr[]
	        //now arr[i] represent either a File or Directory
	        String arr[]=f.list();

	        //find no. of entries in the directory
	        int n=arr.length;

	        //displaying the entries
	        for (int i = 0; i < n ; i++) {
	            System.out.println(arr[i]);
	            if(arr[i].contains(".pdf"))
	            {
	            	file_name=arr[i];

	    verf_button.click();
	    Thread.sleep(500);
        upload_button.click();
        StringSelection st= new StringSelection(System.getProperty("user.dir")+"\\DocIntact_Downloads\\"+file_name);
		Thread.sleep(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(st, null);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
//		move(file_name);
		List<WebElement> message = driver.findElements(By.tagName("h3"));
		 System.out.println("Number of elements:" +message.size());
		 for(i=0;i<=message.size();i++)
		 {
			 String message_nam=message.get(i).getText();
//			 System.out.println(message_nam);
			 if(message_nam.equalsIgnoreCase("Success"))
			 {

				 message_name="Success";
				 break;
			 }
			 if(message_nam.equalsIgnoreCase("Verification Failed"))
			 {

				 message_name="Verification Failed";
				 break;
			 }
		 }
		 System.out.println(message_name);

	            }

	        }
	        System.out.println("No of entries in this directory "+n);
	    }
	    else
	    System.out.println("Directory not found");


	}

	// To wait until file downloaded for chrome

	public static void waitUntilFileToDownload(String folderLocation) throws InterruptedException
	{
	    File directory = new File(folderLocation);
	    boolean downloadinFilePresence = false;
	    File[] filesList =null;
	    LOOP:
	        while(true) {
	            filesList =  directory.listFiles();
	            for (File file : filesList)
	            {
	            	downloadinFilePresence = file.getName().contains(".crdownload");
	            }
	            if(downloadinFilePresence) {
	                for(;downloadinFilePresence;)
	                {
	                    Thread.sleep(3000);
	                    continue LOOP;
	                }
	            }else {
	                break;
	            }
	        }
	}

}

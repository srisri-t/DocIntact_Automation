package com.doc.qa.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.doc.qa.base.TestBase;



public class MyFilesPage extends TestBase {

	// Initializing the Page Objects:

	public MyFilesPage() {
		PageFactory.initElements(driver, this);

	}

	Actions actions = new Actions(driver);

	// MyFiles page

	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	public WebElement login_Dashboard_Label;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement login_Home_Label;

	@FindBy(xpath = "//a[contains(text(),'My Files')]")
	public WebElement login_MyFiles_Label;

	@FindBy(xpath = "//a[contains(text(),'Favourites')]")
	public WebElement login_Favourites_label;

	@FindBy(xpath = "//a[contains(text(),'Sent Files')]")
	public WebElement login_SentFiles_Label;

	@FindBy(xpath = "//a[contains(text(),'Shared With Me')]")
	public WebElement login_SharedWithMe_Label;

	@FindBy(xpath = "//a[contains(text(),'Show Deleted Files')]")
	public WebElement login_ShowDeletedFiles_Label;

	@FindBy(xpath = "//a[contains(text(),'Templates')]")
	public WebElement login_Templates_label;

	// MyFiles page -> upload file through URL

	@FindBy(xpath = "//button[@class='btn quick-acess-but point bgclr btnsize bgimage upload-button-effect']")
	public WebElement upload_NewFile_btn;

	@FindBy(linkText = "Upload from URL")
	public WebElement upload_URL_Label;

	@FindBy(xpath = "//input[@id='basic-url']")
	public WebElement url_text;

	@FindBy(xpath = "//button[contains(text(),'Upload')]/parent::div/button")
	public WebElement upload_btn;

	@FindBy(xpath = "//span[text()='Keep it seperate']")
	public WebElement keep_seperate_btn;

	@FindBy(xpath = "//span[contains(text(),'Keep it seperate')]")
	public WebElement keep_button;

	public void upload_file_from_URL() throws InterruptedException {
		Thread.sleep(2000);
		login_MyFiles_Label.click();
		Thread.sleep(1000);
		upload_NewFile_btn.click();
		Thread.sleep(1000);
		upload_URL_Label.click();
		url_text.sendKeys(prop.getProperty("pdf_url"));
		Thread.sleep(1000);
		upload_btn.click();

		Thread.sleep(1000);
		try {
		if(keep_button.isEnabled())
		{
			keep_button.click();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Thread.sleep(7000);
		login_Home_Label.click();


	}


	 //MyFiles page --> Upload a file through local system

	@FindBy (xpath = "//label[@class='add-doc support-font']")
	WebElement add_button;

	public void upload_file_from_local_system() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		login_MyFiles_Label.click();
		Thread.sleep(1000);
		upload_NewFile_btn.click();
		Thread.sleep(1000);
		add_button.click();
		Thread.sleep(1000);
		StringSelection st= new StringSelection(System.getProperty("user.dir")+"\\Website");
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

		Thread.sleep(1000);
		try {
		if(keep_button.isEnabled())
		{
			keep_button.click();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Thread.sleep(7000);

	}


	//MyFiles page --> Upload a folder through local system

	@FindBy (linkText = "Upload Folder")
	WebElement upfolder_link;

	@FindBy (xpath ="//label[contains(text(),'Add Folders from your computer')]")
	WebElement addfolder_link;

	@FindBy (css = "body")
	WebElement body_btn;

	public void upload_folder_from_local_system() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		login_MyFiles_Label.click();
		Thread.sleep(2000);
		upload_NewFile_btn.click();
		Thread.sleep(2000);
		upfolder_link.click();
		Thread.sleep(2000);
		addfolder_link.click();
		StringSelection st= new StringSelection(System.getProperty("user.dir")+"\\Automation Test Folder");
		Thread.sleep(1000);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(st, null);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(200);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(200);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(200);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(200);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		try {
		if(keep_button.isEnabled())
		{
			keep_button.click();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Thread.sleep(7000);
	}




	// my files-> add sign and submit

	@FindBy(xpath = "//img[@id=\\\"filesList\\\"]")
	public WebElement first_file;

	@FindBy(xpath = "//span[contains(text(),'Insert fields')]")
	public WebElement Insert_fields_btn;

	@FindBy(id = "mat-expansion-panel-header-0")
	public WebElement panel_signature_field_bar;

	@FindBy(xpath = "//span[contains(text(),'Signature ')]")
	public WebElement sign_btn;

	@FindBy(xpath = "//button[contains(text(),'Share')]")
	public WebElement file_share_btn;

	@FindBy(id = "email")
	public WebElement sendTo_email;

	@FindBy(className = "individualbox1")
	public WebElement share_org_select;

	@FindBy(className = "individualbox1")
	public List<WebElement> share_org_select_count;

	@FindBy(xpath = "//span[(text()='Share ')]")
	public WebElement share_btn;

	@FindBy(xpath = "//*[@id=\"mat-option-14\"]")
	public WebElement drop_email;


	public void open_file_add_sign_share() throws AWTException, InterruptedException {
		login_MyFiles_Label.click();
		Thread.sleep(15000);
		List<WebElement> fileslist = driver.findElements(By.xpath("//img[@id='filesList']"));
		fileslist.get(0).click();
		actions.doubleClick(fileslist.get(0)).perform();
		Insert_fields_btn.click();
		Thread.sleep(2000);
		panel_signature_field_bar.click();
		Thread.sleep(2000);
		sign_btn.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.mouseMove(700, 400);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		file_share_btn.click();


		//
		Thread.sleep(3000);
		sendTo_email.sendKeys(prop.getProperty("Individual_id_user02"));
		sendTo_email.sendKeys(Keys.TAB);
		Thread.sleep(300);

		share_btn.click();
		Thread.sleep(2000);
		// driver.navigate().refresh();
	}


	public void open_file_Share_for_review() throws InterruptedException {

		login_MyFiles_Label.click();
		Thread.sleep(4000);
		List<WebElement> fileslist = driver.findElements(By.xpath("//img[@id='filesList']"));
//		fileslist.get(0).click();
		Thread.sleep(1000);
		System.out.println(fileslist.get(0));
		actions.doubleClick(fileslist.get(0)).perform();
		Thread.sleep(1000);
		file_share_btn.click();
		Thread.sleep(4000);
		List<WebElement> cancel_share = driver.findElements(By.xpath("//button[text()='Cancel']"));
		cancel_share.get(4).click();
		Thread.sleep(3000);
		sendTo_email.sendKeys(prop.getProperty("Individual_id_user02"));
		Thread.sleep(2000);
		sendTo_email.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		share_btn.click();
		Thread.sleep(2000);

	}

	//template share

	@FindBy (xpath = "//button[@class='btntxt1 btn btn-primary btn-md mat-raised-button ng-star-inserted']")
	WebElement button_1;

	@FindBy (xpath = "//div[@class='mat-card-content-template']")
	WebElement template;

	@FindBy (xpath = "//button[@class='select-temp-but-under']")
	WebElement temp;

	@FindBy (xpath = "//textarea[@placeholder='Type Your Message Here']")
	WebElement text;

	@FindBy (xpath = "//button[@class='btnforshare mat-raised-button']")
	WebElement btn;

	@FindBy (xpath = "//i[@class='fas fa-arrow-left t-col b-right pr-3']")
	WebElement btn_1;

	public void addTemplate() throws InterruptedException {

		login_MyFiles_Label.click();
		Thread.sleep(4000);
		List<WebElement> fileslist = driver.findElements(By.xpath("//img[@id='filesList']"));
		fileslist.get(0).click();
		Thread.sleep(1000);
		actions.doubleClick(fileslist.get(0)).perform();
		button_1.click();
		Thread.sleep(3000);
		template.click();
		Thread.sleep(3000);
		temp.click();
		Thread.sleep(3000);

		//file_share_btn

		file_share_btn.click();
	     Thread.sleep(3000);
//	     if(driver.findElements(By.xpath("//div[@class='individualbox1']")).size()>0)
//	     {
//	    	 driver.findElement(By.xpath("//div[@class='individualbox1']")).click();
//	     }
	      text.sendKeys("Testing");
	      Thread.sleep(3000);
	      btn.click();
	      Thread.sleep(2000);
	      btn_1.click();

	}


	// open file and sign and submit document

		@FindBy(xpath = "//div[text()=' Agree to our ']/input")
		public WebElement agreeTC_btn;

		@FindBy(xpath = "//button[text()='Agree to sign']")
		public WebElement agree_to_singn_gtn;

		@FindBy(xpath = "//a[contains(text(),'Shared With Me')]")
		public WebElement sharedWithMelab;

		String file_List = "//div[@id='filesList']";

		@FindBy (xpath = "//span[text()='Signature']")
		WebElement elementLocator;

		@FindBy (xpath = "//p[@class='txthide']")
		WebElement txthide;

		@FindBy (xpath = "//div[@class='row photo-field']/div/div")
		WebElement photo_field;

		@FindBy (xpath = "//button[@class='top-head-but btn-sm homefont bsha-none version ng-star-inserted']")
		WebElement button;

		@FindBy (xpath = "//span[contains(text(),'Yes')]")
		WebElement yes_button;

		@FindBy (xpath = "//button[text()='ok']")
		WebElement ok_button;

		public void open_share_dFile_sign_submit() throws InterruptedException {

			Thread.sleep(4000);
			sharedWithMelab.click();
			Thread.sleep(5000);
			List<WebElement> filesList = driver.findElements(By.xpath(file_List));
			Thread.sleep(3000);
			filesList.get(0).click();
			Actions actions = new Actions(driver);
			actions.moveToElement(filesList.get(0));
			actions.doubleClick().build().perform();
			Thread.sleep(3000);
			agreeTC_btn.click();
			agree_to_singn_gtn.click();
			Thread.sleep(3000);
			Actions actions1 = new Actions(driver);
			actions1.doubleClick(elementLocator).perform();
			Thread.sleep(3000);
			txthide.click();
			Thread.sleep(3000);
			photo_field.click();
			Thread.sleep(3000);
			button.click();
			Thread.sleep(2000);
			yes_button.click();
			Thread.sleep(4000);
			ok_button.click();
			Thread.sleep(3000);

		}

	//navigate to all pages

	@FindBy(xpath = "//div[@id='navbarTogglerDemo01']")
	WebElement all_links;
	public void navigatePages() {
		List<WebElement> links = all_links.findElements(By.tagName("a"));
		System.out.println("Number of links:" +links.size());
		for(WebElement link:links)
		{
			try {
			String str=link.getAttribute("href");
			if(str.equalsIgnoreCase(prop.getProperty("url")+"#")) {
				break;}
			System.out.println(link.getText()+" - "+ link.getAttribute("href"));
			link.click();}
			catch (Exception e)
			{e.printStackTrace();
			}
		}
	}

	//share for review file submission

	@FindBy (xpath = "//a[contains(text(),'Shared With Me')]")
	WebElement shared_button;

	@FindBy (xpath = "//input[@class='ng-untouched ng-pristine ng-valid']")
	WebElement agree_checkbox;

	@FindBy (xpath = "//button[@class='btn btn-md sharereivew-button fon-18']")
	WebElement submit_btn;

	@FindBy (xpath = "//button[contains(@class,'top-head-but btn-sm homefont bsha-none version ng-star-inserted')]")
	WebElement review_btn;

	@FindBy (xpath = "//span[contains(text(),'Yes')]")
	WebElement yes_btn;

	@FindBy (xpath = "//button[text()='ok']")
	WebElement ok_btn;


//    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	public void submit_share_for_review() throws InterruptedException {

		shared_button.click();
		Thread.sleep(2000);
//		List<WebElement> fileslist = driver.findElements(By.xpath("//p[contains(text(),'sample-link_1.pdf')]"));
		List<WebElement> filesList = driver.findElements(By.xpath(file_List));
		Thread.sleep(1000);
		filesList.get(1).click();
		Thread.sleep(1000);
		actions.doubleClick(filesList.get(1)).perform();
		actions.build().perform();
		Thread.sleep(1000);
		agree_checkbox.click();
		Thread.sleep(1000);
		submit_btn.click();
		Thread.sleep(1000);
		review_btn.click();
		Thread.sleep(1000);
		yes_btn.click();
		Thread.sleep(1000);
		ok_btn.click();
		Thread.sleep(1000);
	}

	// right click context

	String file_name;

	  public void right_click_context() throws InterruptedException {
		  Thread.sleep(2000);
		 List<WebElement> elements = driver.findElements(By.xpath("//div[@id='foldersList']"));
		 System.out.println("Number of elements:" +elements.size());
		 Thread.sleep(1000);
		 Actions builder = new Actions(driver);
		 file_name=elements.get(0).getText();
		 builder.contextClick(elements.get(0));
		 builder.build().perform();
		 Thread.sleep(2000);
		 System.out.println(file_name);

	}

		//Create NewFolder

		@FindBy(xpath = "//div[@class=' tooltipp']")
		WebElement New_Folder;

		@FindBy(xpath = "//input[@placeholder='Folder Name']")
		WebElement Folder_Name;

		@FindBy(xpath = "//span[contains(text(),'Create')]")
		WebElement Create_but;


		public void newfolder() throws InterruptedException
		{


			New_Folder.click();
			Thread.sleep(2000);
			Folder_Name.sendKeys("Testing");
			Create_but.click();
		}









	//Context click menu for folder (Right click for share)

	@FindBy (xpath = "//span[contains(text(),'share')]")
	WebElement share_button;

	public void right_click_menu_for_folder() throws InterruptedException {


		right_click_context();
		Thread.sleep(1000);
		 share_button.click();
		 Thread.sleep(2000);
		 sendTo_email.sendKeys(prop.getProperty("Individual_id_user02"));
     	Thread.sleep(2000);
     	sendTo_email.sendKeys(Keys.TAB);
		share_btn.click();
		Thread.sleep(2000);


	}

	//right click for open a file

	@FindBy (xpath = "//span[contains(text(),'open')]")
	WebElement open_btn;

	public void right_click_open_file() throws InterruptedException {

	 right_click_context();
	 Thread.sleep(2000);
	 open_btn.click();
	 Thread.sleep(2000);
	}



	//right click for move to

	@FindBy (xpath = "//span[contains(text(),'New Folder')]")
	WebElement newfolder_btn;

	@FindBy (xpath = "//input[@id='CreateNewFolder']")
	WebElement folder_name;

	//@FindBy (xpath = "//button[@class='savebtn b0utnstyle mat-raised-button mat-primary']")

	@FindBy (xpath = "//span[contains(text(),'Create')]")
	WebElement create_btn;

	@FindBy (xpath = "//div[@class='move-highligh-icon']")
	WebElement select_folder;

	@FindBy (xpath = "//button[contains(text(),'Move Here')]")
	WebElement move_btn;

	@FindBy (xpath = "//span[contains(text(),'Move To')]")
	WebElement move_to_btn;

		public void move_to_folder_right_click() throws InterruptedException {

			right_click_context();
			 Thread.sleep(2000);
			 move_to_btn.click();
			 Thread.sleep(2000);
			 newfolder_btn.click();
			 Thread.sleep(1000);
			 folder_name.sendKeys("QA_Dept");
			 Thread.sleep(2000);
			 create_btn.click();
			 Thread.sleep(2000);
			 List<WebElement> elements_1 = driver.findElements(By.xpath("//span[@class='name align21']"));
			 System.out.println("Number of elements:" +elements_1.size());
			 Thread.sleep(2000);
			 Actions builder_1 = new Actions(driver);
			 builder_1.click(elements_1.get(0));
			 builder_1.build().perform();
			 select_folder.click();
			 Thread.sleep(1000);
			 move_btn.click();
	}

		//Upload file through right click

		@FindBy (xpath = "//span[contains(text(),'Upload Files')]")
		WebElement upload_file_btn;

		public void file_upload_right_click() throws InterruptedException, AWTException {

			right_click_context();
			 Thread.sleep(2000);
			upload_file_btn.click();
			 Thread.sleep(2000);
			    StringSelection st= new StringSelection(System.getProperty("user.dir")+"\\Website");
				Thread.sleep(2000);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(st, null);
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(10000);
		}

		//Rename a folder through right click

		@FindBy (xpath = "//button[@class='mat-menu-item ng-star-inserted']//span[contains(text(),'Rename')]")
		WebElement rename_btn;

		@FindBy (xpath = "//input[@placeholder='Folder Name']")
		WebElement folder_name_text;

		@FindBy (xpath = "//span[contains(text(),'Submit')]")
		WebElement rename_submit_btn;

		public void rename() throws InterruptedException {

			right_click_context();
			Thread.sleep(1000);
			rename_btn.click();
			Thread.sleep(1000);
			folder_name_text.sendKeys("11");
			Thread.sleep(3000);
			rename_submit_btn.click();
			Thread.sleep(1000);
		}

		//Delete a folder through right click

		@FindBy (xpath = "//span[contains(text(),'Delete')]")
		WebElement del_btn;

		public void delete_right_click() throws InterruptedException {

			right_click_context();
			Thread.sleep(2000);
			del_btn.click();
			Thread.sleep(1000);
			del_btn.click();
			Thread.sleep(1000);
		}

		//Add to favourite through right click

		@FindBy(xpath = "//button[@class='mat-menu-item ng-star-inserted']//span [contains(text(),'Add to Favourites')]")
		WebElement fav_option;

		public void favouritefile() throws InterruptedException, AWTException {
			right_click_context();
			Thread.sleep(1000);
			fav_option.click();
			Thread.sleep(1000);
		}

		//Remove as favourite through right click from favourite

		@FindBy(xpath = "//a[contains(text(),'Favourites')]")
		WebElement favourites;

		@FindBy (xpath = "//button[@class='mat-menu-item']//span[contains(text(),'Remove from Favourites')]")
		WebElement remove_option;

		public void verify_favourites() throws InterruptedException	{

			favourites.click();
			Thread.sleep(1000);
			right_click_context();
			Thread.sleep(2000);
			remove_option.click();
			Thread.sleep(2000);
		}
		//Share a document from organization to organization

		@FindBy (xpath = "//div[@class='organisationbox1']")
		WebElement org_butn;

		@FindBy (xpath = "//div[@class='mat-form-field-flex']")
		WebElement Dpt_share_btn;

		@FindBy (xpath = "//button[@class='share-but']")
		WebElement Button_share;
		public void share_organization() throws InterruptedException, AWTException {
			Thread.sleep(2000);
			login_MyFiles_Label.click();
			Thread.sleep(2000);
			List<WebElement> fileslist = driver.findElements(By.xpath("//img[@id='filesList']"));
			fileslist.get(0).click();
			actions.doubleClick(fileslist.get(0)).perform();
			Insert_fields_btn.click();
			Thread.sleep(2000);
			panel_signature_field_bar.click();
			Thread.sleep(2000);
			sign_btn.click();
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.mouseMove(700, 400);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			file_share_btn.click();
			Thread.sleep(2000);
			org_butn.click();
			Thread.sleep(2000);
			Dpt_share_btn.click();
			Thread.sleep(2000);

			if ( !driver.findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted']")).isSelected() )
			{
			     driver.findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted']")).click();
			}
			Thread.sleep(2000);
			Button_share.click();
			Thread.sleep(2000);

		}
//        Actions action=new Actions(driver);
//
//		@FindBy(xpath = "//p[contains(text(),'sample-link_1.pdf')]")
//	//	@FindBy(xpath = "//p[contains(@id,'filesList')]")
//		WebElement File_name;
//
//		@FindBy(xpath = "//a[contains(text(),'Home')]")
//		WebElement Home;
//
//
//		public String fav_folder = "//p[contains(@id,'filesList ')]";
//
//		//public void verify_homefavourites() throws InterruptedException	{
//			WebElement file=File_name;
//			action.contextClick(file).perform();
//			Thread.sleep(2000);
//			Home.click();
//			List<WebElement> fav_files_list=driver.findElements(By.xpath(fav_folder));
//			System.out.println(fav_files_list.size());
//
//			String filename=File_name.getText();
//			for(int i=0;i<=fav_files_list.size();i++)
//			{
//				if(fav_files_list.get(i).getText().equalsIgnoreCase(filename))
//				{
//					System.out.println(filename+"Exists in Home");
//					break;
//				}
//			}


}

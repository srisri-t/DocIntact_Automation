package com.doc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.doc.qa.base.TestBase;


public class AddDepartment extends TestBase{
	
	// Initializing the Page Objects:
	
	 public AddDepartment() {
		 
		PageFactory.initElements(driver, this);
	}
	
	 //Add Department
	 
	@FindBy (xpath = "//a[contains(text(),'Departments')]")
    WebElement dep;
	
	@FindBy (xpath = "//img[@class='add-emp-pad']")
	WebElement add_dep;
	
	@FindBy (xpath = "//input[@placeholder='Enter Department Name']")
	WebElement dept_name;
	
	@FindBy (xpath = "//select[@name='parentdepartmentid']")
	WebElement dept_drop;
	
	@FindBy (xpath = "//button[@class='add-btn side_bg']")
	WebElement dept_button;
	
	//Search for Department
	
	@FindBy (xpath = "//div[@class='input-group mb-3 row mar-t-11']//input[@placeholder='Search']")
	WebElement dept_search;

	//Update Department Details
	
 //update dpt_upt xpath mailid on every mail change
    @FindBy (xpath = "//p[contains(text(),'test.automation05@yahoo.com')]")
    WebElement dpt_upt;
    @FindBy (xpath = "//i[@mattooltip='Update']")
    WebElement dpt_edit;
    
    @FindBy (xpath = "//input[@id='exampleForm2']")
    WebElement dpt_send;

    @FindBy (xpath = "//form[@name='addForm']//div[@class='modal-content']//button[@class='add-btn side_bg'][contains(text(),'Submit')]")
    WebElement dpt_btn;
    
    //Delete Department
    
    @FindBy (xpath = "//div[@class='input-group mb-3 row mar-t-11']//input[@placeholder='Search']")
    WebElement search_dpt;
    
    
    @FindBy (xpath = "//i[@mattooltip='Delete']")
    WebElement del_but;
    
    @FindBy (xpath = "//button[contains(@class,'btndel mat-raised-button')]")
    WebElement del_button;
    
    
	public void AddDepartment_details() throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(3000);
		dep.click();
		Thread.sleep(2000);
		add_dep.click();
		Thread.sleep(2000);
		dept_name.sendKeys("QATestQA");
		Thread.sleep(2000);
		Select sec=new Select(dept_drop);
		sec.selectByVisibleText(prop.getProperty("Employe_id_user01"));
		Thread.sleep(2000);
		dept_button.click();
		Thread.sleep(2000);
		dept_search.sendKeys("QATestQA");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(dpt_upt).perform();
		Thread.sleep(2000);
		dpt_edit.click();
		Thread.sleep(2000);
		dpt_send.sendKeys("1");
		Thread.sleep(2000);
		dpt_btn.click();
		Thread.sleep(2000);
		search_dpt.sendKeys("1");
		Thread.sleep(2000);
		Actions action_1 = new Actions(driver);
		action_1.moveToElement(dpt_upt).perform();
		Thread.sleep(2000);
		del_but.click();
		Thread.sleep(2000);
		del_button.click();
		Thread.sleep(2000);
		

	}
	
}



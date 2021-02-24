package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.doc.qa.base.TestBase;
import com.doc.qa.pages.AddDepartment;
import com.doc.qa.pages.AddEmployee;
import com.doc.qa.pages.HomePage;
import com.doc.qa.pages.LoginPage;
import com.doc.qa.pages.MyFilesPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefinition extends TestBase {

	WebDriver driver;
	LoginPage loginPage;
	MyFilesPage myFilesPage;
	HomePage homepage;

	public LoginStepDefinition() {
		super();
	}

	@Given("^user_enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_and(String id, String password) throws InterruptedException {
		loginPage = new LoginPage();
		// homePage.DicintactHomePage();
		// loginPage.forget_password();
		myFilesPage = loginPage.signin(id, password);
		// myFilesPage = new MyFilesPage();

	}

	@Given("^landing to Application$")
	public void openApplication() throws InterruptedException {
		loginPage = new LoginPage();


	}

	@Then("^change_password$")
public void change_password() throws InterruptedException
	{
		String oldp=prop.getProperty("Individual_password_user01");
		String newp=prop.getProperty("change_password");
		loginPage.change_password(oldp, newp);
	}

	@Then("^re_change_password$")
public void re_change_password() throws InterruptedException
	{
		loginPage.change_password(prop.getProperty("change_password"), prop.getProperty("Individual_password_user01"));
	}

	@Then("^forget_password$")
	public void forget_password() throws InterruptedException, IOException, AWTException
	{
		loginPage = new LoginPage();
		loginPage.forget_password();
	}

	@Then("^Upload New File From Url$")
	public void upload_New_File_From_Url() throws InterruptedException {
		myFilesPage.upload_file_from_URL();

	}

	@Then("^Upload New File From local system$")
	public void Upload_File_From_local_system() throws InterruptedException, AWTException {
		myFilesPage.upload_file_from_local_system();

	}

	@Then("^Upload New folder$")
	public void Upload_Folder_From_local_system() throws InterruptedException, AWTException {
		myFilesPage.upload_folder_from_local_system();

	}

	@Then("^open file and add sign and share to all users(\\d+)$")
	public void open_file_and_add_sign_and_share_to_all_users(int arg1) throws AWTException, InterruptedException {
		myFilesPage.open_file_add_sign_share();

	}

	@Then("^open file and share for review$")
	public void open_file_and_Share_review() throws AWTException, InterruptedException {
		myFilesPage.open_file_Share_for_review();

	}

	@Then("^open shared file and add sign and submit$")
	public void open_shared_file_and_add_sign_and_submit() throws Throwable {
		myFilesPage.open_share_dFile_sign_submit();

	}

    @Then ("^open shared file and review the file$")

	public void open_shared_file_and_review_the_file() throws InterruptedException
	{
		myFilesPage.submit_share_for_review();
	}

	@Given("^user login as individual user_enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_login_as_individual_user_enter_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Verify all pages of navigation$")
	public void verify_all_pages_of_navigation() {
		myFilesPage.navigatePages();

	}

	@Then("^open file and add template$")
	public void open_file_addTemplate() throws InterruptedException
	{
		myFilesPage.addTemplate();
	}

	@Then("^google_login$")
	public void google_login() throws InterruptedException, AWTException, IOException {
		loginPage=new LoginPage();
		loginPage.googlesignin();
	}
	@Then("^facebook_login$")
	public void facebook_login() throws InterruptedException, AWTException, IOException {
		loginPage=new LoginPage();
		loginPage.fb_signin();
	}
	@Then("^twitter_login$")
	public void twitter_login() throws InterruptedException, AWTException, IOException {
		loginPage=new LoginPage();
		loginPage.twitter_signin();
	}


	@Then("^signout$")
	public void signout() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage=new LoginPage();
		loginPage.signout();
	}

	@Then("^Validation Header links in home page$")
	public void validation_links() throws InterruptedException, AWTException {
		HomePage homepage=new HomePage();
		homepage.header_link_validation();
		}

	@Then("^Validation Header links Button in home page$")
	public void button_validation_links() throws InterruptedException, AWTException {
	HomePage homepage=new HomePage();
	homepage.headerlinks_button_validation();
	}

	@Then("^Validation Footer links in home page$")
	public void footer_link_validation() {
		HomePage footer_link =new HomePage();
		footer_link.footer_link_validation();
	}

	@Then("^Add_Employees$")
	public void Add_Employees() throws Throwable {
		AddEmployee addemp=new AddEmployee();
		addemp.submit_employee();
		}

	@Then("^search_Employee$")
	public void Search_Employees() throws Throwable {
		AddEmployee addemp=new AddEmployee();
		addemp.search_emp();
	}

	@Then("^Active_Employee$")
	public void Active_Employee() throws Throwable {
		AddEmployee addemp=new AddEmployee();
		addemp.EmployeeActivation();
	}

	@Then("^Update_Employee and Status_change_Employee$")
	public void Edit_Employee() throws Throwable {
		AddEmployee addemp=new AddEmployee();
		addemp.EditEmployee();
		addemp.Status();
	}

	@Then("^Delete_Employee$")
	public void Delete_Employee() throws Throwable {
		AddEmployee addemp=new AddEmployee();
		addemp.DeleteEmployee();
	}


	@Then("^Add_Department$")
	public void Add_Department() throws InterruptedException {
		AddDepartment adddept = new AddDepartment();
		adddept.AddDepartment_details();

	}

	@Then ("^Right click on the folder and click on share$")
	public void right_click_menu_for_folder() throws InterruptedException {
		myFilesPage.right_click_menu_for_folder();
	}

	@Then ("^Right click on the folder and open the file$")
	public void right_click_menu_for_open() throws InterruptedException {
		myFilesPage.right_click_open_file();
	}

	@Then ("^Right click on the folder and Move to folder$")
	public void right_click_move_folder() throws InterruptedException {
		myFilesPage.move_to_folder_right_click();
	}

	@Then ("^Right click on the folder for upload$")
	public void right_click_file_upload() throws InterruptedException, AWTException {
		myFilesPage.file_upload_right_click();
	}

	@Then ("^Right click on the folder and rename$")
	public void right_click_rename() throws InterruptedException {
		myFilesPage.rename();
	}

	@Then ("^Right click on the folder and delete$")
	public void right_click_delete() throws InterruptedException {
		myFilesPage.delete_right_click();
	}

	@Then("^Favourites_file$")
	public void Favourites_file() throws InterruptedException, AWTException{
		myFilesPage.favouritefile();
//		FavouritesPage fav=new FavouritesPage();
//		fav.favouritefile();
//		fav.verify_homefavourites();
	}

	@Then ("^Remove_favourite_file$")
	public void remove_favourite_file() throws InterruptedException {
		myFilesPage.verify_favourites();

	}

	@Then ("^Create a folder$")
	public void newfolder() throws InterruptedException {
		myFilesPage.newfolder();
	}
	@Then("^open file and add sign and share_organization$")
	public void open_file_and_add_sign_and_share_organization() throws AWTException, InterruptedException {
		myFilesPage.share_organization();
	}

	@Then("^open file and download$")
	public void download_file() throws InterruptedException, AWTException, IOException {

		homepage = new HomePage();
		homepage.document_download();
	}

	@Then("^open file and Verify$")
	public void verify_download_file() throws InterruptedException, AWTException, IOException {

		homepage = new HomePage();
//		homepage.document_download();
		homepage.document_verification();
	}


	@Before
	public void setUP() throws IOException {
		initialization();

	}


	@After
	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
			ConsoleLogs(scenario.getName()); //... to get selenium action -- java console logs
			logBrowserConsoleLogs(scenario.getName()); //... get browser console logs in logs folder
			closeBrowser();
		} else
		{
		closeBrowser();
		}
	}

}

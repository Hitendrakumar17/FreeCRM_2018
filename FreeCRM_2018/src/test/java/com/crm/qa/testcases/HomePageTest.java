package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//Control Shift O - to import
public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	//to call Super Constructor"TestBase constructor and it contains properties will be initialized" using keyword suer()
	public HomePageTest() {
		super();
	}
	
	// Before each test case - launch the browser and login
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test //control shift O to import when there is a red line below that annotation
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page not matching .. "); //if it fails the message will be displayed in the report
	}
	
	//after every test case, close the browser
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}

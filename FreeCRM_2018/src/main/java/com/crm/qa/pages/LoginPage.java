package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// we are using Page Factory approach to create Object Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	// initializing the page objects
	public LoginPage() {
		// this- point to the current class object ie.all objects 
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}

	
	public HomePage login(String un, String psw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(psw);
		
		Thread.sleep(3000);

		/*WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();*/
		loginBtn.click();
		
		return new HomePage();
	}
}

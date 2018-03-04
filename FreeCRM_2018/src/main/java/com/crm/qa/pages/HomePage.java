package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//Page Library and will create TestCase based on this page library for this page
public class HomePage extends TestBase {

	// if this web element is in Frame then you need to switch to frame first and
	// then identify
	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// initializing the page objects
	public HomePage() {
		// this- point to the current class object ie.all objects
		PageFactory.initElements(driver, this);
	}

	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContctsPageLink() throws InterruptedException {
		contactsLink.click();
		Thread.sleep(3000);
		return new ContactsPage();
	}

	public DealsPage clickOnDealsPageLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksPageLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactPage() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}

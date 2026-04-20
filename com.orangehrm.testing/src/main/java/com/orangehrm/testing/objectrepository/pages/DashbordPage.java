package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashbordPage {
	@FindBy(linkText="PIM")
	private WebElement pimLink;
	
	@FindBy(css="[class=\'oxd-userdropdown-tab\']")
	private WebElement logoutDroupDown;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutButton;

	@FindBy(linkText="Recruitment")
	private WebElement recrutmentLink;
	
	@FindBy(css = "[href='/web/index.php/leave/viewLeaveModule']")
	private WebElement leaveLink;
	
	public WebElement getRecrutmentLink() {
		return recrutmentLink;
	}

	public void clickRecrutmentLink() {
		getRecrutmentLink().click();;
	}

	public WebElement getPimLink() {
		return pimLink;
	}

	public void clickPimLink() {
		getPimLink().click();
	}

	public WebElement getLogoutDroupDown() {
		return logoutDroupDown;
	}

	public void clickLogoutDroupDown() {
		getLogoutDroupDown().click();
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void clickLogoutButton() {
		getLogoutButton().click();
	}
	
	public WebElement getLeaveLink() {
		return leaveLink;
	}

	public void dashboardPage() {
		clickPimLink();
		clickLogoutDroupDown();
		clickRecrutmentLink();
	}
	public void logout() {
		clickLogoutDroupDown();
		clickLogoutButton();
	}
	
}

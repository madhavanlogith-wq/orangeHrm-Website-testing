package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage {

	@FindBy(xpath = "//a[contains(text(),'Apply')]")
	WebElement applyBtn;
	
	@FindBy(xpath = "//a[contains(text(),'My Leave')]")
	WebElement myLeaveBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Entitlements')]")
	WebElement EntitlementsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Add Entitlement')]")
	WebElement addEntitlement;
	
	@FindBy(xpath = "//span[contains(text(),'Reports ')]")
	WebElement reportBtn;
	
	@FindBy(xpath = "//a[contains(text(),'My Leave ')]")
	WebElement myLeaveReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Configure')]")
	WebElement configureBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Leave Period')]")
	WebElement leavePeriodBtnOnConfigure;
	
	@FindBy(xpath = "//a[contains(text(),'Leave List')]")
	WebElement leaveListBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Assign Leave')]")
	WebElement assignLeaveBtn;

	public WebElement getApplyBtn() {
		return applyBtn;
	}

	public WebElement getMyLeaveBtn() {
		return myLeaveBtn;
	}

	public WebElement getEntitlementsBtn() {
		return EntitlementsBtn;
	}

	public WebElement getAddEntitlement() {
		return addEntitlement;
	}

	public WebElement getReportBtn() {
		return reportBtn;
	}

	public WebElement getMyLeaveReportBtn() {
		return myLeaveReportBtn;
	}

	public WebElement getConfigureBtn() {
		return configureBtn;
	}

	public WebElement getLeavePeriodBtnOnConfigure() {
		return leavePeriodBtnOnConfigure;
	}

	public WebElement getLeaveListBtn() {
		return leaveListBtn;
	}

	public WebElement getAssignLeaveBtn() {
		return assignLeaveBtn;
	}
	
	
	
	
}

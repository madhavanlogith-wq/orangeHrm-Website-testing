package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeaveListPage {
	WebDriverWait wait;
	@FindBy(xpath = "//label[contains(text(),'From Date')]/parent::div/following-sibling::div//input")
	WebElement fromDate;
	
	@FindBy(xpath = "//label[contains(text(),'To Date')]/parent::div/following-sibling::div//input")
	WebElement toDate;
	
	@FindBy(xpath = "//label[contains(text(),'Show Leave with Status')]/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text oxd-select-text--active']")
	WebElement showLeaveWithStatus;
	
	@FindBy(xpath = "//span[contains(text(),'Rejected')]")
	WebElement rejectedStatusClickable;
	
	@FindBy(xpath = "//span[contains(text(),'Cancelled')]")
	WebElement cancelledStatusClickable;
	
	@FindBy(xpath = "//span[contains(text(),'Scheduled')]")
	WebElement scheduledStatusClickable;
	
	@FindBy(xpath = "//span[contains(text(),'Taken')]")
	WebElement takenStatusClickable;
	
	@FindBy(xpath = "//label[contains(text(),'Leave Type')]/parent::div/following-sibling::div")
	WebElement leaveType;
	
	@FindBy(xpath = "//span[contains(text(),'CAN - FMLA')]") //CAN - FMLA
	WebElement leaveTypeClickable;
	
	@FindBy(xpath = "//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div//input")
	WebElement employeeName;
	
	@FindBy(xpath = "//label[contains(text(),'Sub Unit')]/parent::div/following-sibling::div")
	WebElement subUnit;
	
	@FindBy(xpath = "//span[contains(text(),'Engineering')]") //Engineering
	WebElement subUnitClickable;
	
	@FindBy(css = "[type='submit']")
	WebElement assignBtn;

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getShowLeaveWithStatus() {
		return showLeaveWithStatus;
	}
	
	public WebElement getLeaveType() {
		return leaveType;
	}
	
	public WebElement getLeaveTypeClickable() {
		return leaveTypeClickable;
	}

	public WebElement getEmployeeName() {
		return employeeName;
	}

	public WebElement getSubUnit() {
		return subUnit;
	}
	
	public WebElement getSubUnitClickable() {
		return subUnitClickable;
	}

	public WebElement getAssignBtn() {
		return assignBtn;
	}
	
	// Bussiness Logic ... 
	// Enter From Date
	public void enterFromDate(WebDriver driver, String fromDate) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(getFromDate()));

	    ele.click();
	    ele.sendKeys(Keys.CONTROL + "a");
	    ele.sendKeys(Keys.DELETE);
	    ele.sendKeys(fromDate);
	    ele.sendKeys(Keys.TAB);
	}


	// Enter To Date
	public void enterToDate(WebDriver driver, String toDate) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(getToDate()));

	    ele.click();
	    ele.sendKeys(Keys.CONTROL + "a");
	    ele.sendKeys(Keys.DELETE);
	    ele.sendKeys(toDate);
	    ele.sendKeys(Keys.TAB);
	}


	// Select Leave Status (multi-select safe)
	public void selectShowLeaveStatus(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    String[] arr = {"Rejected","Cancelled","Scheduled","Taken"};

	   
	    for (String status : arr) {
	    	 // Open dropdown (IMPORTANT)
		    wait.until(ExpectedConditions.elementToBeClickable(getShowLeaveWithStatus())).click();

	        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[contains(text(),'" + status + "')]")));
	        ele.click();
	    }
	}


	// Select Leave Type
	public void selectLeaveType(WebDriver driver, String leaveType) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(getLeaveType())).click();

	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[contains(text(),'" + leaveType + "')]")));

	    ele.click();
	}


	// Employee Name
	public void enterEmployeeName(WebDriver driver, String employeeName) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    getEmployeeName().sendKeys(employeeName);

	    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@role='listbox']//span")));

	    option.click();
	}


	// Select SubUnit
	public void selectSubUnit(WebDriver driver, String subUnit) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(getSubUnit())).click();

	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[contains(text(),'" + subUnit + "')]")));

	    ele.click();
	}


	// Click Save (safe)
	public void clickSave(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(getAssignBtn())).click();
	}


	// Verify
	public void verify_emps_filtered(WebDriver driver, String empName) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement record = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@class='oxd-table-body']//div[contains(.,'" + empName + "')]")));

	    Assert.assertTrue(record.isDisplayed(), "Employee not found in filtered result!");
	}

	  
}
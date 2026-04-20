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

import com.orangehrm.seleniumuiframwork_genricutility.AllUtilityFunction;

public class AssginLeavePage {
	@FindBy(xpath = "//label[contains(text(),'Employee Nam')]/parent::div/following-sibling::div/descendant::input")
	WebElement employeeName;
	
	@FindBy(xpath = "//label[contains(text(),'Leave Ty')]/parent::div/following-sibling::div")
	WebElement leaveType;
	
	@FindBy(xpath ="//span[contains(text(),'CAN - FMLA')]" )
	WebElement leaveTypeClickable;
	
	@FindBy(xpath = "//label[contains(text(),'From Date')]/parent::div/following-sibling::div/descendant::input")
	WebElement fromDate;
	
	@FindBy(xpath = "//label[contains(text(),'To Date')]/parent::div/following-sibling::div/descendant::input")
	WebElement toDate;
	
	@FindBy(xpath = "//label[contains(text(),'Partial Day')]/parent::div/following-sibling::div")
	WebElement partialDays;
	
	@FindBy(xpath ="//span[contains(text(),'Start Day Only')]" )
	WebElement startDayOnlyClickable;
	
	@FindBy(xpath = "//label[contains(text(),'Start Day')]/parent::div/following-sibling::div")
	WebElement startDay;
	
	@FindBy(xpath ="//span[contains(text(),'Half Day - Morning')]" )
	WebElement halfDayMorningClickable;
	
	@FindBy(css = "[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	WebElement comments;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement assignBtn;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-toast-content-text')]")
    private WebElement successMsg;

	public WebElement getEmployeeName() {
		return employeeName;
	}
	
	public WebElement getLeaveTypeClickable() {
		return leaveTypeClickable;
	}

	public WebElement getLeaveType() {
		return leaveType;
	}
	
	public WebElement getPartialDays() {
		return partialDays;
	}

	public WebElement getStartDayOnlyClickable() {
		return startDayOnlyClickable;
	}

	public WebElement getStartDay() {
		return startDay;
	}

	public WebElement getHalfDayMorningClickable() {
		return halfDayMorningClickable;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getComments() {
		return comments;
	}

	public WebElement getAssignBtn() {
		return assignBtn;
	}
	
	
	 public WebElement getSuccessMsg() {
		return successMsg;
	}
	 
	// Business Logic

	 public void enterEmployeeName(WebDriver driver, String empName) {
	     
	     WebElement empField = getEmployeeName();
	     empField.clear();
	     empField.sendKeys(empName);
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     AllUtilityFunction.selectDropdownUsingKeyboard(driver, empField, 1);
	 }

	 public void selectLeaveType(WebDriver driver, String leaveType) {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     getLeaveType().click();

	     WebElement ele = wait.until(ExpectedConditions
	             .elementToBeClickable(By.xpath("//span[normalize-space()='" + leaveType + "']")));

	     ele.click();
	 }

	 public void enterFromDate(WebDriver driver, String fromDate) {
	     WebElement ele = getFromDate();
	     ele.click();
	     ele.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	     ele.sendKeys(fromDate);
	     ele.sendKeys(Keys.TAB);
	 }

	 public void enterToDate(WebDriver driver, String toDate) {
	     WebElement ele = getToDate();
	     ele.click();
	     ele.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	     ele.sendKeys(toDate);
	     ele.sendKeys(Keys.TAB);
	 }

	 public void selectPartialDays(WebDriver driver, String partialDays) {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     getPartialDays().click();

	     WebElement element = wait.until(ExpectedConditions
	             .elementToBeClickable(By.xpath("//span[normalize-space()='" + partialDays + "']")));

	     element.click();
	 }

	 public void selectDuration(WebDriver driver, String duration) {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     getStartDay().click();

	     WebElement element = wait.until(ExpectedConditions
	             .elementToBeClickable(By.xpath("//span[normalize-space()='" + duration + "']")));

	     element.click();
	 }

	 public void enterComments(WebDriver driver, String comments) {
	     getComments().clear();
	     getComments().sendKeys(comments);
	 }

	 public void assignLeave() {
	     getAssignBtn().click();
	 }

	 public void verify_leave_assigned(WebDriver driver) {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     WebElement msgEle = wait.until(ExpectedConditions.visibilityOf(getSuccessMsg()));
	     String msg = msgEle.getText();

	     System.out.println("Toast Message: " + msg);

	     Assert.assertTrue(msg.toLowerCase().contains("success"), "Leave not assigned!");

	 }
	 
}
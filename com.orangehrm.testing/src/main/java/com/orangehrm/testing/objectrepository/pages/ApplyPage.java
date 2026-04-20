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

import com.orangehrm.seleniumuiframwork_genricutility.Pages;


public class ApplyPage {
	
	@FindBy(css = "[class='oxd-select-text-input']")
	WebElement leaveType;
	
	@FindBy(xpath = "//label[contains(text(),'From')]/parent::div/following-sibling::div/descendant::input")
	WebElement fromDate;
	
	@FindBy(xpath = "//label[contains(text(),'To')]/parent::div/following-sibling::div/descendant::input")
	WebElement toDate;
	
	@FindBy(xpath = "//label[contains(text(),'Partial')]/parent::div/following-sibling::div")
	WebElement partialDays;
	
	@FindBy(xpath = "//label[contains(text(),'Start')]/parent::div/following-sibling::div")
	WebElement startDay;
	
	@FindBy(css = "[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	WebElement comments;
	
	@FindBy(css = "[type=\"submit\"]")
	WebElement saveApplyBtn;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-toast-content-text')]")
	WebElement success;
	
	@FindBy(css = "[class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement failed;
	
	public WebElement getLeaveType() {
		return leaveType;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}
	
	
	public WebElement getPartialDays() {
		return partialDays;
	}
	
	
	public WebElement getStartDay() {
		return startDay;
	}

	public WebElement getComments() {
		return comments;
	}

	public WebElement getSaveApplyBtn() {
		return saveApplyBtn;
	}
	
	// ----------- Business Logic ----------- //

    public WebElement getSuccess() {
		return success;
	}

	// Select Leave Type
    public void selectLeaveType(WebDriver driver, String type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        leaveType.click();
        
        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + type + "')]")));

        option.click();
       
    }

    // Enter From Date
    public void enterFromDate(WebDriver driver, String from) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(getFromDate()));
        fromDate.clear();
        fromDate.sendKeys(from);
    }

    // Enter To Date
    public void enterToDate(WebDriver driver, String to) {
    	WebElement ele=getToDate();
	    ele.click();
	    ele.sendKeys(Keys.CONTROL + "a");
	    ele.sendKeys(Keys.DELETE);
	    ele.sendKeys(to);
	    ele.sendKeys(Keys.TAB); 
    }

    // Select Partial Days
    public void selectPartialDays(WebDriver driver, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        partialDays.click();

        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + value + "')]")));

        option.click();
    }

    // Select Start Day
    public void selectStartDay(WebDriver driver, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getStartDay().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + value + "')]")))
                .click();
    }

    // Enter Comments
    public void enterComments(String text) {
       
        getComments().sendKeys(text);
    }

    // Click Apply (Save)
    public void clickApply(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(getSaveApplyBtn())).click();
    }
    
    // verify the success msg
    public void isSuccessfullyApplied(WebDriver driver) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//p[contains(@class,'oxd-toast-content-text')]")));

    	    String msg = toast.getText();
    	    System.out.println("Toast Message: " + msg);

    	    Assert.assertTrue(msg.contains("Success"), "Leave not applied!");
    }
    
    
    
}
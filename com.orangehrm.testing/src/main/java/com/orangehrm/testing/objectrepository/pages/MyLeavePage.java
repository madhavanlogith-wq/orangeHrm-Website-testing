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

public class MyLeavePage {
	WebDriverWait wait;
	@FindBy(xpath = "//label[contains(text(),'From')]/parent::div/following-sibling::div/descendant::input")
	WebElement fromDate;
	
	@FindBy(xpath = "//label[contains(text(),'To')]/parent::div/following-sibling::div/descendant::input")
	WebElement toDate;
	
	@FindBy(css =  "['oxd-select-text oxd-select-text--active oxd-select-text--error']")
	WebElement showLeaveStatus;
	
	@FindBy(xpath = "//label[contains(text(),'Leave Type')]/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text oxd-select-text--active']")
	WebElement leaveType;
	
	@FindBy(css = "[type='submit']")
	WebElement searchBtn;

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getShowLeaveStatus() {
		return showLeaveStatus;
	}

	public WebElement getLeaveType() {
		return leaveType;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	

    // ----------- Business Logic ----------- //

    // Enter From Date
    public void enterFromDate(WebDriver driver, String from) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(getFromDate()));
        getFromDate().clear();
        getFromDate().sendKeys(from);
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

    // Select Leave Status (dropdown)
    public void selectLeaveStatus(WebDriver driver, String status) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getShowLeaveStatus().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + status + "')]")))
                .click();
    }

    // Select Leave Type (dropdown)
    public void selectLeaveType(WebDriver driver, String type) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getLeaveType().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + type + "')]")))
                .click();
    }

    // Click Search
    public void clickSearch(WebDriver driver) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(getSearchBtn())).click();
    }
	
    // verify successfully filtered
    public void isEmpLeaveDisplayed(WebDriver driver, String expectedText) {

         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement record = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'" + expectedText + "')]")));

        
        Assert.assertTrue(record.isDisplayed(), "Leave record not displayed!");
    }
}

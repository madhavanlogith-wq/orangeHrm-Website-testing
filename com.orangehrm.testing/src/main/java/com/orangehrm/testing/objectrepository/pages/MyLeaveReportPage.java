package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyLeaveReportPage {
	
	@FindBy(className ="oxd-select-text-input")
	WebElement leavePeriod;
	
	@FindBy(xpath = "//span[contains(text(),'2020-01-01 - 2020-31-12')]")
	WebElement leavePeriodclickable;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement generateBtn;
	
	@FindBy(css =  "[class='oxd-report-table-header--pagination']")
	WebElement records;
	
	public WebElement getLeavePeriod() {
		return leavePeriod;
	}

	public WebElement getLeavePeriodclickable() {
		return leavePeriodclickable;
	}



	public WebElement getGenerateBtn() {
		return generateBtn;
	}
	
	
	
	// bussiness logic ---- //
	
	public WebElement getRecords() {
		return records;
	}

	public void setRecords(WebElement records) {
		this.records = records;
	}

	public void selectLeavePeriod(WebDriver driver,String leavePeriod) {
		getLeavePeriod().click();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+leavePeriod+"')]"));
		ele.click();
	}
	
	public void generated() {
		getGenerateBtn().click();
	}
	
	public void isGenerated(WebDriver driver) {
		Assert.assertTrue(getRecords().isDisplayed(),"not records generated");
	}
}

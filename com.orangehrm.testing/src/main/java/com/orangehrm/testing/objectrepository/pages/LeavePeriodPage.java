package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeavePeriodPage {
	
	@FindBy(xpath = "//label[contains(text(),'Start Month')]/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text oxd-select-text--active']")
	WebElement startMonth;
	
	
	
	@FindBy(xpath = "//label[contains(text(),'Start Date')]/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text oxd-select-text--active']")
	WebElement startDate;
	
	

	@FindBy(css = "[type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//p[contains(@class,'oxd-toast-content-text')]")
	private WebElement successMsg;
	   
	public WebElement getStartMonth() {
		return startMonth;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
    public WebElement getSuccessMsg() {
		return successMsg;
	}
    
     //  Business Logic  ---- //
    public void selectStartMonth(WebDriver driver, String month) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(getStartMonth())).click();

        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + month + "')]")));

        ele.click();
    }


    // Select Start Date
    public void selectStartDate(WebDriver driver, String date) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(getStartDate())).click();

        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + date + "')]")));

        ele.click();
    }


    // Click Save (safe click)
    public void clickSave(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(getSaveBtn())).click();
    }


    // Verify success
    public void verify_leave_period_successfully_saved(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'oxd-toast-content-text')]")));

        String msg = toast.getText();

        System.out.println("Toast Message: " + msg);

        Assert.assertTrue(msg.contains("Success"), "Leave period NOT saved!");
    }
	
}

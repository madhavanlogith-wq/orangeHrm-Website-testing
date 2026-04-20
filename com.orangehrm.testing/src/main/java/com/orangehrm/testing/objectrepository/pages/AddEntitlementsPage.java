package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddEntitlementsPage {

    // ----------- Locators ----------- //

    @FindBy(xpath = "//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div//input")
    private WebElement empName;

    @FindBy(xpath = "//label[contains(text(),'Leave Type')]/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]")
    private WebElement leaveType;

    @FindBy(xpath = "//label[contains(text(),'Leave Period')]/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]")
    private WebElement leavePeriod;

    @FindBy(xpath = "//label[contains(text(),'Entitlement')]/parent::div/following-sibling::div//input")
    private WebElement entitlement;

    @FindBy(css = "button[type='submit']")
    private WebElement saveBtn;

    @FindBy(css =  "[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//p[contains(@class,'oxd-toast-content-text')]")
    private WebElement successMsg;

    public WebElement getEmpName() {
		return empName;
	}


	public WebElement getLeaveType() {
		return leaveType;
	}


	public WebElement getLeavePeriod() {
		return leavePeriod;
	}


	public WebElement getEntitlement() {
		return entitlement;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getConfirmBtn() {
		return confirmBtn;
	}


	public WebElement getSuccessMsg() {
		return successMsg;
	}

	// ----------- Business Logic ----------- //
	// Employee Name (Auto Suggest Dropdown)
    public void enterEmployeeName(WebDriver driver, String employeeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getEmpName().sendKeys(employeeName);

        // Wait for dropdown option
        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span")));

        option.click();
    }


    // Leave Type Dropdown
    public void selectLeaveType(WebDriver driver, String type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getLeaveType().click();

        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + type + "')]")));

        option.click();
    }


    // Leave Period Dropdown
    public void selectLeavePeriod(WebDriver driver, String period) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        getLeavePeriod().click();

        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + period + "')]")));

        option.click();
    }


    // Enter Entitlement
    public void enterEntitlement(String value) {
        getEntitlement().clear();
        getEntitlement().sendKeys(value);
    }


    // Save
    public void clickSave(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait & click Save
        wait.until(ExpectedConditions.elementToBeClickable(getSaveBtn())).click();
        getConfirmBtn().click();
//        // Wait for overlay to disappear or confirm to appear
//        wait.until(ExpectedConditions.visibilityOf(confirmBtn));
//
//        // Click confirm
//        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }


    // Verify Success Message
    public void verifyEntitlementAdded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String msg = wait.until(ExpectedConditions.visibilityOf(successMsg)).getText();

        System.out.println("Toast Message: " + msg);

        Assert.assertTrue(msg.contains("Success"), "Entitlement not added!");
    }
}
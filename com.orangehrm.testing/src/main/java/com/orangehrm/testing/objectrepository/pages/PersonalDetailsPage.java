package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

  
    // ================= LOCATORS =================

    // First Name
    @FindBy(xpath ="//input[@name='firstName']")
    private WebElement firstName;

	// Last Name
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    // Nationality Dropdown
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
    private WebElement nationalityDropdown;

    // Marital Status Dropdown
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[2]")
    private WebElement maritalStatusDropdown;

    // Save Button
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement saveButton;
    
    @FindBy(xpath ="(//p[contains(@class,'oxd-toast-content-text') and contains(text(),'Success')])")
    private WebElement successMessage;

    public WebElement getSuccessMessageElement() {
        return successMessage;
    }



	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getNationalityDropdown() {
		return nationalityDropdown;
	}

	public WebElement getMaritalStatusDropdown() {
		return maritalStatusDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	// ================= ACTION METHODS =================

	public void enterFirstName(String fname) {
	    WebElement ele = getFirstName();
	    ele.click();
	    ele.sendKeys(Keys.CONTROL + "a");
	    ele.sendKeys(Keys.DELETE);
	    ele.sendKeys(fname);
	    ele.sendKeys(Keys.TAB);
	}

	public void enterLastName(String lname) {
	    WebElement ele = getLastName();
	    ele.click();
	    ele.sendKeys(Keys.CONTROL + "a");
	    ele.sendKeys(Keys.DELETE);
	    ele.sendKeys(lname);
	    ele.sendKeys(Keys.TAB);
	}

	public void selectNationality(WebDriver driver, String nationality) {
	    getNationalityDropdown().click();

	    WebElement option = driver.findElement(
	        By.xpath("//span[contains(text(),'" + nationality + "')]")
	    );
	    option.click();
	}

	public void selectMaritalStatus(WebDriver driver, String maritalStatus) {
	    getMaritalStatusDropdown().click();

	    WebElement option = driver.findElement(
	        By.xpath("//span[contains(text(),'" + maritalStatus + "')]")
	    );
	    option.click();
	}

	public void clickSaveButton() {
	    getSaveButton().click();
	}
}

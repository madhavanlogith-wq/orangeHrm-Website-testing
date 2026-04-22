package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

    WebDriver driver;

    // Constructor
    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // First Name
    @FindBy(name = "firstName")
    private WebElement firstName;

	// Last Name
    @FindBy(name = "lastName")
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


    public WebDriver getDriver() {
		return driver;
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
        getFirstName().clear();
        getFirstName().sendKeys(fname);
    }

    public void enterLastName(String lname) {
    	getLastName().clear();
    	getLastName().sendKeys(lname);
    }

    public void clickNationalityDropdown() {
    	getNationalityDropdown().click();
    }

    public void clickMaritalStatusDropdown() {
    	getMaritalStatusDropdown().click();
    }

    public void clickSaveButton() {
    	getSaveButton().click();
    }
}

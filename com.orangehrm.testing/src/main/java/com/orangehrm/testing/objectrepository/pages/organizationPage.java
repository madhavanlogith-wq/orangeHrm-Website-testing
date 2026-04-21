package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


public class organizationPage extends Base {
	
	private WebDriver driver;
	
    public organizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	// ===== NAVIGATION =====

	
	@FindBy(xpath = "//span[text()='Organization ']")
	private WebElement organizationMenu;

	@FindBy(linkText ="Locations")
	private WebElement locationsOption;

	// ===== COMMON BUTTONS =====

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	// ===== LOCATION FORM FIELDS =====

	@FindBy(xpath = "//label[contains(text(),'Name')]/../following-sibling::div//input")
	private WebElement locationNameField;

	@FindBy(xpath = "//label[contains(text(),'Country')]/../following-sibling::div//div[contains(@class,'select-text')]")
	private WebElement countryDropdown;

	@FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Afghanistan')]")
	private WebElement countryOption;

	@FindBy(xpath = "//label[contains(text(),'State')]/../following-sibling::div//input")
	private WebElement stateField;

	@FindBy(xpath = "//label[contains(text(),'City')]/../following-sibling::div//input")
	private WebElement cityField;

	@FindBy(xpath = "//label[contains(text(),'Address')]/../following-sibling::div//textarea")
	private WebElement addressField;

	@FindBy(xpath = "//label[contains(text(),'Zip')]/../following-sibling::div//input")
	private WebElement zipCodeField;

	@FindBy(xpath = "//label[contains(text(),'Phone')]/../following-sibling::div//input")
	private WebElement phoneField;

	@FindBy(xpath = "//label[contains(text(),'Fax')]/../following-sibling::div//input")
	private WebElement faxField;

	// ===== SUCCESS MESSAGE =====

	@FindBy(xpath = "//p[.='Successfully Saved']")
	private WebElement successMessage;

    // ================= GETTER =================


	public WebElement getOrganizationMenu() {
		return organizationMenu;
	}


	public WebElement getLocationsOption() {
		return locationsOption;
	}


	public WebElement getAddButton() {
		return addButton;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getLocationNameField() {
		return locationNameField;
	}


	public WebElement getCountryDropdown() {
		return countryDropdown;
	}


	public WebElement getCountryOption() {
		return countryOption;
	}


	public WebElement getStateField() {
		return stateField;
	}


	public WebElement getCityField() {
		return cityField;
	}


	public WebElement getAddressField() {
		return addressField;
	}


	public WebElement getZipCodeField() {
		return zipCodeField;
	}


	public WebElement getPhoneField() {
		return phoneField;
	}


	public WebElement getFaxField() {
		return faxField;
	}


	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public void setOrganizationMenu() {
		getOrganizationMenu().click();
	}


	public void setLocationsOption() {
		getLocationsOption().click();
	}


	public void setAddButton() {
		getAddButton().click();
	}


	public void setSaveButton() {
		getSaveButton().click();
	}


	public void setLocationNameField(String locationNameField) {
		getLocationNameField().sendKeys(locationNameField);
	}


	public void setCountryDropdown() {
		getCountryDropdown().click();
	}


	public void setCountryOption() {
		getCountryOption().click();
	}


	public void setStateField(String stateField) {
		getStateField().sendKeys(stateField);
	}


	public void setCityField(String cityField) {
		getAddressField().sendKeys(cityField);
	}


	public void setAddressField(String addressField) {
		getAddressField().sendKeys(addressField);
	}
	public void setSuccessMessage(String successMessage) {
		getSuccessMessage();
	}



}

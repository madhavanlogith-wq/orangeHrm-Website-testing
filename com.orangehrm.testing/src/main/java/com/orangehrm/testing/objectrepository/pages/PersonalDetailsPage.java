package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.seleniumuiframwork_genricutility.Base;

public class PersonalDetailsPage extends Base {

    private WebDriver driver;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= NAVIGATION =================

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsTab;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private WebElement emergencyContactsTab;

    // ================= FORM FIELDS =================

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
    private WebElement nationalityDropdown;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[2]")
    private WebElement maritalStatusDropdown;

    @FindBy(xpath = "//label[.='Gender']/../../../../../..//button")
    private WebElement saveButton;
    
//    @FindBy(xpath = "//span[text()='Required']")
//    private WebElement firstNameError;
    
    @FindBy(name = "firstName")
    private WebElement firstNameError;

    // ================= GETTERS =================

    public WebElement getFirstNameError() {
		return firstNameError;
	}
    
    public boolean isFirstNameErrorDisplayed() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(firstNameError));

        return firstNameError.isDisplayed();
    }

	public WebElement getMyInfoMenu() {
        return myInfoMenu;
    }

    public WebElement getContactDetailsTab() {
        return contactDetailsTab;
    }

    public WebElement getEmergencyContactsTab() {
        return emergencyContactsTab;
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

    // ================= ACTION METHODS (SET METHODS STYLE) =================

    public void setMyInfoMenu() {
        getMyInfoMenu().click();
    }

    public void setContactDetailsTab() {
        getContactDetailsTab().click();
    }

    public void setEmergencyContactsTab() {
        getEmergencyContactsTab().click();
    }

    public void setFirstName(String fname) {
        getFirstName().clear();
        getFirstName().sendKeys(fname);
    }

    public void setLastName(String lname) {
        getLastName().clear();
        getLastName().sendKeys(lname);
    }

    public void setNationalityDropdown() {
        getNationalityDropdown().click();
    }

    public void setMaritalStatusDropdown() {
        getMaritalStatusDropdown().click();
    }

    public void setSaveButton() {
        getSaveButton().click();
    }

  
    public void name_first_last(String fname,String lname) {
    	setFirstName(fname);
    	setLastName(lname);
	}
    
    public void clearFirstName() {
        getFirstName().clear();
        getFirstName().sendKeys(Keys.TAB); // 🔥 triggers validation
    }
    
}
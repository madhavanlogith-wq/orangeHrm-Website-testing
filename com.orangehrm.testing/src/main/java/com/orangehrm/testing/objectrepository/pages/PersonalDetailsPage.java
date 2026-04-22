package com.orangehrm.testing.objectrepository.pages;


import org.openqa.selenium.By;

import java.time.Duration;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


  
    // ================= LOCATORS =================
//
//    // First Name
//    @FindBy(xpath ="//input[@name='firstName']")
//    // Last Name
//    @FindBy(xpath = "//input[@name='lastName']")

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


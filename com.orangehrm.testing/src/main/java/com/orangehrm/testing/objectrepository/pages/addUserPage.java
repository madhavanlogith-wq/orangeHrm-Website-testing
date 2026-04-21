package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


public class addUserPage extends Base{
	
	private WebDriver driver;
	
    public addUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath = "//button[.=' Add ']")
    private WebElement addButtonUser;
	
	 @FindBy(xpath = "(//div[.='-- Select --'])[4]")
	    private WebElement roledroupdown;
	 
    @FindBy(xpath = "//div[.='ESS']")
    private WebElement selectRole;

    @FindBy(css = "[placeholder=\"Type for hints...\"]")
    private WebElement employeeNameTextField;

    @FindBy(xpath = "//label[.='Status']/../..//div[.='-- Select --']")
    private WebElement ststusTextField;

    @FindBy(xpath = "//span[.='Enabled']")
    private WebElement enabledOption;

    @FindBy(xpath = "(//input[@autocomplete='off'])[1]")
    private WebElement usernameTextField;

    @FindBy(xpath = "(//input[@autocomplete='off'])[2]")
    private WebElement passwordTextField;

    @FindBy(xpath = "(//input[@autocomplete='off'])[3]")
    private WebElement confirmPasswordTextField;
    
    @FindBy(xpath = "(//p['Successfully Saved'])[7]")
    private WebElement verifyUserAdded;
    
    @FindBy(xpath = "//span[.='Job ']")
    private WebElement navigateJob;
    

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    // ================= GETTER =================

	

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getAddButtonUser() {
		return addButtonUser;
	}

	public WebElement getRoledroupdown() {
		return roledroupdown;
	}

	public WebElement getSelectRole() {
		return selectRole;
	}

	public WebElement getEmployeeNameTextField() {
		return employeeNameTextField;
	}

	public WebElement getStstusTextField() {
		return ststusTextField;
	}
	
	public WebElement getEnabledOption() {
		return enabledOption;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getVerifyUserAdded() {
		return verifyUserAdded;
	}

	public WebElement getNavigateJob() {
		return navigateJob;
	}

	public void setAddButtonUser() {
		getAddButtonUser().click();
	}

	public void setRoledroupdown() {
		getRoledroupdown().click();
	}

	public void setSelectRole() {
		getSelectRole().click();
	}

	public void setEmployeeNameTextField(String employeeNameTextField) {
		WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(3));

	    // Step 1: Enter employee name
	    WebElement empField = getEmployeeNameTextField();
	    wait.until(ExpectedConditions.visibilityOf(empField)).sendKeys(employeeNameTextField);

	    // Step 2: Wait for suggestion and click
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[@role='option']//span[contains(text(),'" + employeeNameTextField + "')]")
	    ));

	    option.click();
	}

	public void setStstusTextField() {
		getStstusTextField().click();
	}

	public void setEnabledOption() {
		getEnabledOption().click();
	}

	public void setUsernameTextField(String usernameTextField) {
		getUsernameTextField().sendKeys(usernameTextField);
	}

	public void setPasswordTextField(String passwordTextField) {
		getPasswordTextField().sendKeys(passwordTextField);
	}

	public void setConfirmPasswordTextField(String confirmPasswordTextField) {
		getConfirmPasswordTextField().sendKeys(confirmPasswordTextField);
	}

	public void setVerifyUserAdded() {
		getVerifyUserAdded();
	}


	public void setSaveButton() {
		getSaveButton().click();
	}


}

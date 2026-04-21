package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


public class pimAddEmpPage extends Base{
	
	private WebDriver driver;
	
    public pimAddEmpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	

    @FindBy(xpath = "//button[.=' Add ']")
	private WebElement addButton ;
	
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName ;
	
	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div//input")
	private WebElement type;

	
	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[.='Required']")
	private WebElement verifyError;


	public WebElement getVerifyError() {
		return verifyError;
	}


	public WebElement getAddButton() {
		return addButton;
	}


	public WebElement getFirstName() {
		return firstName;
	}


	public WebElement getMiddleName() {
		return middleName;
	}


	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getType() {
		return type;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	@FindBy(xpath= "//p[.='Successfully Saved']")
	  private WebElement getVerify;


	  public WebElement getGetVerify() {
		  return getVerify;
	  }


	  public void setAddButton() {
		  getAddButton().click();
	  }


	  public void setFirstName(String firstName) {
		  getFirstName().sendKeys(firstName);
	  }


	  public void setMiddleName(String middleName) {
		  getMiddleName().sendKeys(middleName);
	  }


	  public void setLastName(String lastName) {
		  getLastName().sendKeys(lastName);
	  }


	  public void setType(String type) {
		  getType().sendKeys(type);
	  }


	  public void setSaveButton() {
		  getSaveButton().click();
	  }


	  public void setVerifyError(String verifyError) {
		  getVerifyError().getText();
	  }


	  public void setGetVerify(String getVerify) {
		  getGetVerify().getText();
	  }
	
	  @FindBy(className = "oxd-form-loader")
	  private WebElement loader;

	  public void clickSaveButton() {
		  getSaveButton().click();
	  }

	  public String getSuccessMessage() {
	      return getVerify.getText();
	  }

}

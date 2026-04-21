package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


public class addJobTitlePage extends Base{
	
private WebDriver driver;
	
    public addJobTitlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//  ==Job page navigation==
    
  @FindBy(xpath = "//span[text()='Job ']")
  private WebElement jobMenu;

  @FindBy(linkText = "Job Titles")
  private WebElement jobTitlesOption;
  
  @FindBy(xpath = "//button[.=' Add ']")
  private WebElement addButtonjob;

  // ===== JOB TITLE FIELDS =====
  
  @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//input")
  private WebElement jobTitleField;

  @FindBy(css = "[placeholder='Type description here']")
  private WebElement jobDescriptionField;

  @FindBy(xpath = "//textarea[@placeholder=\"Add note\"]")
  private WebElement noteField;
  
  @FindBy(css = "[class='oxd-file-div oxd-file-div--active']")
  private WebElement job_Specification;
  
  
  @FindBy(xpath= "//button[.=' Save ']")
  private WebElement saveJobTitle;
  
  @FindBy(xpath= "//p[.='Successfully Saved']")
  private WebElement verifyjob;


  public WebElement getVerifyjob() {
	return verifyjob;
}

  public WebElement getJobMenu() {
	return jobMenu;
  }


  public WebElement getJobTitlesOption() {
	return jobTitlesOption;
  }


  public WebElement getAddButtonjob() {
	return addButtonjob;
  }


  public WebElement getJobTitleField() {
	return jobTitleField;
  }



  public WebElement getJobDescriptionField() {
	return jobDescriptionField;
  }


  public WebElement getNoteField() {
	return noteField;
  }


  public WebElement getJob_Specification() {
	return job_Specification;
  }


  public WebElement getSaveJobTitle() {
	return saveJobTitle;

  }
  public void setJobMenu() {
		getJobMenu().click();
}


  public void setJobTitlesOption() {
		getJobTitlesOption().click();
  }


  public void setAddButtonjob() {
		getAddButtonjob().click();
  }


  public void setJobTitleField(String dataTable) {
	  getJobTitleField().sendKeys(dataTable);
  }


  public void setJobDescriptionField(String jobDescriptionField) {
	 getJobDescriptionField().sendKeys(jobDescriptionField);
  }


  public void setNoteField(String noteField) {
	  getNoteField().sendKeys(noteField);
  }


  public void setJob_Specification(String job_Specification) {
	  String filePath = System.getProperty("user.dir") + "/src/test/resources/" + job_Specification;

	    getJob_Specification().sendKeys(filePath);
  }


  public void setSaveJobTitle() {
	  getSaveJobTitle().click();
  }

  }


package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentsPage {

    WebDriver driver;

    // Constructor
    public DependentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================
    
    

    // Add Button
    @FindBy(linkText = "Dependents")
    private WebElement DependentsButton;
    
    public WebElement getDependentsButton() {
		return DependentsButton;
	}

	public void setDependentsButton() {
		getDependentsButton().click();
	}

	// Add Button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    // Name Field
    @FindBy(xpath = "//div[normalize-space()='Name']//input")
    private WebElement name;

    // Relationship Dropdown
    @FindBy(xpath = "//div[normalize-space()='Relationship']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement relationshipDropdown;

    // Save Button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    // ================= ACTION METHODS =================

    public void clickAddButton() {
        addButton.click();
    }

    public void enterName(String value) {
        name.clear();
        name.sendKeys(value);
    }

//    // 🔥 Dropdown Handling (IMPORTANT)
//    public void selectRelationship(String relation) {
//        relationshipDropdown.click();
//        driver.findElement(By.xpath("//span[text()='" + relation + "']")).click();
//    }

    public void clickSaveButton() {
        saveButton.click();
    }

    // ================= GETTERS (for Wait usage) =================

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getRelationshipDropdown() {
        return relationshipDropdown;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
    public void selectRelationship(String relation) {
        getRelationshipDropdown().click();
        driver.findElement(By.xpath("//span[text()='" + relation + "']")).click();
    }
}
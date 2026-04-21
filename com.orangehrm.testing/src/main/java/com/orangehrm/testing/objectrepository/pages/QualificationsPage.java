package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationsPage {

    WebDriver driver;

    // Constructor
    public QualificationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // 🔥 Work Experience Add Button (important - specific)
    @FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
    private WebElement addButton;

    // Company Field
    @FindBy(xpath = "//div[normalize-space()='Company']//input")
    private WebElement company;

    // Job Title Field
    @FindBy(xpath = "//div[normalize-space()='Job Title']//input")
    private WebElement jobTitle;

    // Save Button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    // ================= ACTION METHODS =================

    public void clickAddButton() {
        addButton.click();
    }

    public void enterCompany(String value) {
        company.clear();
        company.sendKeys(value);
    }

    public void enterJobTitle(String value) {
        jobTitle.clear();
        jobTitle.sendKeys(value);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    // ================= GETTERS (for wait usage) =================

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getJobTitle() {
        return jobTitle;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
}

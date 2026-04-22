package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage {

    WebDriver driver;

    // Constructor
    public EmergencyContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // 🔥 IMPORTANT
    }
    // ================= LOCATORS =================

    // Add Button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    // Name
    @FindBy(xpath = "//div[normalize-space()='Name']//input")
    private WebElement name;

    // Relationship
    @FindBy(xpath = "//div[normalize-space()='Relationship']//input")
    private WebElement relationship;

    // Mobile
    @FindBy(xpath = "//div[normalize-space()='Mobile']//input")
    private WebElement mobile;

    // Save Button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    // ================= GETTERS =================

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getRelationship() {
        return relationship;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    // ================= ACTION METHODS =================

    public void clickAddButton() {
        getAddButton().click();
    }

    public void enterName(String n) {
        getName().sendKeys(n);
    }

    public void enterRelationship(String r) {
        getRelationship().sendKeys(r);
    }

    public void enterMobile(String m) {
        getMobile().sendKeys(m);
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }
}
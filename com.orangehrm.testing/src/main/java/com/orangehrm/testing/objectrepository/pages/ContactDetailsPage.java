package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {

    WebDriver driver;

    // Constructor
    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Street 1
    @FindBy(xpath = "//div[normalize-space()='Street 1']//input")
    private WebElement street1;

    // City
    @FindBy(xpath = "//div[normalize-space()='City']//input")
    private WebElement city;

    // Mobile
    @FindBy(xpath = "//div[normalize-space()='Mobile']//input")
    private WebElement mobile;

    // Work Email
    @FindBy(xpath = "//div[normalize-space()='Work Email']//input")
    private WebElement workEmail;

    // Save Button (Best Locator)
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    
    @FindBy(xpath ="(//p[contains(@class,'oxd-toast-content-text') and contains(text(),'Success')])")
    private WebElement successMessage;

   

    // ================= GETTERS =================
    
    
    
    
    public WebElement getSuccessMessageElement() {
        return successMessage;
    }

    public WebElement getStreet1() {
        return street1;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getWorkEmail() {
        return workEmail;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    // ================= ACTION METHODS =================

    public void enterStreet1(String value) {
        street1.click();
        street1.sendKeys(Keys.CONTROL + "a");
        street1.sendKeys(Keys.DELETE);
        street1.sendKeys(value);
    }

    public void enterCity(String value) {
        city.click();
        city.sendKeys(Keys.CONTROL + "a");
        city.sendKeys(Keys.DELETE);
        city.sendKeys(value);
    }


    public void enterMobile(String value) {
        mobile.click();
        mobile.sendKeys(Keys.CONTROL + "a");
        mobile.sendKeys(Keys.DELETE);
        mobile.sendKeys(value);
    }

    public void enterWorkEmail(String value) {
        workEmail.click();
        workEmail.sendKeys(Keys.CONTROL + "a");
        workEmail.sendKeys(Keys.DELETE);
        workEmail.sendKeys(value);
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }
}
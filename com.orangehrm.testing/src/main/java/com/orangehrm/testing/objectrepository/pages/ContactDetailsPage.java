package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(css = "[type='submit']")
    private WebElement saveButton;
    
    @FindBy(xpath = "//p[.='Success']")
    private WebElement toastMessage;

    // ================= GETTERS =================

    public WebElement getToastMessage() {
		return toastMessage;
	}
    public String getToastMessageText() {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(toastMessage))
                .getText();
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
        getStreet1().clear();
        getStreet1().sendKeys(value);
    }

    public void enterCity(String value) {
        getCity().clear();
        getCity().sendKeys(value);
    }

    public void enterMobile(String value) {
        getMobile().clear();
        getMobile().sendKeys(value);
    }

    public void enterWorkEmail(String value) {
        getWorkEmail().clear();
        getWorkEmail().sendKeys(value);
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }
   
//    public void clickSaveButton() {
//
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(getSaveButton()))
//                .click();
//    }
}
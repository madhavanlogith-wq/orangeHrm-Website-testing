package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Submit_Claim {

    WebDriver driver;
    WebDriverWait wait;

    public Submit_Claim(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== LOCATORS =====

    @FindBy(xpath = "//span[normalize-space()='Claim']")
    WebElement claimMenu;

    @FindBy(xpath = "//a[contains(text(),'Submit Claim')]")
    WebElement submitClaim;

    @FindBy(xpath = "//label[contains(text(),'Event')]/parent::div/following-sibling::div")
    WebElement eventDropdown;

    @FindBy(xpath = "//label[contains(text(),'Currency')]/parent::div/following-sibling::div")
    WebElement currencyDropdown;

    @FindBy(xpath = "//textarea")
    WebElement remarksArea;

    @FindBy(xpath = "//button[contains(.,'Create')]")
    WebElement createButton;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    WebElement submitButton;
    
//    @FindBy(xpath = "//p[contains(@class,'oxd-toast-content-text')]/parent::div[contains(@class,'oxd-toast-content') and contains(@class,'oxd-toast-content--success')]")
//    WebElement successMsg;
    
    By successMsg = By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p");

    // ===== ACTIONS =====

    public void openClaimModule() {
        wait.until(ExpectedConditions.elementToBeClickable(claimMenu)).click();
    }

    public void openSubmitClaimTab() {
        wait.until(ExpectedConditions.elementToBeClickable(submitClaim)).click();
    }

    public void selectEvent(String event) {
        wait.until(ExpectedConditions.elementToBeClickable(eventDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + event + "']")
        )).click();
    }

    public void selectCurrency(String currency) {


        // now click dropdown
        wait.until(ExpectedConditions.elementToBeClickable(currencyDropdown)).click();

        // select value
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + currency + "']")
        )).click();
    }

    public void enterRemarks(String remark) {
        wait.until(ExpectedConditions.visibilityOf(remarksArea)).sendKeys(remark);
    }

    public void clickCreate() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        wait.until(ExpectedConditions.invisibilityOf(submitButton));
    }
    
    public void waitForSubmission() {

        wait.until(ExpectedConditions.or(
            ExpectedConditions.invisibilityOf(submitButton),
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(.,'Cancel')]")
            )
        ));
    }


    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement msgElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p")
            )
        );

        return msgElement.getText();
    }
    }

    

package com.orangehrm.testing.objectrepository.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class My_Claims {

    WebDriver driver;
    WebDriverWait wait;

    public My_Claims(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    
    // ===== LOCATORS =====

    @FindBy(xpath = "//a[normalize-space(text())='My Claims']")
    WebElement myclaimstab;

    @FindBy(xpath = "//label[contains(text(),'Reference Id')]/ancestor::div//input[contains(@placeholder,'Type for hints...')]")
    WebElement inputfield;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement searchbtn;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text oxd-table-cell-action-space']")
    WebElement view;

    // ===== ACTION METHODS =====

    public void openMyClaims() {
        wait.until(ExpectedConditions.elementToBeClickable(myclaimstab)).click();
    }

    public void enterReferenceId(String refId) {
        wait.until(ExpectedConditions.visibilityOf(inputfield)).sendKeys(refId);
    }

    public void selectReferenceFromDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(inputfield)).sendKeys(Keys.ARROW_DOWN);
        inputfield.sendKeys(Keys.ENTER);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
    }

    public void clickView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By viewBtn = By.xpath("//button[contains(@class,'oxd-table-cell-action-space')]");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(viewBtn));
        button.click();
    }
}

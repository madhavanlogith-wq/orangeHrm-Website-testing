package com.orangehrm.testing.objectrepository.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Project_Info {

    WebDriver driver;
    WebDriverWait wait;

    public Project_Info(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================
    @FindBy(xpath = "//span[normalize-space()='Time']")
    WebElement timeMenu;

    @FindBy(xpath = "//span[normalize-space()='Project Info']")
    WebElement projectInfoSection;

    @FindBy(xpath = "//a[normalize-space()='Projects']")
    WebElement projectTab;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addProjectBtn;

    @FindBy(xpath = "//label[contains(text(),'Name')]/parent::div/following-sibling::div/descendant::input[@class='oxd-input oxd-input--active']")
    WebElement projectNameInput;

    @FindBy(xpath = "//label[contains(text(),'Customer')]/parent::div/following-sibling::div/descendant::input")
    WebElement customerNameInput;

    @FindBy(xpath = "//div[@role='option']")
    List<WebElement> customerOptions;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement saveBtn;

    @FindBy(xpath = "//p[contains(@class,'toast-message')]")
    WebElement successMsg;

    // ================= ACTION METHODS =================

    public void navigateToProjectInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(timeMenu)).click(); // 🔥 ADD
        wait.until(ExpectedConditions.elementToBeClickable(projectInfoSection)).click();
    }

    public void clickProjectTab() {
        wait.until(ExpectedConditions.elementToBeClickable(projectTab)).click();
    }

    public void clickAddProject() {
        wait.until(ExpectedConditions.elementToBeClickable(addProjectBtn)).click();
    }

    public void enterProjectName(String name) {
        wait.until(ExpectedConditions.visibilityOf(projectNameInput)).clear();
        projectNameInput.sendKeys(name);
    }

    public void selectCustomer(String customer) {

        wait.until(ExpectedConditions.elementToBeClickable(customerNameInput)).click();

        customerNameInput.sendKeys(customer);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='FreeWave Technologies, Inc.']")
        )).click();
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
    public String getSuccessMessage() {

        By toast = By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p");

        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(toast));

        return msg.getText();
    }
//    public String getSuccessMessage() {
//        return wait.until(ExpectedConditions.visibilityOf(successMsg)).getText();
//    }
}
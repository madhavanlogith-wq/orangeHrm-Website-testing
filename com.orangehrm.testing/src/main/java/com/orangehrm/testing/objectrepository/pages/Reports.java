package com.orangehrm.testing.objectrepository.pages;


import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Reports {

    WebDriver driver;
    WebDriverWait wait;

    public Reports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================
    @FindBy(xpath = "//span[normalize-space()='Time']")
    WebElement timeMenu;

    @FindBy(xpath = "//span[normalize-space()='Reports']")
    WebElement reportsSection;

    @FindBy(xpath = "//a[normalize-space()='Project Reports']")
    WebElement projectReports;

    @FindBy(xpath = "//button[contains(.,'View')]")
    WebElement viewButton;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement reqMsg;

    // ================= ACTION METHODS =================

    public void openReportsSection() {
        wait.until(ExpectedConditions.elementToBeClickable(timeMenu)).click(); // 🔥 ADD
        wait.until(ExpectedConditions.elementToBeClickable(reportsSection)).click();
    }

    public void openProjectReports() {
        wait.until(ExpectedConditions.elementToBeClickable(projectReports)).click();
    }

    public void clickView() {
        wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
    }

    // ================= ASSERTION =================

    public String getRequiredMessage() {
        wait.until(ExpectedConditions.visibilityOf(reqMsg));
        return reqMsg.getText();
    }
}

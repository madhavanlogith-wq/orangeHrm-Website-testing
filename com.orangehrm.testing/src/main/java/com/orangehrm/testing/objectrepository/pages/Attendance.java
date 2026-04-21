package com.orangehrm.testing.objectrepository.pages;


import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Attendance {

    WebDriver driver;
    WebDriverWait wait;

    public Attendance(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[normalize-space()='Time']")
    WebElement timeMenu;

    @FindBy(xpath = "//span[contains(text(),'Attendance')]")
    WebElement attendanceSection;

    @FindBy(xpath = "//a[normalize-space()='Punch In/Out']")
    WebElement punchPage;

    // ✅ FIXED LOCATOR (TEXT BASED = STABLE)
    @FindBy(xpath = "//button[contains(.,'In')]")
    WebElement punchInBtn;
    
    @FindBy(xpath = "//p[contains(@class,'toast-message')]")
    WebElement successMsg;

    public void openTimeModule() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[normalize-space()='Time']")
        )).click();
    }

    public void openAttendanceSection() {
        openTimeModule();   // 🔥 ADD THIS LINE
        wait.until(ExpectedConditions.elementToBeClickable(attendanceSection)).click();
    }

    public void openPunchSection() {
        openTimeModule();   // 🔥 ADD
        wait.until(ExpectedConditions.elementToBeClickable(attendanceSection)).click(); // 🔥 ADD
        wait.until(ExpectedConditions.elementToBeClickable(punchPage)).click();
    }

    public void clickPunchIn() {

        // wait for loader to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//div[contains(@class,'oxd-form-loader')]")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(punchInBtn)).click();
    }
    
    public String getSuccessMessage() {
        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p")
            ));

            return msg.getText().trim();

        } catch (Exception e) {
            return "";
        }
    }
    }

//	public String getSuccessMessage() {
//		return wait.until(ExpectedConditions.visibilityOf(successMsg)).getText();
//	}


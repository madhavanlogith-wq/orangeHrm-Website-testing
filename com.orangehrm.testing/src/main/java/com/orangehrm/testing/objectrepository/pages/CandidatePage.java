package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandidatePage {

    WebDriver driver;

    public CandidatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Type here']")
    WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchBox;

    @FindBy(xpath = "//div[@role='row']//div[3]")
    WebElement resultName;

    @FindBy(xpath = "//span[contains(text(),'Required')]")
    WebElement errorMsg;

    public void addCandidate(String fn, String ln, String em) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // wait until form is loaded (ONLY ONCE)
        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        email.sendKeys(em);

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public void searchAndSelectCandidate(String name) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // clear & search
        System.out.println("Searching for: " + name);
        searchBox.clear();
        searchBox.sendKeys(name);
        Thread.sleep(2000);

        // wait & click result (using first name to be safe)
        String firstName = name.split(" ")[0];

        WebElement result = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='row']//div[contains(text(),'" + firstName + "')]")
            )
        );
       
        Thread.sleep(2000);
        result.click();
        Thread.sleep(2000);
    }

    public String getResult() {
        return resultName.getText();
    }
    

    public void clickSave() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for loader to disappear (important)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("oxd-form-loader")
        ));

        // Scroll to button (fix hidden click issue)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);

        // Wait again until clickable
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

        // Click using JS (final fix for intercept issue)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
    }
    

    public String getError() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Required') or contains(text(),'Invalid')]")
                )
            );

            return error.getText();
        } catch (Exception e) {
            return "NO_ERROR_FOUND";
        }
    }
    
    
    public void enterFirstName(String fn) {
        firstName.sendKeys(fn);
    }

    public void enterLastName(String ln) {
        lastName.sendKeys(ln);
    }

    public void enterEmail(String em) {
        email.sendKeys(em);
    }
}
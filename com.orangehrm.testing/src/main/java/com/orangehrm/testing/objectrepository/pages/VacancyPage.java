package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacancyPage {

	WebDriver driver;

	public VacancyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Vacancies']")
	WebElement vacancyTab;

	@FindBy(xpath = "//button[contains(.,'Add')]")
	WebElement addBtn;

	@FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	WebElement jobTitleDropdown;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement hiringManager;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//label[text()='Vacancy']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	WebElement vacancyDropdown;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@role='row']//div[2]")
	WebElement result;

	@FindBy(xpath = "//span[contains(text(),'Required')]")
	WebElement errorMsg;

	public void goToVacancy() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement vacancy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Vacancies']")));

		vacancy.click();
	}

	public void clickAdd() {
		addBtn.click();
	}

	public void searchAndSelectVacancy(String name) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    System.out.println("STEP: Searching vacancy = " + name);

	    // Click dropdown
	    WebElement dropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(vacancyDropdown)
	    );
	    dropdown.click();

	    // Select option
	    WebElement option = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[@role='listbox']//span[text()='" + name + "']")
	        )
	    );
	    option.click();

	    // Click search
	    wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

	    // ✅ FIXED PART (row selection)
	    WebElement row = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]")
	        )
	    );
	    row.click();
	}

	public String getResult() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // FIRST wait for correct page
	    wait.until(ExpectedConditions.urlContains("viewJobVacancy"));

	    // THEN find element
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]")
	    ));

	    return element.getText();
	}

	public String getError() {
		return errorMsg.getText();
	}

	public void addVacancy(String vacancyName, String job, String manager) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement vacancyField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//label[text()='Vacancy Name']/../following-sibling::div//input")));
	    vacancyField.clear();
	    vacancyField.sendKeys(vacancyName);

	    selectJobTitle(job);
	    selectHiringManager(manager);

	    // ❌ DO NOT CLICK SAVE HERE
	}

	public void selectJobTitle(String job) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// open dropdown
		wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdown)).click();

		// select value
		WebElement option = driver.findElement(By.xpath("//span[text()='" + job + "']"));

		option.click();
	}

	public void selectHiringManager(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement input = hiringManager;

		input.click();
		input.clear();
		input.sendKeys(name);

		WebElement option = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@role='option']//span[contains(text(),'" + name + "')]")));

		option.click();
	}

}
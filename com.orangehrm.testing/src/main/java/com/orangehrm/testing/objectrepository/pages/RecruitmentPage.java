package com.orangehrm.testing.objectrepository.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    WebElement recruitmentMenu;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addBtn;

    public void goToRecruitment() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement recruitment = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Recruitment']")
            )
        );

        recruitment.click();
    }

    public void clickAdd() {
        addBtn.click();
    }
}
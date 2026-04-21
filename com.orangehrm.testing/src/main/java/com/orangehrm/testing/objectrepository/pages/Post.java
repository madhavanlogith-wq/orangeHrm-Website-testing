package com.orangehrm.testing.objectrepository.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Post {

	 WebDriver driver;
	    WebDriverWait wait;

	    public Post(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
    @FindBy(xpath = "//a[@href='/web/index.php/buzz/viewBuzz']")
    WebElement buzz;

    @FindBy(xpath = "//textarea[contains(@class,'oxd-buzz-post-input')]")
    WebElement textField;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--main')]")
    WebElement postButton;

    public void openBuzzPage() {
        wait.until(ExpectedConditions.elementToBeClickable(buzz)).click();
    }
    
    public String getLatestPostText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//p[contains(@class,'orangehrm-buzz-post-body-text')])[1]")
        ));

        return post.getText();
    }

    public void enterText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea[contains(@class,'oxd-buzz-post-input')]")
            )
        );

        field.clear();
        field.sendKeys(text);
    }

   
    	public void clickPost() {

    	    By postBtnLocator = By.xpath("//button[contains(@class,'oxd-button--main')]");

    	    wait.until(ExpectedConditions.refreshed(
    	            ExpectedConditions.elementToBeClickable(postBtnLocator)
    	    )).click();
    	}
    

    public boolean clickPostAndValidateSuccess() {

        postButton.click();

        // capture immediately (no wait, no delay)
        List<WebElement> toast = driver.findElements(
            By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p[normalize-space()='Success']")
        );

        return !toast.isEmpty();
    }
}

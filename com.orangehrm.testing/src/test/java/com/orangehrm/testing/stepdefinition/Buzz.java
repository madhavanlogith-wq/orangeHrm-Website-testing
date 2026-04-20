package com.orangehrm.testing.stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangeHRM.seleniumuiframwork_genricutility.Pages;

public class Buzz {

    WebDriver driver;
    Pages pages;

    public Buzz() {
        this.driver = Hook.getDriver();
        this.pages = new Pages(driver);
    }

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application() {
        System.out.println("User already logged in via Hook");
    }

    @When("user is on buzz page")
    public void user_is_on_buzz_page() {
        pages.post.openBuzzPage();
    }

    @When("user enters {string}")
    public void user_enters(String text) {
        pages.post.enterText(text);
    }

    @When("user clicks post")
    public void user_clicks_post() {
        pages.post.clickPost();
    }

    @Then("post should be created successfully")
    public void post_should_be_created_successfully() {

        String postText = pages.post.getLatestPostText();

        Assert.assertTrue(
            postText != null && !postText.isEmpty(),
            "Post not created successfully or post is empty"
        );
    }
}
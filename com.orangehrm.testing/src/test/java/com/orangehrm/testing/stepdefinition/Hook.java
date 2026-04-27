package com.orangehrm.testing.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.orangehrm.seleniumuiframwork_genricutility.AllUtilityFunction;
import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends AllUtilityFunction {

    private Base base;
    private Pages pages;

    public Hook(Base base) {
        this.base = base;
    }

    // 🔥 COMMON METHOD
    public void launchAndLogin(String username, String password) throws IOException {

        WebDriver driver = new EdgeDriver();   // ✅ create local

        Base.setDriver(driver);                // ✅ store in ThreadLocal

        String URL = getPropertyValue("url");

        configMaximizedBrowser(driver);
        implicit(driver);

        driver.get(URL);

        pages = new Pages(driver);             // ✅ thread-safe pages
        pages.loginpage.loginPage(username, password);
    }

    @Before("@Admin")
    public void setupAdmin() throws IOException {
        initProperties("src/main/resources/commondate.properties");
        launchAndLogin(getPropertyValue("username"), getPropertyValue("password"));
    }

    @Before("@Login_as_employee")
    public void setupEmployee() throws IOException {
        initProperties("src/main/resources/commondate.properties");
        launchAndLogin("virat", "virat@123");
    }

    // ✅ SCREENSHOT FOR ALL SCENARIOS
    @io.cucumber.java.AfterStep
    public void afterEachStep(Scenario scenario) {

        // 🛑 Only take screenshot if step/scenario failed
        if (!scenario.isFailed()) {
            return;
        }

        WebDriver driver = Base.getDriver();

        try {
            if (driver != null) {

                TakesScreenshot ts = (TakesScreenshot) driver;

                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

                String fileName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp;

                String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
                File directory = new File(screenshotDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String fullPath = screenshotDir + fileName + ".png";

                File src = ts.getScreenshotAs(OutputType.FILE);
                File dest = new File(fullPath);

                Files.copy(src.toPath(), dest.toPath());

                // ✅ Extent Report
                String relativePath = "screenshots/" + fileName + ".png";
                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(relativePath);

                // ✅ Cucumber Report
                byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", fileName);
            }

        } catch (Exception e) {
            System.out.println("Step Screenshot failed: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
        WebDriver driver = Base.getDriver();

        if (driver != null) {
            driver.quit();
            Base.unload(); // very important
        }
    }
}
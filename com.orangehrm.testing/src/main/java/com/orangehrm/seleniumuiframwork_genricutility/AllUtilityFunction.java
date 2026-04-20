package com.orangehrm.seleniumuiframwork_genricutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllUtilityFunction {
	WebDriver driver; 
	Properties properties; 
	public AllUtilityFunction() {
		
	}
	// JAVA UTILITY
		// Generate Random Numbers
		public int getRandomNumber(int range) {
			Random random = new Random();
			int randomNumberInRange = random.nextInt(range);
			return randomNumberInRange;
		}

		// Generate Current Date
		public String getCurrentDate(String dateFormat) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.format(date);
		}

		// counting Days
		public String getRequiredDate(int days) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			sdf.format(date);
			Calendar cal = sdf.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String requiredDate = sdf.format(cal.getTime());
			return requiredDate;
		}

		// Generate Random Value(Alphanumeric)
		public String getRandomValue() {
			UUID randomData = UUID.randomUUID();
			String value = randomData.toString().replaceAll("[^a-zA-Z]", "");
			return value;
		}

		// Manage
		// Maximize
		public void configMaximizedBrowser(WebDriver driver) {
			driver.manage().window().maximize();
		}

		// Minimize
		public void configMinimizedBrowser(WebDriver driver) {
			driver.manage().window().minimize();
		}

		// fullScreen
		public void configFullScreenBrowser(WebDriver driver) {
			driver.manage().window().fullscreen();
		}

		// get size
		public Dimension fetchBrowserSize(WebDriver driver) {
			Dimension dimension = driver.manage().window().getSize();
			return dimension;
		}

		// set Size
		public void configBrowserSize(int width, int height, WebDriver driver) {
			driver.manage().window().setSize(new Dimension(width, height));
		}

		// close
		public void closingBrowserTab(WebDriver driver) {
			driver.close();
		}

		// quit
		public void closingBrowserWindow(WebDriver driver) {
			driver.quit();
		}

		// timeouts
		// implicitWait
		public void implicit( WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// Read
		public String getPropertyKeyvalue(String key) throws IOException {
			FileInputStream fis = new FileInputStream("./src/test/resources/commanddata.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;

		}
		
		// drop down using action
		public static void selectDropdownUsingKeyboard(WebDriver driver, WebElement dropdown, int index) {

		    Actions actions = new Actions(driver);

		    // Step 1: Click dropdown
		    dropdown.click();

		    // Step 2: Loop through options using ARROW_DOWN
		    for (int i = 0; i < index; i++) {
		        actions.sendKeys(Keys.ARROW_DOWN);
		    }

		    // Step 3: Press ENTER to select
		    actions.sendKeys(Keys.ENTER).perform();
		}
		
		// properties file management
		
		// 1 initialize properies
		public void initProperties(String FILE_PATH) throws IOException {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			properties = new Properties();
			properties.load(fis);
			fis.close();
		}
		
		// 2 . get the value of the key
		public String getPropertyValue(String key) {
			return properties.getProperty(key);
		}
}

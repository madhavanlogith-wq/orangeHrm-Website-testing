package com.orangehrm.testing.objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.seleniumuiframwork_genricutility.Base;


public class PimCusDataPage extends Base{
	
	private WebDriver driver;
	
    public PimCusDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//span[.='Configuration ']")
	private WebElement configurationMenu ;
	
	@FindBy(xpath = "//a[contains(text(),'Custom')]")
	private WebElement customField ;
	
	@FindBy(xpath = "//button[.=' Add ']")
	private WebElement addButton ;
	
	@FindBy(xpath = "//label[contains(text(),'Field')]/parent::div/following-sibling::div/descendant::input")
	private WebElement fieldName ;
	
	@FindBy(xpath = "//label[contains(text(),'Screen')]/parent::div/following-sibling::div")
	private WebElement screen;
	
	@FindBy(xpath = "//span[contains(text(),'Personal Details')]")
	private WebElement screenDroupDown;
	
	@FindBy(xpath = "//label[contains(text(),'Type')]/parent::div/following-sibling::div")
	private WebElement type;

	@FindBy(xpath = "//span[contains(text(),'Text or Number')]")
	private WebElement typeDroupDown;
	
	@FindBy(xpath = "//label[contains(text(),'Select Options')]/parent::div/following-sibling::div")
	private WebElement typeSelectOption;
	
	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//p[.='Successfully Saved']")
	private WebElement verifyCusDara;
	

	
	public WebElement getVerifyCusDara() {
		return verifyCusDara;
	}

	public WebElement getType() {
		return type;
	}
	
	public WebElement getConfigurationMenu() {
		return configurationMenu;
	}

	public WebElement getCustomField() {
		return customField;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getFieldName() {
		return fieldName;
	}

	public WebElement getScreen() {
		return screen;
	}

	public WebElement getScreenDroupDown() {
		return screenDroupDown;
	}

	public WebElement getTypeDroupDown() {
		return typeDroupDown;
	}

	public WebElement getTypeSelectOption() {
		return typeSelectOption;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setConfigurationMenu() {
		getConfigurationMenu().click();
	}

	public void setCustomField() {
		getCustomField().click();
	}

	public void setAddButton() {
		getAddButton().click();
	}

	public void setFieldName(String fieldName) {
		getFieldName().sendKeys(fieldName);
	}

	public void setScreen() {
		getScreen().click();
	}

	public void setScreenDroupDown() {
		getScreenDroupDown().click();
	}

	public void setType() {
		getType().click();
	}

	public void setTypeDroupDown() {
		getTypeDroupDown().click();
		}

	public void setTypeSelectOption(String typeSelectOption) {
		getTypeSelectOption().sendKeys(typeSelectOption);
	}

	public void setSaveButton() {
		getSaveButton().click();
	}


	


	
	
}
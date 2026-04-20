package com.orangehrm.testing.objectrepository.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
    //UserName TextField
	@FindBy(name="username")
	private WebElement userName;
	
	//password TextFild
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(css="[type=\'submit\']")
	private WebElement logIn;

	@FindBy(xpath ="//p[.='Forgot your password? ']")
	private WebElement forgetPassword ;
	
	@FindBy(xpath="[href=\'https://www.linkedin.com/company/orangehrm/mycompany/\']")
	private WebElement linkedinLink ;
	
	@FindBy(xpath="[href=\'https://www.facebook.com/OrangeHRM/\']")
	private WebElement facebookLink;
	
	@FindBy(xpath="[href=\"https://twitter.com/orangehrm?lang=en\"]")
	private WebElement twitterLink ;
	
	@FindBy(xpath="[href=\"https://www.youtube.com/c/OrangeHRMInc\"]")
	private WebElement youtubeLink;
	
	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		getUserName().sendKeys(userName);
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		getPassWord().sendKeys(passWord);
	}

	public WebElement getLogIn() {
		return logIn;
	}

	public void setLogIn() {
		getLogIn().click();
	}

	public WebElement getForgetPassword() {
		return forgetPassword;
	}

	public void setForgetPassword(String forgetPassword) {
		getForgetPassword().sendKeys(forgetPassword);
	}

	public WebElement getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink() {
		getLinkedinLink().click();
	}

	public WebElement getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink() {
		getFacebookLink().click();
	}

	public WebElement getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink() {
		getTwitterLink().click();
	}

	public WebElement getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink() {
		getYoutubeLink().click();
	}

	public void loginPage(String userName,String passWord) {
		setUserName(userName);
		setPassWord(passWord);
		setLogIn();
	}

	
}


package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtils;


//No assertions should be written in the page only in test class/step definitions

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: Object Repos
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	private ElementUtils elementUtils;

	// 2. Constructor of the page class
	public LoginPage() {

		elementUtils = new ElementUtils();

	}

	public void clickOnLogin() {
		elementUtils.click(signInButton);
	}

	// 2. Page actions: Features of the page in the form of methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void enterMandatoryFields() {
		
		
		
	}
}

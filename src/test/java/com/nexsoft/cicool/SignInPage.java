package com.nexsoft.cicool;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	protected WebDriver driver;
	// tanpa page factory
//	private By email = By.xpath("//input[@placeholder='Email']");
//	private By password = By.xpath("//input[@placeholder='Password']");
//	private By btnSignIn = By.xpath("//button[@type='submit']");

	// dengan page factory
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignIn;
	
	@FindBy(css = "div[class='callout callout-error']")
	private WebElement errorPassword;
	
	@FindBy(css = "a[href='http://localhost:80/cicool/administrator/forgot-password']")
	private WebElement btnForgetPassword;
	
	@FindBy(css = ".login-box-msg")
	private WebElement forgetPasswordPrompt;

	public SignInPage(WebDriver driver) {

		this.driver = driver;

	}

	// tanpa page factory
//	public Dashboard loginValidUser(String username, String user_password) {
//		
//		driver.findElement(email).clear();
//		driver.findElement(email).sendKeys(username);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(user_password);
//		driver.findElement(btnSignIn).click();
//		
//		return new Dashboard(driver);
//		
//	}

	public Dashboard loginValidUser(String username, String user_password) {

		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		
		return dashboard;

	}
	
	public String getErrorPassword() {
		
		return errorPassword.getText();
		
	}
	
	public void clickForgetPassword() {
		
		btnForgetPassword.click();
		
	}
	
	public String forgetPasswordMsg() {
		
		return forgetPasswordPrompt.getText();
		
	}
}

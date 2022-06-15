package com.nexsoft.cicool;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	// tanpa page factory
//	private By signIn = By.xpath("//a[@class='page-scroll']");
//	private By languageSetting = By.xpath("//a[@class='dropdown-toggle']");

	// dengan page factory
	@FindBy(xpath = "//a[@class='page-scroll']")
	private WebElement signIn;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement languageSetting;

	@FindBy(xpath = "//a[@class='page-scroll dropdown-toggle']")
	private WebElement btnProfile;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement btnLogout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// tanpa page factory
//	public SignInPage clickSignIn() {
//		driver.findElement(signIn).click();
//		
//		return new SignInPage(driver);
//	}

	// dengan page factory
	public SignInPage clickSignIn() {
		signIn.click();

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

		return signInPage;
	}

	public void logout() {
		
		btnProfile.click();
		btnLogout.click();
		
	}

}

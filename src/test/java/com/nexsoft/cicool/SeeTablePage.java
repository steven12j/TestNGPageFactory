package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeTablePage {

	WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	private WebElement addTableNew;
	
	public SeeTablePage(WebDriver driver) {

		this.driver = driver;

	}
	
	public AddTableNewPage clickAddTableNew() {
		addTableNew.click();
		
		AddTableNewPage addTableNewPage = PageFactory.initElements(driver, AddTableNewPage.class);
		
		return addTableNewPage;
	}
	
	
	
	
	
}

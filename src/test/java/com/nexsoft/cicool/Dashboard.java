package com.nexsoft.cicool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	protected WebDriver driver;
	
	@FindBy(xpath = "//i[contains(@class,'fa fa-table')]")
	private WebElement crudBuilder;
	
	@FindBy(xpath = "//span[@class='hidden-xs']")
	private WebElement username;
	
	public Dashboard(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public CRUDBuilderPage clickCrudBuilder() {
		crudBuilder.click();
		
		CRUDBuilderPage crudBuilderPage = PageFactory.initElements(driver, CRUDBuilderPage.class);
		
		return crudBuilderPage;
	}
	
	public String getUsername() {
		
		return username.getText();
	}
	
}

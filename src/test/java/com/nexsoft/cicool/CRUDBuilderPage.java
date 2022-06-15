package com.nexsoft.cicool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRUDBuilderPage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//tbody[@id='tbody_crud']/tr")
	List<WebElement> lstTable;
	
	@FindBy(xpath = "//i[@class='fa fa-plus-square-o']")
	private WebElement addCrudNew;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]")
	private WebElement seeTable1;
	
	public CRUDBuilderPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public SeeTablePage clickSeeButtonWithTitle(String title) {
		WebElement see = null;
		
		for(WebElement webElement : lstTable) {
			
			see = webElement.findElement(By.xpath("//td/a[1]"));
			WebElement teks = webElement.findElement(By.xpath("//td[2]"));
			
			if(teks.getText().equalsIgnoreCase(title)) {
				see.click();
				break;
			}
			
		}
		
		SeeTablePage seeTablePage = PageFactory.initElements(driver, SeeTablePage.class);
		
		return seeTablePage;
	}
	
	public NewCrudPage clickAddCrudNew() {
		addCrudNew.click();
		
		NewCrudPage newCrudPage = PageFactory.initElements(driver, NewCrudPage.class);
		
		return newCrudPage;
		
	}
	
	
}

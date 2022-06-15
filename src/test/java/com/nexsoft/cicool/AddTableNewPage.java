package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTableNewPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='nama']")
	private WebElement addNama;
	
	@FindBy(xpath = "//input[@id='alamat']")
	private WebElement addAlamat;
	
	@FindBy(xpath = "//input[@id='telepon']")
	private WebElement addTelepon;
	
	@FindBy(xpath = "//a[@id='btn_save']")
	private WebElement btnSave;
	
	public AddTableNewPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public SeeTablePage inputTable(String nama, String alamat, String telepon) {

		addNama.sendKeys(nama);
		addAlamat.sendKeys(alamat);
		addTelepon.sendKeys(telepon);
		btnSave.click();

		SeeTablePage tableNew = PageFactory.initElements(driver, SeeTablePage.class);
		
		return tableNew;

	}
	
}

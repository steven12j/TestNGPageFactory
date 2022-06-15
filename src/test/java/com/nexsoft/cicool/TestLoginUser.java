package com.nexsoft.cicool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginUser {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void testLogIn() {
		//tanpa page factory
//		HomePage home = new HomePage(driver);
		
		//dengan page factory
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		formSignIn.loginValidUser("steven12jaya@gmail.com", "testcicool");
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		CRUDBuilderPage crudBuilderPage = dashboard.clickCrudBuilder();
		SeeTablePage seeTablePage = crudBuilderPage.clickSeeButtonWithTitle("member");
		AddTableNewPage addTableNewPage = seeTablePage.clickAddTableNew();
		addTableNewPage.inputTable("sti", "tangsel", "081211777777");
//		seeTable1Page.clickAddTableNew();
//		inputTableNew.inputTable1("sta", "tangerang", "08121155555");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dashboard.clickCrudBuilder();
//		crudBuilderPage.clickAddCrudNew();
	}
	
//	@Test (priority = 1)
//	public void testToCRUDBuilder() {
//		
//		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
//		CRUDBuilderPage crudBuilderPage = dashboard.clickCrudBuilder();
//		
//	}
}

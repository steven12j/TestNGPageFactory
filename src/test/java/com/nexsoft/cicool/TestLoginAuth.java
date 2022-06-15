package com.nexsoft.cicool;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginAuth {

	protected WebDriver driver;
	
	@BeforeMethod
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(System.getProperty("url"));
	}
	
//	@BeforeMethod
//	public void cekSession() {
//		
//		
//		//cek session user telah login atau belum
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		
//		home.clickSignIn().loginValidUser("steven12jaya@gmail.com", "testcicool");
//		
//		driver.get(System.getProperty("url"));
//		
//		home.logout();
//		
//	}
	
	@Test(priority = 1)
	public void testLogInValid() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		Dashboard dashboard = formSignIn.loginValidUser("steven12jaya@gmail.com", "testcicool");
		
		Assert.assertEquals(dashboard.getUsername(), "Steven12jaya");

		driver.close();
	}
	
	@Test(priority = 2)
	public void testLogInEmailValidPasswordInvalid() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		Dashboard dashboard = formSignIn.loginValidUser("steven12jaya@gmail.com", "test");
		
		Assert.assertEquals(formSignIn.getErrorPassword(), "Error.!\nE-mail Address and Password do not match.");
		
		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true, "Text tidak ditemukan" + e.getMessage());
		}
		
		driver.close();
	}
	
	@Test(priority = 3)
	public void testLogInEmailPasswordInvalid() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		Dashboard dashboard = formSignIn.loginValidUser("steven12@gmail.com", "testcicool");
		
		Assert.assertEquals(formSignIn.getErrorPassword(), "Error.!\nUser does not exist");
		
		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true, "Text tidak ditemukan" + e.getMessage());
		}
		
		driver.close();
	}
	
	@Test(priority = 4)
	public void testLogInEmailPasswordBlank() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		Dashboard dashboard = formSignIn.loginValidUser("", "");
		
		Assert.assertEquals(formSignIn.getErrorPassword(), "Error.!\nThe Username field is required.\nThe Password field is required.");
		
		driver.close();
	}
	
	@Test(priority = 5)
	public void testForgetPassword() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage formSignIn = home.clickSignIn();
		formSignIn.clickForgetPassword();
		
		Assert.assertEquals(formSignIn.forgetPasswordMsg(), "Send a link to reset the password");
		
		driver.close();
	}
	
}

package com.SetUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='i0116']")
	static WebElement username;

	@FindBy(xpath = "//input[@id='i0118']")
	static WebElement password;

	@FindBy(xpath = "//input[@id='idSIButton9']")
	static WebElement login;

	public void setUserName(String strUserName) {

		username.sendKeys(strUserName);
	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	public void loginToAzureDevOps(String strUserName, String strPasword) throws InterruptedException {

		this.setUserName(strUserName);
		this.clickLogin();
		
		Thread.sleep(2000);

		this.setPassword(strPasword);
		this.clickLogin();
		
		Thread.sleep(2000);
		
		this.clickLogin();
	}
}

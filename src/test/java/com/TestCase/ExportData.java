package com.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SetUp.BaseClass;
import com.SetUp.FilterPage;
import com.SetUp.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExportData extends BaseClass {
	static String baseurl = getProperty("url");
	static String organizationName = getProperty("organizationName");
	static String projectName = getProperty("projectName");
	static String FilterID = getProperty("FilterID");
	String username = getProperty("username");
	String password = getProperty("password");

	public static String queryURL = baseurl + "/" + organizationName + "/" + projectName + "/" + "_queries/query/"
			+ FilterID + "/";

	@Test
	public void exportDataFromQuery() throws InterruptedException {

		//System.out.println(queryURL);
		driver.get(queryURL);
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		FilterPage filter = PageFactory.initElements(driver, FilterPage.class);

		login.loginToAzureDevOps(username, decryptData(password));
		waitForPageToLoad(60);
		
		filter.clickRunBtn();
		wait(5000);
		
		filter.clickIconBtn();
		wait(2000);
		filter.clickExportToCSV();
		wait(1000);

	}
}

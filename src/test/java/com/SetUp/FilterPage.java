package com.SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage {

	WebDriver driver;

	public FilterPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//span[normalize-space()='Run query']")
	static WebElement runQueryBtn;

	@FindBy(xpath = "//button[@id='CommandBar3overflow']//i[@role='presentation']")
	static WebElement icon;

	@FindBy(xpath = "//span[normalize-space()='Export to CSV']")
	static WebElement exportToCSV;

	public void clickRunBtn() {

		runQueryBtn.click();

	}

	public void clickIconBtn() {

		icon.click();

	}

	public void clickExportToCSV() {

		exportToCSV.click();

	}
	
}

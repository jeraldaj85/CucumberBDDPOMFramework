package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;



public class ElementUtils implements UtilitiesInterface {

	protected WebDriver driver;

	public ElementUtils() {
		driver = DriverFactory.getDriver();
	}

	@Override
	public WebElement getElement(By locator) {
		if (!isElementPresent(locator)) {
			System.out.println("Element not Present, " + locator);
		}
		if (!isElementVisible(locator)) {
			System.out.println("Element not Visible, " + locator);
		}
		return driver.findElement(locator);
	}

	@Override
	public Boolean isElementPresent(By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Boolean isElementVisible(By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void click(By Locator) {
		try {
			getElement(Locator).click();

		} catch (Exception e) {
			System.out.println("Click failure occured, "+Locator);
		}
	}

}

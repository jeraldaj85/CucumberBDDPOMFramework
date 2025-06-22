package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface UtilitiesInterface {
	
	WebElement getElement(By locator);
	Boolean isElementPresent(By Locator);
	Boolean isElementVisible(By Locator);
	void click(By Locator);



}

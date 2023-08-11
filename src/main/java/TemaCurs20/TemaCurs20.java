package TemaCurs20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs20 extends BaseTest{
	
	/*
	 * Scriem un script care va cauta pe site cartea “The story about me”
 Si va plasa o comanda cu ea.
 Vom folosi doar CssSelector a identifica elementele
 Pasii sunt urmatorii:
 1. Cautam in search bar titlul cartii mentionate
	 * 
	 */

	@Test
	public void cautareCarte() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement searchBar = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", 
				searchBar);
	}
}

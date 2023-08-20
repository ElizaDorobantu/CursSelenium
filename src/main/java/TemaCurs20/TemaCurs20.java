package TemaCurs20;

import static org.testng.Assert.assertTrue;

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
 Dupa ce o gasim (atentie ca nu este pe prima pagina de 
rezultate!), vom da click pe ea

	 * 
	 */

	@Test
	public void cautareCarte() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement searchButton = driver.findElement(By.cssSelector("div[class='menu_main_wrap'] button[class*='search_submit']"));
		searchButton.click();
		searchButton.sendKeys( "The story about me");
		searchButton.submit();
			
		WebElement loadMore = driver.findElement(By.cssSelector("a[id='viewmore_link']"));
		while (loadMore.isDisplayed()) {
			loadMore.click();
			Thread.sleep(2000);	
		}
			WebElement book = driver.findElement(By.cssSelector(
					"a[href='https://keybooks.ro/shop/the-story-about-me/']:first-of-type"));
		assertTrue(book.isDisplayed());

	}
}

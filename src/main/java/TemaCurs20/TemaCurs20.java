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

Pe pagina de produs verificam url ca este matching cu 
https://keybooks.ro/shop/the-story-about-me/

Apoi, apasam pe add to cart si verificam daca ne apare textul cu 
added to cart

	 * 
	 */

	@Test
	public void cautareCarte() throws InterruptedException {
		
		WebElement searchButton = driver.findElement(By.cssSelector("button[class*='search_submit']"));
		searchButton.click();
		WebElement searchField = driver.findElement(By.cssSelector(
				"div[class='menu_main_wrap'] input[class*='search_field']"));
		searchField.sendKeys( "The story about me");
		searchButton.click();
			
		WebElement loadMore = driver.findElement(By.cssSelector("a[class*='theme_button']"));
		while (loadMore.isDisplayed()) {
			loadMore.click();
			Thread.sleep(2000);
			try { WebElement book = driver.findElement(By.cssSelector(
					"a[href='https://keybooks.ro/shop/the-story-about-me/']:first-of-type"));
			book.click();
			
			break;
			}
			catch(Exception exceptie) {
			}
			
			Thread.sleep(1000);	
		}
		
		String currentURL = driver.getCurrentUrl();
		String expectesURL = "https://keybooks.ro/shop/the-story-about-me/";
		assertTrue(currentURL.equals(expectesURL));
		
		WebElement addToCart = driver.findElement(By.cssSelector(
				"button[class*='single_add_to_cart_button']"));
		addToCart.click();
		
		WebElement addToCartMessage = driver.findElement(By.cssSelector(
				"div[class='woocommerce-message']"));
		String currentMessage=addToCartMessage.getText();
		System.out.println(currentMessage);
		String expectedMessage = " “The story about me” has been added to your cart.	";
		
		assertTrue(currentMessage.contains(expectedMessage));
	}
}

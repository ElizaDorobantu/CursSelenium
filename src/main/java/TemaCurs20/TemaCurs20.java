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

Dupa verificarea textului, apasam pe View Cart si validam ca ne duce pe URL : 
https://keybooks.ro/cart/

De aici pentru ce se intampla in cart facem o metoda noua @Test

In noua metoda @Test vom face update de cantitate pentru carte la 2

Verificam mesajul dupa update

Apasam pe Proceed to checkout

 In noul screen verificam URL ca este egal cu :https://keybooks.ro/checkout/
 Verificam daca ne apare textul Biling details si Aditional information
	 * 
	 */

	@Test(priority=1)
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
		String expectedURL = "https://keybooks.ro/shop/the-story-about-me/";
		assertTrue(currentURL.equals(expectedURL));
		
		WebElement addToCart = driver.findElement(By.cssSelector(
				"button[class*='single_add_to_cart_button']"));
		addToCart.click();
		
		WebElement addToCartMessage = driver.findElement(By.cssSelector(
				"div[class='woocommerce-message']"));
		String currentMessage=addToCartMessage.getText();
		System.out.println(currentMessage);
		String expectedMessage = " “The story about me” has been added to your cart.	";
		
		
		
		//assertTrue(currentMessage.contains(expectedMessage)); //verificarea aceasta nu merge
		//gaseste VIEW CART �The story about me� has been added to your cart.
		//nu stiu cum sa extrag doar �The story about me� has been added to your cart 
		
		WebElement viewCart = driver.findElement(By.cssSelector(
				"div[class='woocommerce-message']>a[class='button wc-forward']"));
		viewCart.click();		
		
		currentURL = driver.getCurrentUrl();
		expectedURL = "https://keybooks.ro/cart/";
		assertTrue(currentURL.equals(expectedURL));
		
	}
	
	@Test(priority=2)
	public void updateCart() {
		WebElement quantity = driver.findElement(By.cssSelector(
				"input[class='input-text qty text']"));
		quantity.clear();
		quantity.sendKeys("2");
		WebElement updateCart = driver.findElement(By.cssSelector(
				"button[class='button'][name='update_cart']"));
		updateCart.click(); 
		
		WebElement mesaj = driver.findElement(By.cssSelector(
				"div[class='woocommerce-message']"));
		String currentMessage=mesaj.getText();
		String expectedMessage="Cart updated.";
		assertTrue(currentMessage.equals(expectedMessage));
		
		WebElement proceedToCheckout = driver.findElement(By.cssSelector(
				"a[class*='checkout-button']"));
		proceedToCheckout.click();
		
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		String expectedURL="https://keybooks.ro/checkout/";
		assertTrue(currentURL.equals(expectedURL));
		
		WebElement billingDetails = driver.findElement(By.cssSelector(
				"div[class*='woocommerce-billing-fields']>h3"));
		System.out.println(billingDetails.getText());
		assertTrue(billingDetails.getText().equals("Billing details"));
		
		WebElement additionalFields = driver.findElement(By.cssSelector(
				"div[class*='woocommerce-additional-fields']>h3"));
		System.out.println(additionalFields.getText());
		assertTrue(additionalFields.getText().equals("Additional information"));
		
		
	}
}

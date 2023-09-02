package TemaCurs21;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

/*
 *  Scriem un script care are urmatorii pasi Folosim doar css selectors:
 Deschide keybooks.ro
 Deschide pagina unei carti (oricare)
 In partea de jos a paginii deschide sectiunea de Review

Assert pe checkbox ca nu este selectat

Apasam pe butonul Submit si tratam Alerta JS care apare

 Completam toate detallile din review
 
 Assert pe checkbox ca este este selectat


Apasam Submit

Facem assert ca ne apare textul : “Your review is awaiting approval"

 * 
 */

public class TemaCurs21 extends BaseTest{

	@Test
	public void metoda() throws InterruptedException {
	WebElement carte = driver.findElement(By.cssSelector("div[id='sc_tab_1456822345_1_17'] a[href='the-son']"));
	carte.click();
	
	WebElement review=driver.findElement(By.cssSelector("a[href='#tab-reviews']"));
	review.click();
	
	WebElement checkboxReview = driver.findElement(By.cssSelector("input[id='wp-comment-cookies-consent']"));
	assertFalse(checkboxReview.isSelected());
	
	
	
	WebElement submit = driver.findElement(By.cssSelector("p[class='form-submit'] input[name='submit']"));
	submit.click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	
	WebElement stars = driver.findElement(By.cssSelector("p[class='stars'] a[class='star-4']"));
	stars.click();
	
	WebElement comment = driver.findElement(By.cssSelector("textarea[id='comment']"));
	comment.sendKeys("text");
	
	WebElement name = driver.findElement(By.cssSelector("input[id='author']"));
	name.sendKeys("Eliza");
	
	WebElement email = driver.findElement(By.cssSelector("input[id='email']"));
	email.sendKeys("eliza@db.com");
	
	checkboxReview.click();
	assertTrue(checkboxReview.isSelected());
	
	
	submit.click();
	WebElement mesaj = driver.findElement(By.cssSelector("em[class='woocommerce-review__awaiting-approval']"));
	assertEquals(mesaj.getText(),"Your review is awaiting approval");
	}	
}

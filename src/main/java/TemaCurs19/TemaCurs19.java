package TemaCurs19;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs19 extends BaseTest{
/*
 * Vom face un script care verifica daca cartea The Forest se afla in cele 4
categorii din pagina principala si daca linkul cartii ne deschide pagina de
produs cand ajungem in ultima categorie.
 * Scriptul are 1 metoda @Test
 1. Elementele meniului le vom identifica pe baza attributului class “sc_tabs_title” si
vom crea o lista cu ele.
 2. Vom itera lista cu un for si vom da click pe fiecare element al listei astfel incat sa
trecem prin toate cele 4 categorii
 3. In fiecare dintre categorii vom face o verificare, din care sa stim daca cartea
mentionata mai sus este displayed.
 4. Cand ajungem la ultimul element al listei, vom da click pe carte si vom verifica
daca ne face redirect catre URL-ul : “https://keybooks.ro/shop/the-forest/”
 * 
 */
	
	@Test
	public void carteTheForest() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		List<WebElement> menu = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')",
				menu.get(2));
		
		
		for(WebElement element: menu) {
			jse.executeScript("arguments[0].setAttribute('style', 'background: pink; border:4px solid blue')", 
					element);
			
			element.click();
			Thread.sleep(2000);
			//WebElement the Forest= driver.findElement(By.cssSelector(
			//"div[aria-hidden='false'] a[href='the-forest']");
			
			/*
			 * 
			 * List<WebElement> categoryTabs = driver.findElements(By.cssSelector("sc_tabs_title"));
			 * 
			 * WebElement theForest = driver.findElement(By.cssSelector("div[aria-hidden ='false'] a[href='the-forest']"));
			 * for(WebElement element : categoryTabs){
			 * 	
			 * 	element.click();
			 *  theForest.isDisplayed();
			 * 
			 * }
			 * 
			 * theForest.click();
			 * ---assert
			 * 
			 * 
			 * if (i==categoryTabs.lenght()-1
			 */
			WebElement carte = driver.findElement(By.cssSelector(
					"div[class*='sc_columns'] a[href*='the-forest']"));
			jse.executeScript("arguments[0].setAttribute('style', 'background: green; border:4px solid blue')", 
					carte);

			assertTrue(carte.isDisplayed());
			
			Thread.sleep(2000);
			if (element.getText().equals("AWARD WINNERS")) {
				carte.click();
				Thread.sleep(2000);
				assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-forest/");
			}
			
		}
		
		//carte.click();
		
		
	}
}

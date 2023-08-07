package curs18;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SeleniumLocators extends BaseTest{

	/*
	 * Locatori:
	 * tagName
	 * linkText
	 * partialLinkText
	 * id
	 * name
	 * class name
	 * xpath 
	 * Css Selector
	 * 
	 * 
	 * DOM=document object model
	 */
	
	//rulam SeleniumLocator se apeleaza public static void main in spate si verifica dc exista 
	//metode cu tag Before si after
	//intai ruleaza metodele cu before apoi restul metodelor si la sfarsit metodele cu after
	
	@Test(priority=1)
	public void tagNameLocator() {
	
		WebElement discoverText = driver.findElement(By.tagName("em"));
		//getText();--> metoda care returneaza textul dintre tagurile HTML
		//ale unui web element
		System.out.println(discoverText.getText());
		//discoverText.click();
		assertEquals(discoverText.getText(), "Discover");
		//driver.findElement(By.tagName("em")).getText();
		//driver.findElement(By.tagName("em")).click();	
	}
	
	@Test(priority=2)
	public void linkTextLocator() {
	//linkText se aplica doar pe taguri de tip <a>
	//<a href="https://keybooks.ro/shop/">Books</a>
	//										^|			
		 driver.findElement(By.linkText("BOOKS")).click();
		 //Dc ma uit la style am text-transform: uppercase; si se vede si in meniul vertical
		 assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
		 //metoda getCurrentUrl care se aplica pe instanta de driver
	}
	
	@Test(priority =3)
	public void partialLinkTextLocator() {
		
		driver.findElement(By.partialLinkText("Cooking")).click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
		
		//<a href="https://keybooks.ro/shop/cooking-with-love/">Cooking with love</a>
		
		/* LINK TEXT : Cooking with love
		 * 
		 * PARTIAL LINK TEXT : Cooking
		 * PARTIAL LINK TEXT : with
		 * PARTIAL LINK TEXT : love
		 * PARTIAL LINK TEXT : Cook
		 * 
		 */
		
		assertEquals(driver.getTitle(),"Cooking with love2 – Booklovers");
		
	}
	@Test(priority=4)
	public void classNameLocator() throws InterruptedException {
		//<p class = "price">
		WebElement price =  driver.findElement(By.className("price"));
		//isDisplayed()--verifica daca un webelement apare (este vizibil) in aplicatie
		assertTrue(price.isDisplayed());//isDisplayed se aplica pe WebElement
		//findElement gaseste si elementente hidden dar nu poate actiona pe ele
		//folosind isDisplayed imi dau seama dc pot actiona asupra lui
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//JavascriptExecutor e un inject de javascript
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", price);
		//executeScript insereaza element de css - marcheaza chenarul dreptunghiului cu rosu
		Thread.sleep(4000);
		//price e varargs si refera unul sau mai multe elemente
		System.out.println(price.getText());
		assertTrue(price.getText().contains("18.47"));
	}
	@Test(priority=5)
	public void idLocator() {
		
		driver.findElement(By.id("tab-title-reviews")).click();
		
		WebElement commentBox =  driver.findElement(By.id("comments"));
		assertTrue(commentBox.isDisplayed());
		
	}
	
	@Test(priority=6)
	public void nameLocator() {
		WebElement commentBox=driver.findElement(By.name("comment"));
		commentBox.sendKeys("My comment");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", commentBox);
	}
	
	@Test(priority=7)
	public void cssSelectorLocator() {
		//click pe elementul inspectat si ctrl+F
		WebElement authorBox=driver.findElement(By.cssSelector("input[name=\"author\"]"));
		// cand vreau sa ignor un caracter pun \ si atunci Java imi ignora caracterul de dupa \
		//WebElement authorBox=driver.findElement(By.cssSelector("input[name='author']"));
		//linia de sus 106 e echivalenta cu linia 104
		authorBox.sendKeys("Jhonny Bravo");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", authorBox);
	}
	
	/*
	 * XPATH --> //input[@type='email']
	 * CSS   --> input[type='email']
	 */
	
	@Test(priority=8)
	public void xpathLocator() {
		// dc pun in search // inseamna ca incepe cautarea de la nodul la care am pus //
		// dc pun in search //* incepe cautarea de la orice nod
		// la xpath folosesc @ pentru a referi atributele: //input[@type='email']
		WebElement emailBox=driver.findElement(By.xpath("//input[@type='email']"));
		emailBox.sendKeys("JhonnyBravo@JhonnyBravo.com");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", emailBox);
	
	}
}

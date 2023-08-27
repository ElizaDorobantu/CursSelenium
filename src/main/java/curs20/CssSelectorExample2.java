package curs20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorExample2 extends BaseTest{

	//@Test
	public void cssSelectorTest() {
		
		// cum selectez un anumit element din meniul NEW RELEASES COMING SOON
		
		// first-of-type --> New Releases
		// li[class*='sc_tabs_title']:first-of-type
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement newReleases = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", 
				newReleases);
		
		// nth-of-type(index) --> COMING SOON
		// li[class*='sc_tabs_title']:nth-of-type(2) selecteaza al doilea element
		WebElement comingSoon = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(2)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; border:4px solid blue')", 
				comingSoon);
		
		// nth-of-type(index) --> BEST SELLERS
		// li[class*='sc_tabs_title']:nth-of-type(3) selecteaza al treilea element
		WebElement bestSellers = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(3)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: green; border:4px solid blue')", 
				bestSellers);
		
		// last-of-type --> AWARD WINNERS
		// li[class*='sc_tabs_title']:last-of-type selecteaza al treilea element
		WebElement awardWinners = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:last-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:4px solid blue')", 
				awardWinners);
		
	}
	
	//@Test
	public void cssSelectorsTest2() {
		
		//li[class*='sc_tabs_title'][aria-selected="true"]
		//selectez doar elementul care are aria-selected="true", adica cel subliniat
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement menuEntry = driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected=\"true\"]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: purple; border:4px solid blue')", 
				menuEntry);
		
		//li[class*='sc_tabs_title']:not([aria-selected="true"])
		//selectez tot in afara de elementul care are atributul aria-selected="true"
		List<WebElement> menuEntries = driver.findElements(
				By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected=\"true\"])"));
		
		for(WebElement element : menuEntries) {
			jse.executeScript("arguments[0].setAttribute('style', 'background: pink; border:4px solid blue')", 
					element);
		}
		
	}
	
	
	@Test
	public void cssSelectorTest3() throws InterruptedException {
		//direct child folosesc > din parinte
		//li[class='menu_user_login']>a[class*='popup_link']
		
		//nephew child folosim spatiu
		//ul[class*='menu_user_nav'] a[class*='popup_link']
		
		
		//xpath finder sau 	SelectorsHub sunt plugins pt browsere sa identific elementele mai usor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement loginMenu = driver.findElement(
				By.cssSelector("ul[class*='menu_user_nav'] a[class*='popup_link']"));
		loginMenu.click();
		Thread.sleep(3000);
		
		//logical AND --adk tagname[atribut=value][atribut=value]
		//input[id='log'][name='log']
		
		WebElement username = driver.findElement(
				By.cssSelector("input[id='log'][name='log'"));
		username.sendKeys("TestUser");
		
		//logical OR --adk tagname[atribut=value],[atribut=value]
		//input[type='password'],[name='pwd']
				
		WebElement password = driver.findElement(
			By.cssSelector("input[type='password'],[name='pwd']"));
		password.sendKeys("TestUser");
	}
}

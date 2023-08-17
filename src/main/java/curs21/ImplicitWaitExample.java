package curs21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ImplicitWaitExample extends BaseTest {
	
	@Test
	public void implicitWaitTest() throws InterruptedException {
		
		//implicit wait -- asteapta pt numarul de sec dat ca elementul sa apara in DOM
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//sta 10 secunde doar dc elementul nu apare mai devreme
		//dc gaseste elementul dupa 2 secunde, nu mai asteapta restul de 8 secunte
		
		driver.findElement(By.cssSelector("div[id='start']>button")).click();;
		
		//Thread.sleep(10000);//bad practice
		
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		
		assertEquals(finish.getText(), "Hello World!");
	}

}

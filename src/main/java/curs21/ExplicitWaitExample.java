package curs21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ExplicitWaitExample extends BaseTest{

	@Test
	public void explicitWait() {
		//explicit wait -- asteapta pt numarul de sec dat ca elementul sa apara in DOM
		//explicit wait asteapta sa se indeplineasca o conditie
		// implicit wait doar cauta elementul indiferent dc e hidden sau nu
		//la implicit wait odata gasit elementul merge mai departe
		
				
				driver.findElement(By.cssSelector("div[id='start']>button")).click();;
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.textToBePresentInElementLocated
						(By.cssSelector("div[id='start']>button"), "Hello World!"));
				
				WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
				
				assertEquals(finish.getText(), "Hello World!");
	}
}

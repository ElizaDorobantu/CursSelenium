package TemaCurs18;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs18 extends BaseTest{
	
	/*
	 * Vom face un script care verifica daca anumite elemente sunt vizibile inainte
si dupa efectuarea unei actiuni.
 Deschidem https://keybooks.ro/
 Identificam urmatorul element Login
Acest element trebuie sa fie vizibil dupa ce deschidem pagina

 Verificam daca urmatoarele element nu sunt vizibile: username si password
 
 Acest elemente trebuie sa fie vizibile dupa ce deschidem dam click pe
primul element identificat (Login).

Homework.

 Dam click() pe primul element (Login)
 Acum vom verifica daca elementele sunt vizibile.

 Note:
 Pentru test facem toate verificarile intr-o singura metoda
 Pentru a verifica daca elementul exista folosim isDisplayed()
	 * 
	 */
	
	@Test
	public void testeLocatori()  {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement login = driver.findElement(By.className("menu_user_login"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; border:4px solid blue')", 
			login);
		assertTrue(login.isDisplayed());
	
		WebElement username = driver.findElement(By.id("log"));
		assertFalse(username.isDisplayed());
		//WebElement password = driver.findElement(By.id("password"));	
		WebElement password = driver.findElement(
				By.cssSelector("input[type='password'][name='pwd']"));
		assertFalse(password.isDisplayed());
	
		login.click();
		assertTrue(username.isDisplayed());
		
		assertTrue(password.isDisplayed());
		
	}
}

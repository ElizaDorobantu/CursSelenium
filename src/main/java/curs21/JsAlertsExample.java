package curs21;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JsAlertsExample extends BaseTest{

	@Test(priority=0)
	public void simpleJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		//fac switchTo alerte js, i frame si alerte sau taburi diferite
		
		WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(),"You successfully clicked an alert");
		
	}
	
	@Test(priority=1)
	public void confirmJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().dismiss();
		//dismiss da click pe Cancel
		//fac switchTo alerte js, i frame si alerte sau taburi diferite
		
		WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(),"You clicked: Cancel");
		
	}
	
	@Test(priority=2)
	public void promptJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		
		Alert alertaJs = driver.switchTo().alert();
		alertaJs.sendKeys("text");
		alertaJs.accept();
		
		//fac switchTo alerte js, i frame si alerte sau taburi diferite
		
		WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(),"You entered: text");
		
	}
}

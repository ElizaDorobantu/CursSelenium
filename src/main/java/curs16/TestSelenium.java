package curs16;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	@Test
	public void testOpenBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://keybooks.ro/");
			
	}
}

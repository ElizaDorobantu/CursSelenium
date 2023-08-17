package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//clase utilitare pentru setup

public class BaseTest {
	
	public WebDriver driver;//instanta de browser
	
	@BeforeClass//pentru a rula am nevoie obligatoriu de o metoda @Test
	public void setup() {
		
		//System.setProperty("webdriver.chrome.driver","path//chromedriver.exe");
		//comanda de mai sus e din versiunea 3. Incepand cu 4 nu mai e nevoie de path
		//Boni Garcia webdriver manager a facut o librarie 
		
		driver = new EdgeDriver();
		
		// clasa BaseTest e facuta ca si punct central pt a deschide /inchide browserul dintr-un singur loc
		
		driver.manage().window().maximize();//mareste fereastra de la browser
		//driver.get("https://keybooks.ro/");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);//bad practice
		driver.close();
	}

}

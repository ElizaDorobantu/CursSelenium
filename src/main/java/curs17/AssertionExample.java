package curs17;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AssertionExample {

	String actualTitle = "test";
	String expectedTitle = "masina";
	
	@Test
	public void checkTitle() {
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
	}
	
	@Test
	public void checkTitle2() {
		assertEquals(actualTitle,expectedTitle);
	}
	
	
	//checkTitle e passed ca si test pt ca se executa ramura else
	//da mesajul Failed
	//checkTitle2 e failed pt ca are doar assert
}

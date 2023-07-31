package curs17;

import org.testng.annotations.Test;

public class TestPriority {

	@Test(priority = 1)
	public void one() {
		System.out.println("First");
	
	}
	
	@Test(priority = 2)
	public void two() {
		System.out.println("Second");
	
	}
	
	@Test(priority = 3)
	public void three() {
		System.out.println("Third");
	
	}
	
	
	//TestNG executa intai metodele fara priority ordonate alfabetic
	//apoi ruleaza metodele cu priority dupa prioritatea data
	@Test
	public void four() {
		System.out.println("Fourth");
	
	}
	
	@Test
	public void five() {
		System.out.println("Fifth");
	
	}
}

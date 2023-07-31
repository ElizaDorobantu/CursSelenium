package curs17;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class BeforeAfterAnnotations {
	
	//adnotarile BeforeSuite si restul de mai jos nu ruleaza pana nu ii pun @test
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	//BeforeMethod ruleaza inainte de fiecare @Test
	//si AfterMethod ruleaza dupa fiecare @Test
	@Test
	public void test2() {
		System.out.println("Test2");
	}
}

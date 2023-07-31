package curs17;

import org.testng.annotations.Test;

@Test
//@Test poate fi pusa la nivel de clasa si e echivalenta
//cu @Test pus pe toate metodele din interiorul clasei
//metodele private cand @Test e la nivelul clasei nu ruleaza
//dc metoda e privata dar am @Test la nivelul ei, va rula
public class TestAnnotation {

	//@Ignore
	//se foloseste pt a ignora metoda
	public void test1() {
		System.out.println("test1");
		
	}
	
	//@Test
	public void test2() {
		System.out.println("test2");
		
	}
	
	//@Test
	public void test3() {
		System.out.println("test3");
		
	}
	
	//@Test
	private void test4() {
		System.out.println("test4");
		
	}
	
}

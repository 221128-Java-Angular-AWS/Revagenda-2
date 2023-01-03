package com.revagenda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	String str = "hi!";
	private int i;
	Object o;
	
	
	public int test() {
		return 1;
	}
	
	
		@Test
	void contextLoads() {
		System.out.println("This is a test. Let's cause a merge conflict.");
	}
	

}

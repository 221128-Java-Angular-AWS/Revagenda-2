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
	
	
	void testTwo() {
		//test
		System.out.println("This caused merge conflicts");
	}
	
	public void testAgain(int i) {
		this.i = i;
	}
	
	//stuff
	//to
	//confuse
	//github

	

}

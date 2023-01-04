package com.revagenda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RevagendaTests {
	String str = "hi!";
	private int i;
	Object o;
	private Integer test;

	public int test() {
		return 1;
	}


	@Test
	void contextLoads() {
		System.out.println("This is a test. Let's cause a merge conflict.");
		this.test = 5;
	}

	void testTwo() {
		//test
		System.out.println("This might break it...");
	}
	
	public void testAgain(int i) {
		this.i = i;
	}

}

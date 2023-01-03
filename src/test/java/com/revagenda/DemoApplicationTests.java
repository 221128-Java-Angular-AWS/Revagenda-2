package com.revagenda;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest
class DemoApplicationTests {
	private int i;

	@Test
	void contextLoads() {
		System.out.println("This is a test. Let's cause a merge conflict.");
	}
	
	void testMethod() {
		//this is a test
		System.out.println("Lorem Ipsum stuff");
	}

}

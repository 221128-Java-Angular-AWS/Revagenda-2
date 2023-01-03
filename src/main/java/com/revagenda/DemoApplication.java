package com.revagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revagenda.beans")
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(DemoApplication.class, args);
	}

}

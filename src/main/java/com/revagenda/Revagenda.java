package com.revagenda;

import com.revagenda.models.Pokexample;
import com.revagenda.services.HttpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages =
		"com.revagenda.demobeans, " +
		"com.revagenda.controllers, " +
		"com.revagenda.services," +
		"com.revagenda.repositories")
public class Revagenda {
	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Revagenda.class, args);
		String[] beans = context.getBeanDefinitionNames();

		HttpService service = context.getBean(HttpService.class);
		Pokexample ditto = service.testPokeApi();
		System.out.println("Poke API test: " + ditto);

//		System.out.println("Beans: ");
//		for(int i = 0; i < beans.length; i++) {
//			System.out.println(beans[i]);
//		}



	}

}

package com.qa.springcadie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCadieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCadieApplication.class, args);
	}
	
	 // The Bean essentially means, that we no longer need to worry about its control
	//This is now the responsibility of the framework
	@Bean
	public String helloWorld() {
		return "Hello World";
	}
	
	@Bean
	public void printFunction() {
		System.out.println(helloWorld());
	}

}

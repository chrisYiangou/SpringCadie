package com.qa.springcadie.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope("singleton")
	public void byeBye() {
		System.out.println("BYEEEE");
	}

}

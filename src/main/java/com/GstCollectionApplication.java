package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class GstCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GstCollectionApplication.class, args);
	}

	 
	@Bean
	  public BCryptPasswordEncoder passwordencode() {
		  
		  return new BCryptPasswordEncoder();
	  }
	
	
	
}

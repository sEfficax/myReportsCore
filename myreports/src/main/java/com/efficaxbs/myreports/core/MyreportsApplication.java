package com.efficaxbs.myreports.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity

public class MyreportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyreportsApplication.class, args);
	}

}

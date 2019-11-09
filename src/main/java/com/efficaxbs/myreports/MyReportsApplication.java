package com.efficaxbs.myreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan        (basePackages = "com.efficaxbs.myreports.*")
public class MyReportsApplication { 

	public static void main(String[] args) {
		SpringApplication.run(MyReportsApplication.class, args);
	}
   
}
 
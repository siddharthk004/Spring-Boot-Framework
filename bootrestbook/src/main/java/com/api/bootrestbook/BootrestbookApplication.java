package com.api.bootrestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.api.bootrestbook.dao")
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
	}
} 

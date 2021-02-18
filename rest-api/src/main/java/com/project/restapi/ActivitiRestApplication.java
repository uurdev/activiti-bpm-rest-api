package com.project.restapi;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ActivitiRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActivitiRestApplication.class, args);
	}

}

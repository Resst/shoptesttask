package com.resst.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}

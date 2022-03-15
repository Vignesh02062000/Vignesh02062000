package com.cg.mts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition
@SpringBootApplication
@ComponentScan("com.cg")
public class MovieFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieFinalApplication.class, args);
	}

}

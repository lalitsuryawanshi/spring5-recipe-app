package com.lalit.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootReceipeAppApplication {

	public static void main(String[] args) {
		log.debug("Spring Application Initialized..");
		SpringApplication.run(SpringBootReceipeAppApplication.class, args);
	}
}

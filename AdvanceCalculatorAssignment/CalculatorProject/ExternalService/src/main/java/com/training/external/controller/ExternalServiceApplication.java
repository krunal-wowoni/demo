package com.training.external.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@ComponentScan(basePackages = "com.training.external.controller")
@ComponentScan(basePackages = "com.training.commons")
@SpringBootApplication
@Slf4j
public class ExternalServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {

		SpringApplication.run(ExternalServiceApplication.class, args);
		log.info("ExternalServiceApplication started....");
	}

}

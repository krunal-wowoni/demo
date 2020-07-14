package com.training.computedate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ComputeDateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ComputeDateApplication.class, args);
		log.info("ComputeDateApplication started....");
	}

}

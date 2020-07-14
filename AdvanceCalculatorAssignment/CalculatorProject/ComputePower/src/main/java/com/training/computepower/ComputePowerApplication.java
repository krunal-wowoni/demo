package com.training.computepower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ComputePowerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ComputePowerApplication.class, args);
		log.info("ComputePowerApplication started....");
	}

}

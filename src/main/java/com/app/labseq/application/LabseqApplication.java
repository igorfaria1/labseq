package com.app.labseq.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.app.labseq.*"})
public class LabseqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabseqApplication.class, args);
	}
}

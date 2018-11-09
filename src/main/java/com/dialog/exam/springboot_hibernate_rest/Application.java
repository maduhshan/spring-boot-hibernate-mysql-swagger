package com.dialog.exam.springboot_hibernate_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author mchatu
 *
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		System.out.println("Starting Spring Application");
		SpringApplication.run(Application.class, args);
	}
}
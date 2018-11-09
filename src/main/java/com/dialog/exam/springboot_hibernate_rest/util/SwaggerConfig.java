package com.dialog.exam.springboot_hibernate_rest.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket produceApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dialog.exam.springboot_hibernate_rest.controller"))
//				.paths(getPaths())
				.build();
		
	}
	
	protected ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("student management")
				.description("This Page Lists All Student Managemnt Information")
				.version("v1")
				.build();
	}
	
	private Predicate<String> getPaths() {
		
		return Predicates.and(PathSelectors.regex("/student/*"));		
	}
}

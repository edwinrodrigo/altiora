package com.altiora.ec.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.altiora.ec.util.GenericMapperConverterUtils;


@Configuration
public class ServiceConfiguration {

	 @Bean
	 ModelMapper modelMapper() {
	        return new ModelMapper();
	 }

	 @Bean
	 GenericMapperConverterUtils genericConverterUtils(ModelMapper modelMapper) {
	        return new GenericMapperConverterUtils(modelMapper);
	 }

	 @Bean
	 WebMvcConfigurer corsConfigurer() {
	         return new WebMvcConfigurer() {
	                 @Override
	                 public void addCorsMappings(CorsRegistry registry) {
	                	 
	                         registry.addMapping("/**")
	                                 .allowedOrigins("http://localhost:4200/")
	                                 .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD")
	                                 .maxAge(3600);
	                 }

	         };
	 }
	 
}
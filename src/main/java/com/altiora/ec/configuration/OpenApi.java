package com.altiora.ec.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
		info = 	@Info(
				title = "Prueba Tecnica - AltioraApi",
				version = "1.0.0", contact = @Contact(
						name = "Edwin Amaguaya",
						email = "eamaguaya89@gmail.com",
						url = "https://www.linkedin.com/in/edwinamaguayadev/"
						),
				description = "Prueba para el cargo Full Stack Altiora - Api"
		)
)
public class OpenApi {

}
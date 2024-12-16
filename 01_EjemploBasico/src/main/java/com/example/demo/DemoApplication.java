package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
		@Info(description = "Una API de ejemplo para los alumnos de 2º DAM",
				  version = "1.0",
				  contact = @Contact(
						  email = "luismi.lopez@triana.salesianos.edu",
						  name = "Luismi"),
				  license = @License(
						  name = "Kalise para todos"),
				  title = "API sobre productos")
		)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

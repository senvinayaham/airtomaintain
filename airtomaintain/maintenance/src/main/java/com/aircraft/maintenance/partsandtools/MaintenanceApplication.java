package com.aircraft.maintenance.partsandtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.airtomaintain.maintenance.dto.PartsAndToolsContactInfo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication

/*
 * @ComponentScans({@ComponentScan("")})
 * @EnableJpaRepositories("")
 * @EntityScan("")
 */

@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value= {PartsAndToolsContactInfo.class})
@OpenAPIDefinition(
		info = @Info( 
		
				title = " Parts and Tools Microservice REST API Documentation",
				description = "Aircraft Maintenance Extension REST API Documentation",
				version = "v0",
				contact = @Contact (
						
						name = "Senthil Vinayaham Murugan",
						email = "senvinayaham@gmail.com",
						url = "http//localhost:8080/"
						
						),
				license = @License (
						
						name = "AirToMaintain",
						url = "http://localhost:8080"
						
						)
				),
		externalDocs = @ExternalDocumentation (
				
				description = "Aircraft Maintance Extention Documentation",
				url = "http://localhost:8080"
				
				)
		
		)
public class MaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
	}

}
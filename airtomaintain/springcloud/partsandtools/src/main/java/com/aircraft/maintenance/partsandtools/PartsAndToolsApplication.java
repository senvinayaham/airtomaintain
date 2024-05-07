package com.aircraft.maintenance.partsandtools;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.aircraft.maintenance.partsandtools.service.IPartsService;
import com.aircraft.maintenance.partsandtools.service.IToolsService;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
/*
 * @ComponentScans({@ComponentScan("")})
 * @EnableJpaRepositories("")
 * @EntityScan("")
 */

@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value= {com.aircraft.maintenance.partsandtools.dto.PartsAndToolsContactInfo.class})
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
public class PartsAndToolsApplication {

	private IPartsService iPartsService;
	private IToolsService iToolsService;
	
	public static void main(String[] args) {
		SpringApplication.run(PartsAndToolsApplication.class, args);
	}

	@Bean
	public GraphQL graphQL() throws IOException {
		SchemaParser schemaParser = new SchemaParser();
		ClassPathResource schema = new ClassPathResource("schema.graphql");
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema.getInputStream());
		
		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
		.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getPart", iPartsService.getPart()))
		.build();
		
		SchemaGenerator generator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = generator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		return GraphQL.newGraphQL(graphQLSchema).build();
	}
	
}

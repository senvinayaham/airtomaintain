package com.aircraft.maintenance.apigateway;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator aircraftMaintenanceRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/maintenance/partsandtools/**")
						.filters(f -> f
								.rewritePath("/maintenance/partsandtools/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://PARTSANDTOOLS"))
				.route(p -> p
						.path("/maintenance/cards/**")
						.filters(f -> f
								.rewritePath("/maintenance/cards/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://CARDS"))
				.build();
				
	}
}

package com.aircraft.maintenance.apigateway;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
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
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("partsandtoolsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						
						.uri("lb://PARTSANDTOOLS"))
				.route(p -> p
						.path("/maintenance/cards/**")
						.filters(f -> f
								.rewritePath("/maintenance/cards/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								//.retry(retryConfig -> retryConfig.setRetries(3).setMethods(HttpMethod.GET)
								//		.setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000), 2, true))
								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())))
						.uri("lb://CARDS"))
				.build();
				
	}
	
	@Bean
	public RedisRateLimiter redisRateLimiter() {
		
		return new RedisRateLimiter(1,1,1);
	}
	
	@Bean
	KeyResolver userKeyResolver() {
		
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}
}

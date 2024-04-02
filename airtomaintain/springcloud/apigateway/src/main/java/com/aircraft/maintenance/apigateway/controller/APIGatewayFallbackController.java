/**
 * 
 */
package com.aircraft.maintenance.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * @author senthilvinayahammurugan
 *
 */
@RestController
public class APIGatewayFallbackController {

	
	@RequestMapping("/contactSupport")
	public Mono<String> contactSupport(){
	
		return Mono.just("An error occurred, please try after sometime or contact the support team!");
		
	}
	
}

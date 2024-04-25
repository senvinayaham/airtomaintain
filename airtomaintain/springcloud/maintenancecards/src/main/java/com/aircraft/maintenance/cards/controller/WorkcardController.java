/**
 * 
 */
package com.aircraft.maintenance.cards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aircraft.maintenance.cards.dto.WorkCardDetailsDto;
import com.aircraft.maintenance.cards.service.IWorkCardDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author senthilvinayahammurugan
 *
 */
@Tag(
		name = "CURS REST API for WorkCards Details in Aircraft Maintenance",
		description = "CURD REST APIs in Aircraft Maintenance CREATE, FETCH, UPDATE AND DELETE WorkCards and TaskCards details"
		)
@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class WorkcardController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkcardController.class);
	
	private final IWorkCardDetailsService iWorkCardDetailsService;
	
	public WorkcardController(IWorkCardDetailsService iWorkCardDetailsService) {
		
		this.iWorkCardDetailsService = iWorkCardDetailsService;
	}
	
	@Operation (
			
			summary = "FETCH WorkCard Details REST API",
			description = "REST API to Fetch WorkCard Details to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="WorkCard Details Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@GetMapping("/fetch_workcarddetails")
	public ResponseEntity<WorkCardDetailsDto> fetchWorkcardDetails(
			@RequestHeader("aircraftmaintenance-correlation-id") String correlationId,
			@NotEmpty @RequestParam String workCardNumber){
		//logger.debug("aircraftmaintenance-correlation-id generated in RequestTraceFilter : {}", correlationId);
		logger.debug("Fetch Worcard Details Start");
		WorkCardDetailsDto workCardDetailsDto = iWorkCardDetailsService.fetchWorkCardDetails(correlationId, workCardNumber);
		logger.debug("Fetch Worcard Details End");
		return ResponseEntity.status(HttpStatus.OK)
				.body(workCardDetailsDto);
	}
	
}

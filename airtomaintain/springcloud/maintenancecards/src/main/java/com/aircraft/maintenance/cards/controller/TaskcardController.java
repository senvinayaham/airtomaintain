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

import com.aircraft.maintenance.cards.dto.TaskCardDetailsDto;
import com.aircraft.maintenance.cards.service.ITaskCardDetailsService;

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
		name = "CURS REST API for TaskCards Details in Aircraft Maintenance",
		description = "CURD REST APIs in Aircraft Maintenance CREATE, FETCH, UPDATE AND DELETE TaskCards details"
		)
@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class TaskcardController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskcardController.class);
	
	private final ITaskCardDetailsService iTaskCardDetailsService;
	
	public TaskcardController(ITaskCardDetailsService iTaskCardDetailsService) {
		
		this.iTaskCardDetailsService = iTaskCardDetailsService;
	}
	
	@Operation (
			
			summary = "FETCH TaskCard Details REST API",
			description = "REST API to Fetch TaskCard Details to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="TaskCard Details Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@GetMapping("/fetch_taskcarddetails")
	public ResponseEntity<TaskCardDetailsDto> fetchTaskcardDetails(
			@RequestHeader("aircraftmaintenance-correlation-id") String correlationId,
			@NotEmpty @RequestParam String taskCardNumber){
		//logger.debug("aircraftmaintenance-correlation-id generated in RequestTraceFilter : {}", correlationId);
		logger.debug("Fetch Taskcard Details Start");
		TaskCardDetailsDto taskCardDetailsDto = iTaskCardDetailsService.fetchTaskCardDetails(correlationId, taskCardNumber);
		logger.debug("Fetch Worcard Details End");
		return ResponseEntity.status(HttpStatus.OK)
				.body(taskCardDetailsDto);
	}
	
}

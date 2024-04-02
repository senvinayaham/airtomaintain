package com.aircraft.maintenance.cards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aircraft.maintenance.cards.constants.WorkCardsConstants;
import com.aircraft.maintenance.cards.constants.TaskCardsConstants;
import com.aircraft.maintenance.cards.dto.ErrorResponseDto;
import com.aircraft.maintenance.cards.dto.CardsContactInfo;
import com.aircraft.maintenance.cards.dto.WorkCardsDto;
import com.aircraft.maintenance.cards.dto.ResponseDto;
import com.aircraft.maintenance.cards.dto.TaskCardsDto;
import com.aircraft.maintenance.cards.service.IWorkCardsService;

import com.aircraft.maintenance.cards.service.ITaskCardsService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * @author senthilvinayahammurugan
 *
 */

@Tag(
		name = "CURS REST API for WorkCards and TaskCards in Aircraft Maintenance",
		description = "CURD REST APIs in Aircraft Maintenance CREATE, FETCH, UPDATE AND DELETE WorkCards and TaskCards details"
		)
@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CardsController {

	
	private static final Logger logger = LoggerFactory.getLogger(CardsController.class);
	private IWorkCardsService iWorkCardsService;
	private ITaskCardsService iTaskCardsService;
	
	public CardsController(IWorkCardsService iWorkCardsService, ITaskCardsService iTaskCardsService) {
		
		this.iWorkCardsService = iWorkCardsService;
		this.iTaskCardsService = iTaskCardsService;
		
	}
	
	@Value("${build.version}")
	private String buildVersion;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CardsContactInfo cardsContactInfo;
	
	@Operation (
			
			summary = "CREATE WorkCards REST API",
			description = "REST API to create WorkCards to maintain Aircrafts"
			)
	@ApiResponse (
			
			responseCode = "201",
			description ="WorkCards Created Successfuly",			
			content = @Content (
					
					schema = @Schema(
							
							implementation = ErrorResponseDto.class
														
							)
					
					)
			)
	@PostMapping("/create_workcard")
	public ResponseEntity<ResponseDto> createWorkCard(@Valid @RequestBody WorkCardsDto workCardsDto){
		
		iWorkCardsService.createWorkCard(workCardsDto);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(WorkCardsConstants.MESSAGE_201, WorkCardsConstants.STATUS_201));
		
	}

	@Operation (
			
			summary = "CREATE TaskCard REST API",
			description = "REST API to create TaskCards to maintain Aircrafts"
			)
	@ApiResponse (
			
			responseCode = "201",
			description ="TaskCard Created Successfuly"			
			)
	@PostMapping("/create_taskcard")
	public ResponseEntity<ResponseDto> createTaskCard(@Valid @RequestBody TaskCardsDto taskCardsDto){
		
		iTaskCardsService.createTaskCard(taskCardsDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(TaskCardsConstants.MESSAGE_201, TaskCardsConstants.STATUS_201));
		
	}
	
	@Operation (
			
			summary = "FETCH WorkCards REST API",
			description = "REST API to Fetch WorkCards to maintain Aircrafts"
			)
	@GetMapping("/fetch_workcard")
	public ResponseEntity<WorkCardsDto> fetchWorkCard(@NotEmpty @RequestParam String workCardNumber){
		
		WorkCardsDto workCardsDto = iWorkCardsService.fetchWorkCard(
				workCardNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(workCardsDto);
		
	}

	@Operation (
			
			summary = "FETCH TaskCards REST API",
			description = "REST API to Fetch TaskCards to maintain Aircrafts"
			)
	@GetMapping("/fetch_taskcard")
	public ResponseEntity<
	TaskCardsDto> fetchTaskCard(@NotEmpty @RequestParam String toolsNumber){
		
		TaskCardsDto taskCardsDto = iTaskCardsService.fetchTaskCard(toolsNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(taskCardsDto);
		
	}
	
	@Operation (
			
			summary = "UPDATE WorkCards REST API",
			description = "REST API to Update WorkCards to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="WorkCards Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@PutMapping("/update_workcard")
	public ResponseEntity<ResponseDto> updateWorkCard(@Valid @RequestBody WorkCardsDto workCardsDto){
		
		boolean isUpdated = iWorkCardsService.updateWorkCard(workCardsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(WorkCardsConstants.MESSAGE_200, WorkCardsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(WorkCardsConstants.MESSAGE_500, WorkCardsConstants.STATUS_500));

	}
	
	@Operation (
			
			summary = "UPDATE TaskCards REST API",
			description = "REST API to Update TaskCards to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="TaskCards Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
			)
	})
	@PutMapping("/update_taskcard")
	public ResponseEntity<ResponseDto> updateTaskCard(@Valid @RequestBody TaskCardsDto taskCardsDto){
		
		
		boolean isUpdated = iTaskCardsService.updateTaskCard(taskCardsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(TaskCardsConstants.MESSAGE_200, TaskCardsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(TaskCardsConstants.MESSAGE_500, TaskCardsConstants.STATUS_500));

	}
	
	@Operation (
			
			summary = "DELETE TaskCards REST API",
			description = "REST API to Delete WorkCards to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="WorkCards Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
			)
	})
	@DeleteMapping("/delete_workcard")
	public ResponseEntity<ResponseDto> deleteWorkCard(@NotEmpty @RequestParam String partsNumber){
		
		boolean isDeleted = iWorkCardsService.deleteWorkCard(partsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(WorkCardsConstants.MESSAGE_200, WorkCardsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(WorkCardsConstants.MESSAGE_500, WorkCardsConstants.STATUS_500));
	}
	
	@Operation (
			
			summary = "DELETE TaskCards REST API",
			description = "REST API to Delete TaskCards to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="TaskCards Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@DeleteMapping("/delete_taskcard")
	public ResponseEntity<ResponseDto> deleteTaskCard(@NotEmpty @RequestParam String toolsNumber){
		
		boolean isDeleted = iTaskCardsService.deleteTaskCard(toolsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(TaskCardsConstants.MESSAGE_200, TaskCardsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto (TaskCardsConstants.MESSAGE_500, TaskCardsConstants.STATUS_500));
	}
	@Operation (
			
			summary = "FETCH Build Information REST API",
			description = "REST API to Fetch Build Information for WorkCards and TaskCards Service"
			)
	@Retry(name ="getBuildInfo", fallbackMethod = "getBuildInfoFallback")
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(buildVersion);
		
	}
	
	public ResponseEntity<String> getBuildInfoFallback(Throwable throwable){
		

		logger.debug("getBuildInfoFallback Method Invoked");
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("1.0");
		
	}
	
	@Operation (
			
			summary = "FETCH Java Version",
			description = "REST API to Fetch Java Version"
			)
	@GetMapping("/java-version")
	@RateLimiter(name = "getJavaVersion" , fallbackMethod = "getJavaVersionFallback")
	public ResponseEntity<String> getJavaVersion(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(environment.getProperty("JAVA_HOME"));
		
	}
	
	public ResponseEntity<String> getJavaVersionFallback(Throwable thorowable){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Please try after sometime since this is lower priority");
		
	}
		
	
	@Operation (
			
			summary = "FETCH Java Version",
			description = "REST API to Fetch Java Version"
			)
	@GetMapping("/contact-info")
	public ResponseEntity<CardsContactInfo> getConstactInfo(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(cardsContactInfo);
		
	}	
}

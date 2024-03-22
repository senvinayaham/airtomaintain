package com.airtomaintain.maintenance.controller;

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

import com.airtomaintain.maintenance.constants.PartsConstants;
import com.airtomaintain.maintenance.constants.ToolsConstants;
import com.airtomaintain.maintenance.dto.ErrorResponseDto;
import com.airtomaintain.maintenance.dto.PartsAndToolsContactInfo;
import com.airtomaintain.maintenance.dto.PartsDto;
import com.airtomaintain.maintenance.dto.ResponseDto;
import com.airtomaintain.maintenance.dto.ToolsDto;
import com.airtomaintain.maintenance.service.IPartsService;
import com.airtomaintain.maintenance.service.IToolsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * @author senthilvinayahammurugan
 *
 */

@Tag(
		name = "CURS REST API for Parts and Tools in Aircraft Maintenance",
		description = "CURD REST APIs in Aircraft Maintenance CREATE, FETCH, UPDATE AND DELETE Parts and Tools details"
		)
@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class MaintenanceController {

	private final IPartsService iPartsService;
	private final IToolsService iToolsService;
	
	
	public MaintenanceController(IPartsService iPartsService, IToolsService iToolsService) {
		
		this.iPartsService = iPartsService;
		this.iToolsService = iToolsService;
		
	}
	
	@Value("${build.version}")
	private String buildVersion;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PartsAndToolsContactInfo partsAndToolsContactInfo;
	
	@Operation (
			
			summary = "CREATE Parts REST API",
			description = "REST API to create Parts to maintain Aircrafts"
			)
	@ApiResponse (
			
			responseCode = "201",
			description ="Parts Created Successfuly",			
			content = @Content (
					
					schema = @Schema(
							
							implementation = ErrorResponseDto.class
														
							)
					
					)
			)
	@PostMapping("/create_parts")
	public ResponseEntity<ResponseDto> createParts(@Valid @RequestBody PartsDto partsDto){
		
		iPartsService.createParts(partsDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(PartsConstants.MESSAGE_201, PartsConstants.STATUS_201));
		
	}

	@Operation (
			
			summary = "CREATE Tools REST API",
			description = "REST API to create Tools to maintain Aircrafts"
			)
	@ApiResponse (
			
			responseCode = "201",
			description ="Parts Created Successfuly"			
			)
	@PostMapping("/create_tools")
	public ResponseEntity<ResponseDto> createTools(@Valid @RequestBody ToolsDto toolsDto){
		
		iToolsService.createTools(toolsDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(ToolsConstants.MESSAGE_201, ToolsConstants.STATUS_201));
		
	}
	
	@Operation (
			
			summary = "FETCH Parts REST API",
			description = "REST API to Fetch Parts to maintain Aircrafts"
			)
	@GetMapping("/fetch_parts")
	public ResponseEntity<PartsDto> fetchParts(@NotEmpty @RequestParam String partsNumber){
		
		PartsDto partsDto = iPartsService.fetchParts(
				partsNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(partsDto);
		
	}

	@Operation (
			
			summary = "FETCH Tools REST API",
			description = "REST API to Fetch Tools to maintain Aircrafts"
			)
	@GetMapping("/fetch_tools")
	public ResponseEntity<
	ToolsDto> fetchTools(@NotEmpty @RequestParam String toolsNumber){
		
		ToolsDto toolsDto = iToolsService.fetchTools(toolsNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(toolsDto);
		
	}
	
	@Operation (
			
			summary = "UPDATE Parts REST API",
			description = "REST API to Update Parts to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="Parts Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@PutMapping("/update_parts")
	public ResponseEntity<ResponseDto> updateParts(@Valid @RequestBody PartsDto partsDto){
		
		boolean isUpdated = iPartsService.updateParts(partsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(PartsConstants.MESSAGE_200, PartsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(PartsConstants.MESSAGE_500, PartsConstants.STATUS_500));

	}
	
	@Operation (
			
			summary = "UPDATE Tools REST API",
			description = "REST API to Update Tools to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="Tools Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
			)
	})
	@PutMapping("/update_tools")
	public ResponseEntity<ResponseDto> updateTools(@Valid @RequestBody ToolsDto toolsDto){
		
		
		boolean isUpdated = iToolsService.updateTools(toolsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(ToolsConstants.MESSAGE_200, ToolsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(ToolsConstants.MESSAGE_500, ToolsConstants.STATUS_500));

	}
	
	@Operation (
			
			summary = "DELETE Tools REST API",
			description = "REST API to Delete Parts to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="Parts Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
			)
	})
	@DeleteMapping("/delete_part")
	public ResponseEntity<ResponseDto> deletePart(@NotEmpty @RequestParam String partsNumber){
		
		boolean isDeleted = iPartsService.deleteParts(partsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(PartsConstants.MESSAGE_200, PartsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(PartsConstants.MESSAGE_500, PartsConstants.STATUS_500));
	}
	
	@Operation (
			
			summary = "DELETE Tools REST API",
			description = "REST API to Delete Tools to maintain Aircrafts"
			)
	@ApiResponses ({
		@ApiResponse (
				
				responseCode = "200",
				description ="Tools Request Processed Successfully"			
				),
		@ApiResponse (
				
				responseCode = "500",
				description ="An Error Occured"			
				)
	})
	@DeleteMapping("/delete_tool")
	public ResponseEntity<ResponseDto> deleteTool(@NotEmpty @RequestParam String toolsNumber){
		
		boolean isDeleted = iToolsService.deleteTools(toolsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(ToolsConstants.MESSAGE_200, ToolsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto (ToolsConstants.MESSAGE_500, ToolsConstants.STATUS_500));
	}
	
	
	@Operation (
			
			summary = "FETCH Build Information REST API",
			description = "REST API to Fetch Build Information for Parts and Tools Service"
			)
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(buildVersion);
		
	}
	
	@Operation (
			
			summary = "FETCH Java Version",
			description = "REST API to Fetch Java Version"
			)
	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(environment.getProperty("JAVA_HOME"));
		
	}
	
	@Operation (
			
			summary = "FETCH Java Version",
			description = "REST API to Fetch Java Version"
			)
	@GetMapping("/contact-info")
	public ResponseEntity<PartsAndToolsContactInfo> getConstactInfo(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(partsAndToolsContactInfo);
		
	}
}

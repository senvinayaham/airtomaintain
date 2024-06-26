package com.aircraft.maintenance.partsandtools.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author senthilvinayahammurugan
 *
 */
@Data 
@AllArgsConstructor
@Schema(
		name = "Error Response",
		description = "Schema to hold the Error Response"
	)
public class ErrorResponseDto {

	
	@Schema(
			description = "API Path that invoked by Client"
		)
	private String apiPath;
	
	@Schema(
			description = "Error Code in the Error Response"
		)
	private	HttpStatus errorCode;
	
	@Schema(
			description = "Error Message in the Error Response"
		)
	private String errorMsg;
	
	@Schema(
			description = "Error Date and Time in the Error Response"
		)
	private LocalDateTime errorDateTime;
}

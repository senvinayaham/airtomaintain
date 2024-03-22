package com.airtomaintain.maintenance.dto;

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
		name = "Response",
		description = "Schema to hold the Response information"
	)
public class ResponseDto {

	@Schema(
			description = "Status Code in the Response", example = "200"
		)
	private String statusCode;
	
	@Schema(
			description = "Status Message in the Response", example = "Request Successfully Processed"
		)
	private String statusMsg;
}

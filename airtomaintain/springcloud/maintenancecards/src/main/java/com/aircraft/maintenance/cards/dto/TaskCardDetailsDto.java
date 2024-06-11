/**
 * 
 */
package com.aircraft.maintenance.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author senthilvinayahammurugan
 *
 */

@Schema(
		name = "WorkCard Details",
		description = "Schema to hold the WorkCard, Parts and Tools Details information"
	)
	@Data
public class TaskCardDetailsDto {

	
	@Schema(
			description = "Description of the WorkCards", example = "Landing Gear"
		)
	@NotEmpty(message = "WorkCard Description cann't be null or empty")
	@Size(min=5, max=30, message="The length of the WorkCard Description should be between 5 and 100")
	private String workCardDescription;
	
	@Schema(
			description = "WorkCard Unique Number", example = "W00002"
		)
	@NotEmpty(message = "WrokCard Number cann't be null or empty")
	private String workCardNumber;


	@Schema(
			description = "Parts Details for WorkCard"
		)
	private PartsDto partsDto;
	
	@Schema(
			description = "Tools Details for WorkCard"
		)
	private ToolsDto toolsDto;
	
}

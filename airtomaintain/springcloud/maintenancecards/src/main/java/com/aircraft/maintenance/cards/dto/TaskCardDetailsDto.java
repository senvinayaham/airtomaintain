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
		name = "TaskCard Details",
		description = "Schema to hold the WorkCard, Parts and Tools Details information"
	)
	@Data
public class TaskCardDetailsDto {

	
	@Schema(
			description = "Description of the TaskCards", example = "Landing Gear"
		)
	@NotEmpty(message = "WorkCard Description cann't be null or empty")
	@Size(min=5, max=30, message="The length of the TaskCard Description should be between 5 and 100")
	private String taskCardDescription;
	
	@Schema(
			description = "TaskCard Unique Number", example = "T00002"
		)
	@NotEmpty(message = "TaskCard Number cann't be null or empty")
	private String taskCardNumber;


	@Schema(
			description = "Parts Details for TaskCard"
		)
	private PartsDto partsDto;
	
	@Schema(
			description = "Tools Details for TaskCard"
		)
	private ToolsDto toolsDto;
	
}

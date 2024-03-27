package com.aircraft.maintenance.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * @author senthilvinayahammurugan
 *
 */
@Data
@Schema(
		name = "TaskCards",
		description = "Schema to hold the TaskCards information"
	)
public class TaskCardsDto {


	@Schema(
			description = "Description of the TaskCard", example = "Landing Gear Tighten"
		)
	@NotEmpty(message = "TaskCard Description cann't be null or empty")
	@Size(min=5, max=30, message="The length of the Tool Name should be between 5 and 100")
	private String taskCardDescription;
	
	@Schema(
			description = "TaskCard Unique Number", example = "T00002"
		)
	@NotEmpty(message = "TaskCard Number cann't be null or empty")
	private String taskCardNumber;
	

}

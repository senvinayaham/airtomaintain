package com.aircraft.maintenance.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
	name = "WorkCards",
	description = "Schema to hold the WorkCards information"
)
@Data
public class WorkdCardsDto {
	
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


}

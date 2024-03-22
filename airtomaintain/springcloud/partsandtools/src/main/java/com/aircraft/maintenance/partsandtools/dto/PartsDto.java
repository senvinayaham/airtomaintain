package com.aircraft.maintenance.partsandtools.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
	name = "Parts",
	description = "Schema to hold the Parts information"
)
@Data
public class PartsDto {
	
	@Schema(
			description = "Parts Original Equipment Manufacturer", example = "MAA 02"
		)
	//@NotEmpty(message = "Part OEM cann't be null or empty")
	private int partsOem;
	
	@Schema(
			description = "Name of the Parts", example = "Landing Gear"
		)
	@NotEmpty(message = "Part Name cann't be null or empty")
	@Size(min=5, max=30, message="The length of the Part Name should be between 5 and 30")
	private String partsName;
	
	@Schema(
			description = "Parts Unique Number", example = "A00002"
		)
	@NotEmpty(message = "Part Number cann't be null or empty")
	private String partsNumber;
	
	@Schema(
			description = "Parts Manufacturer", example = "GE Aviation"
		)
	@NotEmpty(message = "Part Manufacture cann't be null or empty")
	private String partsMfn;
	
	@Schema(
			description = "Parts Quantity", example = "5"
		)
	//@NotEmpty(message = "Part Quantity cann't be null or empty")
	//@Pattern(regexp="(^$|[0-9] {3})", message = "Part Quantity cann't exeeds 100 and it accepts only digits")
	private int partsQty;

}

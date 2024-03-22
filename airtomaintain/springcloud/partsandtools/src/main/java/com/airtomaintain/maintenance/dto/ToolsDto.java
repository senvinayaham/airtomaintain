package com.airtomaintain.maintenance.dto;

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
		name = "Tools",
		description = "Schema to hold the Tools information"
	)
public class ToolsDto {

	@Schema(
			description = "Tool Original Equipment Manufacturer", example = "GE 02"
		)
	//@NotEmpty(message = "Tool OEM cann't be null or empty")
	private int toolsOem;
	
	@Schema(
			description = "Name of the Tool", example = "Landing Gear Tighten"
		)
	@NotEmpty(message = "Tool Name cann't be null or empty")
	@Size(min=5, max=30, message="The length of the Tool Name should be between 5 and 30")
	private String toolsName;
	
	@Schema(
			description = "Tools Unique Number", example = "T00002"
		)
	@NotEmpty(message = "Tool Number cann't be null or empty")
	private String toolsNumber;
	
	@Schema(
			description = "Tool's Manufacturer", example = "Honywell"
		)
	@NotEmpty(message = "Tool Manufacture cann't be null or empty")
	private String toolsMfn;
	
	@Schema(
			description = "Tools Quantity", example = "5"
		)
	//@NotEmpty(message = "Tool Quantity cann't be null or empty")
	//@Pattern(regexp="(^$|[0-9] {3})", message = "Tool Quantity cann't exeeds 100 and it accepts only digits")
	private int toolsQty;
}

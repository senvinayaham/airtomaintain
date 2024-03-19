package com.airtomaintain.maintenance.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * @author senthilvinayahammurugan
 *
 */
@Data
public class ToolsDto {

	//@NotEmpty(message = "Tool OEM cann't be null or empty")
	private int toolsOem;
	
	@NotEmpty(message = "Tool Name cann't be null or empty")
	@Size(min=5, max=30, message="The length of the Tool Name should be between 5 and 30")
	private String toolsName;
	
	@NotEmpty(message = "Tool Number cann't be null or empty")
	private String toolsNumber;
	
	@NotEmpty(message = "Tool Manufacture cann't be null or empty")
	private String toolsMfn;
	
	//@NotEmpty(message = "Tool Quantity cann't be null or empty")
	//@Pattern(regexp="(^$|[0-9] {3})", message = "Tool Quantity cann't exeeds 100 and it accepts only digits")
	private int toolsQty;
}

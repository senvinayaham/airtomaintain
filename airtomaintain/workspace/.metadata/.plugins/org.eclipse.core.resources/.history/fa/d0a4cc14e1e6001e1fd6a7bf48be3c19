package com.airtomaintain.maintenance.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PartsDto {
	
	//@NotEmpty(message = "Part OEM cann't be null or empty")
	private int partsOem;
	
	@NotEmpty(message = "Part Name cann't be null or empty")
	@Size(min=5, max=30, message="The length of the Part Name should be between 5 and 30")
	private String partsName;
	
	@NotEmpty(message = "Part Number cann't be null or empty")
	private String partsNumber;
	
	@NotEmpty(message = "Part Manufacture cann't be null or empty")
	private String partsMfn;
	
	//@NotEmpty(message = "Part Quantity cann't be null or empty")
	//@Pattern(regexp="(^$|[0-9] {3})", message = "Part Quantity cann't exeeds 100 and it accepts only digits")
	private int partsQty;

}

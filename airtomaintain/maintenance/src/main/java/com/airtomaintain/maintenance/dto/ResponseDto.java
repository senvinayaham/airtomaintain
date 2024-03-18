package com.airtomaintain.maintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author senthilvinayahammurugan
 *
 */
@Data 
@AllArgsConstructor
public class ResponseDto {

	private String statusCode;
	
	private String statusMsg;
}

/**
 * 
 */
package com.airtomaintain.maintenance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author senthilvinayahammurugan
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ToolsAlreadyExistsException extends RuntimeException{
	
	public ToolsAlreadyExistsException(String message) {
		super(message);
	}

}

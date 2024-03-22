/**
 * 
 */
package com.aircraft.maintenance.partsandtools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author senthilvinayahammurugan
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class PartsAlreadyExistsException extends RuntimeException{
	
	public PartsAlreadyExistsException(String message) {
		super(message);
	}

}

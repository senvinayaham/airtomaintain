/**
 * 
 */
package com.aircraft.maintenance.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author senthilvinayahammurugan
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class TaskCardAlreadyExistsException extends RuntimeException{
	
	public TaskCardAlreadyExistsException(String message) {
		super(message);
	}

}

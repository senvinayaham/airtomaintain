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

@ResponseStatus(value=HttpStatus.NOT_FOUND) 
public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		
		super(String.format("%s Not Found for given input data %s: '%s'",resourceName, fieldName, fieldValue));
		
	}

}

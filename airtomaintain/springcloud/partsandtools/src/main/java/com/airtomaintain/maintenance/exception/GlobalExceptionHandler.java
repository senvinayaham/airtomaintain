/**
 * 
 */
package com.airtomaintain.maintenance.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.airtomaintain.maintenance.dto.ErrorResponseDto;

/**
 * @author senthilvinayahammurugan
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, String> validationErrors = new HashMap<>();
		List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
		
		validationErrorList.forEach( (error) -> {

			String fieldName = ((FieldError)error).getField();
			String validationMessage = error.getDefaultMessage();
			validationErrors.put(fieldName, validationMessage);
		});
		
		return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception partsAlreadyExistsException, 
			WebRequest webRequest) {
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,
				partsAlreadyExistsException.getMessage(),
				LocalDateTime.now()
				);
				
		
		return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PartsAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handlePartsAlreadyExistsException(PartsAlreadyExistsException partsAlreadyExistsException, 
			WebRequest webRequest) {
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.BAD_REQUEST,
				partsAlreadyExistsException.getMessage(),
				LocalDateTime.now()
				);
				
		
		return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handlePartsAlreadyExistsException(ResourceNotFoundException resourceNotFoundException, 
			WebRequest webRequest) {
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.NOT_FOUND,
				resourceNotFoundException.getMessage(),
				LocalDateTime.now()
				);
				
		
		return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
	}
}

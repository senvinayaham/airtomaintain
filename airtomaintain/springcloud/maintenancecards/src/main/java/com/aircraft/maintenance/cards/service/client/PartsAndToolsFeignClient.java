/**
 * 
 */
package com.aircraft.maintenance.cards.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aircraft.maintenance.cards.dto.PartsDto;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author senthilvinayahammurugan
 *
 */
@FeignClient("partsandtools")
public interface PartsAndToolsFeignClient {

	@GetMapping(value="/api/v0/fetch_parts", consumes ="application/jason")
	public ResponseEntity<PartsDto> fetchParts(@NotEmpty @RequestParam String partsNumber);
	
	
}

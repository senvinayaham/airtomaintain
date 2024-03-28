/**
 * 
 */
package com.aircraft.maintenance.partsandtools.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aircraft.maintenance.partsandtools.dto.WorkdCardsDto;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author senthilvinayahammurugan
 *
 */

@FeignClient("cards")
public interface CardsFeignClient {

	@GetMapping(value="/api/v0/fetch_workcards", consumes ="application/jason")
	public ResponseEntity<WorkdCardsDto> fetchParts(@NotEmpty @RequestParam String partsNumber);
	
}

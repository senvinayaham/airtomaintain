/**
 * 
 */
package com.aircraft.maintenance.cards.service.client;

import org.springframework.http.ResponseEntity;

import com.aircraft.maintenance.cards.dto.PartsDto;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author senthilvinayahammurugan
 *
 */
public class PartsAndToolsFallback implements PartsAndToolsFeignClient {

	@Override
	public ResponseEntity<PartsDto> fetchParts(String correlationId, @NotEmpty String partsNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}

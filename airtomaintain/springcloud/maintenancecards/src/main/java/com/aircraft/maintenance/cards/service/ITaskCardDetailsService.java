/**
 * 
 */
package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.WorkCardDetailsDto;

/**
 * @author senthilvinayahammurugan
 *
 */



public interface ITaskCardDetailsService {

	
	WorkCardDetailsDto fetchTaskCardDetails(String correlationId, String workCardNumber);
}

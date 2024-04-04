/**
 * 
 */
package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.WorkCardDetailsDto;

/**
 * @author senthilvinayahammurugan
 *
 */



public interface IWorkCardDetailsService {

	
	WorkCardDetailsDto fetchWorkCardDetails(String correlationId, String workCardNumber);
}

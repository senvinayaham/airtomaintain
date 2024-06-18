/**
 * 
 */
package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.TaskCardDetailsDto;

/**
 * @author senthilvinayahammurugan
 *
 */



public interface ITaskCardDetailsService {

	
	TaskCardDetailsDto fetchTaskCardDetails(String correlationId, String workCardNumber);
}

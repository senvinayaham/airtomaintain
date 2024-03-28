package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.WorkCardsDto;

/**
 * @author senthilvinayahammurugan
 *
 */
public interface IWorkCardsService {

	/**
	 * @param WorkCardsDto - WorkCardsDto Object
	 *
	 */
	void createWorkCard(WorkCardsDto workCardsDto);
	
	/**
	 * @param String - workCardNumber
	 * @return WorkCardsDto - WorkCardsDto Object
	 */
	WorkCardsDto fetchWorkCard(String workCardNumber);

	/**
	 * @param WorkCardsDto - workCardsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateWorkCard(WorkCardsDto workCardsDto);

	/**
	 * @param String - workCardNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteWorkCard(String workCardNumber);

}

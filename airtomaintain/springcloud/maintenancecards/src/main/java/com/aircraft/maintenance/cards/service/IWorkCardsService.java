package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.WorkdCardsDto;

/**
 * @author senthilvinayahammurugan
 *
 */
public interface IWorkCardsService {

	/**
	 * @param WorkdCardsDto - WorkdCardsDto Object
	 *
	 */
	void createParts(WorkdCardsDto workdCardsDto);
	
	/**
	 * @param String - partsNumber
	 * @return WorkdCardsDto - WorkdCardsDto Object
	 */
	WorkdCardsDto fetchParts(String partsNumber);

	/**
	 * @param WorkdCardsDto - partsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateParts(WorkdCardsDto workdCardsDto);

	/**
	 * @param String - partsNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteParts(String partsNumber);

}

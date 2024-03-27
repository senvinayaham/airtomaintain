package com.aircraft.maintenance.cards.service;

import com.aircraft.maintenance.cards.dto.TaskCardsDto;

/**
 * @author senthilvinayahammurugan
 *
 */
public interface ITaskCardsService {
	
	/**
	 * @param TaskCardsDto - TaskCardsDto Object
	 *
	 */
	void createTools(TaskCardsDto taskCardsDto);
	
	/**
	 * @param String - toolsNumber
	 * @return WorkdCardsDto - TaskCardsDto Object
	 */
	TaskCardsDto fetchTools(String toolsNumber);

	/**
	 * @param TaskCardsDto - toolsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateTools(TaskCardsDto taskCardsDto);

	/**
	 * @param String - toolsNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteTools(String toolsNumber);

}

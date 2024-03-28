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
	void createTaskCard(TaskCardsDto taskCardsDto);
	
	/**
	 * @param String - taskCardNumber
	 * @return taskCardsDto - TaskCardsDto Object
	 */
	TaskCardsDto fetchTaskCard(String taskCardNumber);

	/**
	 * @param TaskCardsDto - toolsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateTaskCard(TaskCardsDto taskCardsDto);

	/**
	 * @param String - taskCardNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteTaskCard(String taskCardNumber);

}

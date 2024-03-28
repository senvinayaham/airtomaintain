/**
 * 
 */
package com.aircraft.maintenance.cards.mapper;

import com.aircraft.maintenance.cards.dto.WorkCardsDto;
import com.aircraft.maintenance.cards.dto.TaskCardsDto;
import com.aircraft.maintenance.cards.entity.TaskCards;

/**
 * @author senthilvinayahammurugan
 *
 */
public class TaskCardMapper {
	
	public static TaskCardsDto mapToToolsDto(TaskCardsDto taskCardsDto, TaskCards taskCards) {

		
		taskCardsDto.setTaskCardDescription(taskCards.getTaskCardDescription());
		
		taskCardsDto.setTaskCardNumber(taskCards.getTaskCardNumber());


		return taskCardsDto;
		
	}
	
	public static TaskCards mapToTools(TaskCardsDto taskCardsDto, TaskCards taskCards) {
		

		taskCards.setTaskCardDescription(taskCardsDto.getTaskCardDescription());
		
		taskCards.setTaskCardNumber(taskCardsDto.getTaskCardNumber());
		
		
		return taskCards;
		
	}
}

/**
 * 
 */
package com.aircraft.maintenance.cards.mapper;

import com.aircraft.maintenance.cards.dto.WorkdCardsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;

/**
 * @author senthilvinayahammurugan
 *
 */
public class WorkCardMapper {
	public static WorkdCardsDto mapToPartsDto(WorkdCardsDto workdCardsDto, WorkCards workCards) {
		

		workdCardsDto.setWorkCardDescription(workCards.getWorkCardDescription());
		
		workdCardsDto.setWorkCardNumber(workCards.getWorkCardNumber());
		
		return workdCardsDto;
		
	}
	
	public static WorkCards mapToParts(WorkCards workCards, WorkdCardsDto workdCardsDto) {
		

		workCards.setWorkCardDescription(workdCardsDto.getWorkCardDescription());
		
		workCards.setWorkCardNumber(workdCardsDto.getWorkCardNumber());

		return workCards;
	}

}

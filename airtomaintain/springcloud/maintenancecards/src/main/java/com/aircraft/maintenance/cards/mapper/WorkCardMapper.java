/**
 * 
 */
package com.aircraft.maintenance.cards.mapper;

import com.aircraft.maintenance.cards.dto.WorkCardDetailsDto;
import com.aircraft.maintenance.cards.dto.WorkCardsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;

/**
 * @author senthilvinayahammurugan
 *
 */
public class WorkCardMapper {
	public static WorkCardsDto mapToWorkCardDto(WorkCardsDto workdCardsDto, WorkCards workCards) {
		

		workdCardsDto.setWorkCardDescription(workCards.getWorkCardDescription());
		
		workdCardsDto.setWorkCardNumber(workCards.getWorkCardNumber());
		
		return workdCardsDto;
		
	}
	
	public static WorkCards mapToWorkCard(WorkCards workCards, WorkCardsDto workdCardsDto) {
		

		workCards.setWorkCardDescription(workdCardsDto.getWorkCardDescription());
		
		workCards.setWorkCardNumber(workdCardsDto.getWorkCardNumber());

		return workCards;
	}
	
	public static WorkCardDetailsDto mapToWorkCardDetailsDto(WorkCards workCards, WorkCardDetailsDto workCardDetailsDto) {
		

		workCardDetailsDto.setWorkCardDescription(workCards.getWorkCardDescription());
		workCardDetailsDto.setWorkCardNumber(workCards.getWorkCardNumber());

		return workCardDetailsDto;
	}
	

}

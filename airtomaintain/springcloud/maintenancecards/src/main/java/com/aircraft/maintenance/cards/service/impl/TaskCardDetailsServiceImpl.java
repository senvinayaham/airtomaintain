/**
 * 
 */
package com.aircraft.maintenance.cards.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aircraft.maintenance.cards.dto.PartsDto;
import com.aircraft.maintenance.cards.dto.WorkCardDetailsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;
import com.aircraft.maintenance.cards.exception.ResourceNotFoundException;
import com.aircraft.maintenance.cards.mapper.WorkCardMapper;
import com.aircraft.maintenance.cards.repository.WorkCardsRepository;
import com.aircraft.maintenance.cards.service.IWorkCardDetailsService;
import com.aircraft.maintenance.cards.service.client.PartsAndToolsFeignClient;

import lombok.AllArgsConstructor;

/**
 * @author senthilvinayahammurugan
 *
 */
@Service
@AllArgsConstructor
public class TaskCardDetailsServiceImpl implements IWorkCardDetailsService{

	
	private WorkCardsRepository workCardsRepository;
	private PartsAndToolsFeignClient partsAndToolsFeignClient;

	
	@Override
	public WorkCardDetailsDto fetchWorkCardDetails(String correlationId, String workCardNumber) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
				);
		
		 WorkCardDetailsDto workCardDetailsDto =WorkCardMapper.mapToWorkCardDetailsDto(workCards, new WorkCardDetailsDto());
		 ResponseEntity<PartsDto> partsDtoResponseEntity = partsAndToolsFeignClient.fetchParts(correlationId, workCardNumber);
		 
		 if(null != partsDtoResponseEntity)
			 workCardDetailsDto.setPartsDto(partsDtoResponseEntity.getBody());
		 
		 return workCardDetailsDto;
	}
}

/**
 * 
 */
package com.aircraft.maintenance.cards.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aircraft.maintenance.cards.dto.WorkCardsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;
import com.aircraft.maintenance.cards.exception.WorkCardAlreadyExistsException;
import com.aircraft.maintenance.cards.exception.ResourceNotFoundException;
import com.aircraft.maintenance.cards.mapper.WorkCardMapper;
import com.aircraft.maintenance.cards.repository.WorkCardsRepository;
import com.aircraft.maintenance.cards.repository.TaskCardsRepository;
import com.aircraft.maintenance.cards.service.IWorkCardsService;

import lombok.AllArgsConstructor;

/**
 * @author senthilvinayahammurugan
 *
 */
@Service
@AllArgsConstructor
public class WorkCardsServiceImpl implements IWorkCardsService{

	
	/**
	 * Autowiring
	 */
	
	private WorkCardsRepository workCardsRepository;
	
	@Override
	public void createWorkCard(WorkCardsDto workCardsDto) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = WorkCardMapper.mapToWorkCard(new WorkCards(), workCardsDto);
		Optional<WorkCards> optionalParts = workCardsRepository.findByWorkCardNumber(workCardsDto.getWorkCardNumber());
		if (optionalParts.isPresent())
			throw new WorkCardAlreadyExistsException("Given WorkCards:" + workCardsDto.getWorkCardNumber()+ " already exists");
		workCardsRepository.save(workCards);
	}

	@Override
	public WorkCardsDto fetchWorkCard(String workCardNumber) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
				);
				
		return WorkCardMapper.mapToWorkCardDto(new WorkCardsDto(), workCards);
	}

	@Override
	public boolean updateWorkCard(WorkCardsDto workCardsDto) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		if (workCardsDto!=null) {
		
			WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardsDto.getWorkCardNumber()).orElseThrow(
					() -> new ResourceNotFoundException("WorkCards", "PartsNumber", workCardsDto.getWorkCardNumber())
					);
			WorkCardMapper.mapToWorkCard(workCards, workCardsDto);
			workCardsRepository.save(workCards);
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteWorkCard(String workCardNumber) {
		// TODO Auto-generated method stub

		WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
				);
		workCardsRepository.deleteByWorkCardNumber(workCards.getWorkCardNumber());
		
		return true;
	}

	
}

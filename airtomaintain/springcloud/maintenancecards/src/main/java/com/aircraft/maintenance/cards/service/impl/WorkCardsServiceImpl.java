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

import com.aircraft.maintenance.cards.dto.WorkdCardsDto;
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
	public void createParts(WorkdCardsDto workdCardsDto) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = WorkCardMapper.mapToParts(new WorkCards(), workdCardsDto);
		Optional<WorkCards> optionalParts = workCardsRepository.findByWorkCardNumber(workdCardsDto.getWorkCardNumber());
		if (optionalParts.isPresent())
			throw new WorkCardAlreadyExistsException("Given WorkCards:" + workdCardsDto.getWorkCardNumber()+ " already exists");
		workCardsRepository.save(workCards);
	}

	@Override
	public WorkdCardsDto fetchParts(String workCardNumber) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
				);
				
		return WorkCardMapper.mapToPartsDto(new WorkdCardsDto(), workCards);
	}

	@Override
	public boolean updateParts(WorkdCardsDto workdCardsDto) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		if (workdCardsDto!=null) {
		
			WorkCards workCards = workCardsRepository.findByWorkCardNumber(workdCardsDto.getWorkCardNumber()).orElseThrow(
					() -> new ResourceNotFoundException("WorkCards", "PartsNumber", workdCardsDto.getWorkCardNumber())
					);
			WorkCardMapper.mapToParts(workCards, workdCardsDto);
			workCardsRepository.save(workCards);
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteParts(String workCardNumber) {
		// TODO Auto-generated method stub

		WorkCards workCards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
				);
		workCardsRepository.deleteByWorkCardNumber(workCards.getWorkCardNumber());
		
		return true;
	}

	
}

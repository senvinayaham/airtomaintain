/**
 * 
 */
package com.aircraft.maintenance.cards.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import com.aircraft.maintenance.cards.dto.CardsMessageDto;
import com.aircraft.maintenance.cards.dto.WorkCardsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;
import com.aircraft.maintenance.cards.exception.WorkCardAlreadyExistsException;
import com.aircraft.maintenance.cards.exception.ResourceNotFoundException;
import com.aircraft.maintenance.cards.mapper.WorkCardMapper;
import com.aircraft.maintenance.cards.repository.WorkCardsRepository;
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
	private static final Logger log = LoggerFactory.getLogger(WorkCardsServiceImpl.class);
	private WorkCardsRepository workCardsRepository;
	private final StreamBridge streamBridge;
	@Override
	public void createWorkCard(WorkCardsDto workCardsDto) {
		// TODO Auto-generated method stub
		
		WorkCards workCards = WorkCardMapper.mapToWorkCard(new WorkCards(), workCardsDto);
		Optional<WorkCards> optionalParts = workCardsRepository.findByWorkCardNumber(workCardsDto.getWorkCardNumber());
		if (optionalParts.isPresent())
			throw new WorkCardAlreadyExistsException("Given WorkCards:" + workCardsDto.getWorkCardNumber()+ " already exists");
		WorkCards savedWorkCards = workCardsRepository.save(workCards);
		sendCommunication(savedWorkCards);
	}

	
	private void sendCommunication(WorkCards workcards) {
		
		var cardsMessageDto = new CardsMessageDto(workcards.getWorkCardNumber(), workcards.getWorkCardDescription(), "cards@sample.com");
		log.info("Sending Communication request for the details: {}", cardsMessageDto);
		var result = streamBridge.send("sendCommunication-out-0", workcards);
		log.info("Sending communication request successfully triggered?: {}", result);
		
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


	@Override
	public boolean updateCommunicationStatus(String workCardNumber) {
		// TODO Auto-generated method stub
		boolean isUpdated=false;
		if(workCardNumber != null) {
			
			WorkCards workcards = workCardsRepository.findByWorkCardNumber(workCardNumber).orElseThrow(
					() -> new ResourceNotFoundException("WorkCards", "Work Card Number", workCardNumber)
					);
			
			workcards.setCommunicationSwitch(true);
			workCardsRepository.save(workcards);
			isUpdated = true;
		}
		
		return isUpdated;
	}

	
}

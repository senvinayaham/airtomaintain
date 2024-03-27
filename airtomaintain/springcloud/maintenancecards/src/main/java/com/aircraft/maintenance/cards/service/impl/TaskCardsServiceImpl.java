/**
 * 
 */
package com.aircraft.maintenance.cards.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aircraft.maintenance.cards.dto.WorkdCardsDto;
import com.aircraft.maintenance.cards.dto.TaskCardsDto;
import com.aircraft.maintenance.cards.entity.WorkCards;
import com.aircraft.maintenance.cards.entity.TaskCards;
import com.aircraft.maintenance.cards.exception.ResourceNotFoundException;
import com.aircraft.maintenance.cards.exception.TaskCardAlreadyExistsException;
import com.aircraft.maintenance.cards.mapper.WorkCardMapper;
import com.aircraft.maintenance.cards.mapper.TaskCardMapper;
import com.aircraft.maintenance.cards.repository.WorkCardsRepository;
import com.aircraft.maintenance.cards.repository.TaskCardsRepository;
import com.aircraft.maintenance.cards.service.ITaskCardsService;

import lombok.AllArgsConstructor;

/**
 * @author senthilvinayahammurugan
 *
 */
@Service
@AllArgsConstructor
public class TaskCardsServiceImpl implements ITaskCardsService{
	
	/**
	 * Autowiring
	 */
	
	
	private TaskCardsRepository taskCardsRepository;

	@Override
	public void createTools(TaskCardsDto taskCardsDto) {
		// TODO Auto-generated method stub
		
		TaskCards taskCards = TaskCardMapper.mapToTools(taskCardsDto, new TaskCards());
		Optional<TaskCards> optionalTools = taskCardsRepository.findByTaskCardNumber(taskCards.getTaskCardNumber());
		if(optionalTools.isPresent())
			throw new TaskCardAlreadyExistsException("Given Task Card Number" +taskCards.getTaskCardNumber()+ " already exists");
		taskCardsRepository.save(taskCards);
	}
	
	@Override
	public TaskCardsDto fetchTools(String taskCardNumber) {
		// TODO Auto-generated method stub
		
		TaskCards taskCards = taskCardsRepository.findByTaskCardNumber(taskCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("TaskCards", "TaskCardNumber", taskCardNumber)
				);
				
		return TaskCardMapper.mapToToolsDto(new TaskCardsDto(), taskCards);
	}

	@Override
	public boolean updateTools(TaskCardsDto taskCardsDto) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		if (taskCardsDto!=null) {
		
			TaskCards taskCards = taskCardsRepository.findByTaskCardNumber(taskCardsDto.getTaskCardNumber()).orElseThrow(
					() -> new ResourceNotFoundException("TaskCards", "TaskCardNumber", taskCardsDto.getTaskCardNumber())
					);
			TaskCardMapper.mapToTools(taskCardsDto, taskCards);
			taskCardsRepository.save(taskCards);
		isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteTools(String taskCardNumber) {
		// TODO Auto-generated method stub

		TaskCards taskCards = taskCardsRepository.findByTaskCardNumber(taskCardNumber).orElseThrow(
				() -> new ResourceNotFoundException("TaskCards", "TaskCardNumber", taskCardNumber)
				);
		taskCardsRepository.deleteByTaskCardNumber(taskCardNumber);
		
		
		return true;
	}

}

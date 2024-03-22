/**
 * 
 */
package com.aircraft.maintenance.partsandtools.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;
import com.aircraft.maintenance.partsandtools.dto.ToolsDto;
import com.aircraft.maintenance.partsandtools.entity.Parts;
import com.aircraft.maintenance.partsandtools.entity.Tools;
import com.aircraft.maintenance.partsandtools.exception.ResourceNotFoundException;
import com.aircraft.maintenance.partsandtools.exception.ToolsAlreadyExistsException;
import com.aircraft.maintenance.partsandtools.mapper.PartsMapper;
import com.aircraft.maintenance.partsandtools.mapper.ToolsMapper;
import com.aircraft.maintenance.partsandtools.repository.PartsRepository;
import com.aircraft.maintenance.partsandtools.repository.ToolsRepository;
import com.aircraft.maintenance.partsandtools.service.IToolsService;

import lombok.AllArgsConstructor;

/**
 * @author senthilvinayahammurugan
 *
 */
@Service
@AllArgsConstructor
public class ToolsServiceImpl implements IToolsService{
	
	/**
	 * Autowiring
	 */
	
	
	private ToolsRepository toolsRepository;

	@Override
	public void createTools(ToolsDto toolsDto) {
		// TODO Auto-generated method stub
		
		Tools tools = ToolsMapper.mapToTools(toolsDto, new Tools());
		Optional<Tools> optionalTools = toolsRepository.findByToolsNumber(tools.getToolsNumber());
		if(optionalTools.isPresent())
			throw new ToolsAlreadyExistsException("Given Tool number" +tools.getToolsNumber()+ " already exists with the Qty"+ tools.getToolsQty());
		toolsRepository.save(tools);
	}
	
	@Override
	public ToolsDto fetchTools(String toolsNumber) {
		// TODO Auto-generated method stub
		
		Tools tools = toolsRepository.findByToolsNumber(toolsNumber).orElseThrow(
				() -> new ResourceNotFoundException("Tools", "ToolsNumber", toolsNumber)
				);
				
		return ToolsMapper.mapToToolsDto(new ToolsDto(), tools);
	}

	@Override
	public boolean updateTools(ToolsDto toolsDto) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		if (toolsDto!=null) {
		
			Tools tools = toolsRepository.findByToolsNumber(toolsDto.getToolsNumber()).orElseThrow(
					() -> new ResourceNotFoundException("Tools", "ToolsNumber", toolsDto.getToolsNumber())
					);
			ToolsMapper.mapToTools(toolsDto, tools);
			toolsRepository.save(tools);
		isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteTools(String toolsNumber) {
		// TODO Auto-generated method stub

		Tools tools = toolsRepository.findByToolsNumber(toolsNumber).orElseThrow(
				() -> new ResourceNotFoundException("Tools", "ToolsNumber", toolsNumber)
				);
		toolsRepository.deleteByToolsNumber(toolsNumber);
		
		
		return true;
	}

}

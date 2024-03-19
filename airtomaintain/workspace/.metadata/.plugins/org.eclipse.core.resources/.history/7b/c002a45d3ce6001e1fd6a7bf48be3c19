/**
 * 
 */
package com.airtomaintain.maintenance.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.airtomaintain.maintenance.dto.PartsDto;
import com.airtomaintain.maintenance.dto.ToolsDto;
import com.airtomaintain.maintenance.entity.Parts;
import com.airtomaintain.maintenance.entity.Tools;
import com.airtomaintain.maintenance.exception.ResourceNotFoundException;
import com.airtomaintain.maintenance.exception.ToolsAlreadyExistsException;
import com.airtomaintain.maintenance.mapper.PartsMapper;
import com.airtomaintain.maintenance.mapper.ToolsMapper;
import com.airtomaintain.maintenance.repository.PartsRepository;
import com.airtomaintain.maintenance.repository.ToolsRepository;
import com.airtomaintain.maintenance.service.IToolsService;

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
		tools.setCreatedAt(LocalDateTime.now());
		tools.setCreatedBy("Anonymous");
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

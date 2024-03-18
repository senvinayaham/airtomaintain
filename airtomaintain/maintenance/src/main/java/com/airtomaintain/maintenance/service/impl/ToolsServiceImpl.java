/**
 * 
 */
package com.airtomaintain.maintenance.service.impl;

import org.springframework.stereotype.Service;

import com.airtomaintain.maintenance.dto.ToolsDto;
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
	
	private PartsRepository partsReporsitory;
	
	private ToolsRepository toolsRepository;

	@Override
	public void createTools(ToolsDto toolsDto) {
		// TODO Auto-generated method stub
		
	}

}

package com.airtomaintain.maintenance.service;

import com.airtomaintain.maintenance.dto.ToolsDto;

/**
 * @author senthilvinayahammurugan
 *
 */
public interface IToolsService {
	
	/**
	 * @param ToolsDto - ToolsDto Object
	 *
	 */
	void createTools(ToolsDto toolsDto);
	
	/**
	 * @param String - toolsNumber
	 * @return PartsDto - ToolsDto Object
	 */
	ToolsDto fetchTools(String toolsNumber);

}

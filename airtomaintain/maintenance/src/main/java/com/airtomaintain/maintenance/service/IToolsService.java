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

	/**
	 * @param ToolsDto - toolsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateTools(ToolsDto toolsDto);

	/**
	 * @param String - toolsNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteTools(String toolsNumber);

}

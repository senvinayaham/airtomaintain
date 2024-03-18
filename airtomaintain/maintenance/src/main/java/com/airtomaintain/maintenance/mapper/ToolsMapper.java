/**
 * 
 */
package com.airtomaintain.maintenance.mapper;

import com.airtomaintain.maintenance.dto.PartsDto;
import com.airtomaintain.maintenance.dto.ToolsDto;

import com.airtomaintain.maintenance.entity.Tools;

/**
 * @author senthilvinayahammurugan
 *
 */
public class ToolsMapper {
	
	public static ToolsDto mapToToolsDto(ToolsDto toolsDto, Tools tools) {
		
		toolsDto.setToolsOem(tools.getToolsOem());
		
		toolsDto.setToolsMfn(tools.getToolsMfn());
		
		toolsDto.setToolsName(tools.getToolsName());
		
		toolsDto.setToolsNumber(tools.getToolsNumber());
		
		toolsDto.setToolsQty(tools.getToolsQty());

		return toolsDto;
		
	}
	
	public static Tools mapToTools(ToolsDto toolsDto, Tools tools) {
		
		tools.setToolsOem(toolsDto.getToolsOem());
		
		tools.setToolsMfn(toolsDto.getToolsMfn());
		
		tools.setToolsName(toolsDto.getToolsName());
		
		tools.setToolsNumber(toolsDto.getToolsNumber());
		
		tools.setToolsQty(toolsDto.getToolsQty());
		
		return tools;
		
	}
}
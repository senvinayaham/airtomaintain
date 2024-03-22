/**
 * 
 */
package com.aircraft.maintenance.partsandtools.mapper;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;
import com.aircraft.maintenance.partsandtools.dto.ToolsDto;
import com.aircraft.maintenance.partsandtools.entity.Tools;

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

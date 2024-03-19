package com.airtomaintain.maintenance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airtomaintain.maintenance.constants.PartsConstants;
import com.airtomaintain.maintenance.constants.ToolsConstants;
import com.airtomaintain.maintenance.dto.PartsDto;
import com.airtomaintain.maintenance.dto.ResponseDto;
import com.airtomaintain.maintenance.dto.ToolsDto;
import com.airtomaintain.maintenance.entity.Parts;
import com.airtomaintain.maintenance.entity.Tools;
import com.airtomaintain.maintenance.service.IPartsService;
import com.airtomaintain.maintenance.service.IToolsService;

import lombok.AllArgsConstructor;
/**
 * @author senthilvinayahammurugan
 *
 */
@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class MaintenanceController {

	private IPartsService iPartsService;
	private IToolsService iToolsService;
	
	@PostMapping("/create_parts")
	public ResponseEntity<ResponseDto> createParts(@RequestBody PartsDto partsDto){
		
		iPartsService.createParts(partsDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(PartsConstants.MESSAGE_201, PartsConstants.STATUS_201));
		
	}

	@PostMapping("/create_tools")
	public ResponseEntity<ResponseDto> createTools(@RequestBody ToolsDto toolsDto){
		
		iToolsService.createTools(toolsDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(ToolsConstants.MESSAGE_201, ToolsConstants.STATUS_201));
		
	}
	@GetMapping("/fetch_parts")
	public ResponseEntity<PartsDto> fetchParts(@RequestParam String partsNumber){
		
		PartsDto partsDto = iPartsService.fetchParts(
				partsNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(partsDto);
		
	}

	@GetMapping("/fetch_tools")
	public ResponseEntity<
	ToolsDto> fetchTools(@RequestParam String toolsNumber){
		
		ToolsDto toolsDto = iToolsService.fetchTools(toolsNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(toolsDto);
		
	}
	@PutMapping("/update_parts")
	public ResponseEntity<ResponseDto> updateParts(@RequestBody PartsDto partsDto){
		
		boolean isUpdated = iPartsService.updateParts(partsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(PartsConstants.MESSAGE_200, PartsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(PartsConstants.MESSAGE_500, PartsConstants.STATUS_500));

	}
	
	
	@PutMapping("/update_tools")
	public ResponseEntity<ResponseDto> updateTools(@RequestBody ToolsDto toolsDto){
		
		
		boolean isUpdated = iToolsService.updateTools(toolsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(ToolsConstants.MESSAGE_200, ToolsConstants.STATUS_200));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(ToolsConstants.MESSAGE_500, ToolsConstants.STATUS_500));

	}
	
	@DeleteMapping("/delete_part")
	public ResponseEntity<ResponseDto> deletePart(@RequestParam String partsNumber){
		
		boolean isDeleted = iPartsService.deleteParts(partsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(PartsConstants.MESSAGE_200, PartsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(PartsConstants.MESSAGE_500, PartsConstants.STATUS_500));
	}
	
	@DeleteMapping("/delete_tool")
	public ResponseEntity<ResponseDto> deleteTool(@RequestParam String toolsNumber){
		
		boolean isDeleted = iToolsService.deleteTools(toolsNumber);
		if(isDeleted) {
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(ToolsConstants.MESSAGE_200, ToolsConstants.STATUS_200));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto (ToolsConstants.MESSAGE_500, ToolsConstants.STATUS_500));
	}
}

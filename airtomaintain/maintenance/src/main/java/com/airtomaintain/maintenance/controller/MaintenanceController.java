package com.airtomaintain.maintenance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtomaintain.maintenance.constants.PartsConstants;
import com.airtomaintain.maintenance.dto.PartsDto;
import com.airtomaintain.maintenance.dto.ResponseDto;

@RestController
@RequestMapping(path="/api/v0", produces= {MediaType.APPLICATION_JSON_VALUE})
public class MaintenanceController {

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createParts(@RequestBody PartsDto partsDto){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(PartsConstants.MESSAGE_201, PartsConstants.STATUS_201));
		
	}

}

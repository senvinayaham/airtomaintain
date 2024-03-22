/**
 * 
 */
package com.aircraft.maintenance.partsandtools.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;
import com.aircraft.maintenance.partsandtools.entity.Parts;
import com.aircraft.maintenance.partsandtools.exception.PartsAlreadyExistsException;
import com.aircraft.maintenance.partsandtools.exception.ResourceNotFoundException;
import com.aircraft.maintenance.partsandtools.mapper.PartsMapper;
import com.aircraft.maintenance.partsandtools.repository.PartsRepository;
import com.aircraft.maintenance.partsandtools.repository.ToolsRepository;
import com.aircraft.maintenance.partsandtools.service.IPartsService;

import lombok.AllArgsConstructor;

/**
 * @author senthilvinayahammurugan
 *
 */
@Service
@AllArgsConstructor
public class PartsServiceImpl implements IPartsService{

	
	/**
	 * Autowiring
	 */
	
	private PartsRepository partsRepository;
	
	@Override
	public void createParts(PartsDto partsDto) {
		// TODO Auto-generated method stub
		
		Parts parts = PartsMapper.mapToParts(new Parts(), partsDto);
		Optional<Parts> optionalParts = partsRepository.findByPartsNumber(partsDto.getPartsNumber());
		if (optionalParts.isPresent())
			throw new PartsAlreadyExistsException("Given Parts:" + partsDto.getPartsNumber()+ " already exist in the System with Qty:"+partsDto.getPartsQty());
		partsRepository.save(parts);
	}

	@Override
	public PartsDto fetchParts(String partsNumber) {
		// TODO Auto-generated method stub
		
		Parts parts = partsRepository.findByPartsNumber(partsNumber).orElseThrow(
				() -> new ResourceNotFoundException("Parts", "PartsNumber", partsNumber)
				);
				
		return PartsMapper.mapToPartsDto(new PartsDto(), parts);
	}

	@Override
	public boolean updateParts(PartsDto partsDto) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		if (partsDto!=null) {
		
			Parts parts = partsRepository.findByPartsNumber(partsDto.getPartsNumber()).orElseThrow(
					() -> new ResourceNotFoundException("Parts", "PartsNumber", partsDto.getPartsNumber())
					);
			PartsMapper.mapToParts(parts, partsDto);
			partsRepository.save(parts);
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteParts(String partsNumber) {
		// TODO Auto-generated method stub

		Parts parts = partsRepository.findByPartsNumber(partsNumber).orElseThrow(
				() -> new ResourceNotFoundException("Parts", "PartsNumber", partsNumber)
				);
		partsRepository.deleteByPartsNumber(parts.getPartsNumber());
		
		return true;
	}

	
}

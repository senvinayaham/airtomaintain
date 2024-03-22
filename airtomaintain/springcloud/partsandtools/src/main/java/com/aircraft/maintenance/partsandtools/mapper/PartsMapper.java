/**
 * 
 */
package com.aircraft.maintenance.partsandtools.mapper;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;
import com.aircraft.maintenance.partsandtools.entity.Parts;

/**
 * @author senthilvinayahammurugan
 *
 */
public class PartsMapper {
	public static PartsDto mapToPartsDto(PartsDto partsDto, Parts parts) {
		
		partsDto.setPartsOem(parts.getPartsOem());
		
		partsDto.setPartsMfn(parts.getPartsMfn());
		
		partsDto.setPartsName(parts.getPartsName());
		
		partsDto.setPartsNumber(parts.getPartsNumber());
		
		partsDto.setPartsQty(parts.getPartsQty());

		return partsDto;
		
	}
	
	public static Parts mapToParts(Parts parts, PartsDto partsDto) {
		
		parts.setPartsOem(partsDto.getPartsOem());
		
		parts.setPartsMfn(partsDto.getPartsMfn());
		
		parts.setPartsName(partsDto.getPartsName());
		
		parts.setPartsNumber(partsDto.getPartsNumber());
		
		parts.setPartsQty(partsDto.getPartsQty());
		
		return parts;
	}

}

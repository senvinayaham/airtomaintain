package com.airtomaintain.maintenance.service;

import com.airtomaintain.maintenance.dto.PartsDto;

/**
 * @author senthilvinayahammurugan
 *
 */
public interface IPartsService {

	/**
	 * @param PartsDto - PartsDto Object
	 *
	 */
	void createParts(PartsDto partsDto);
	
	/**
	 * @param String - partsNumber
	 * @return PartsDto - PartsDto Object
	 */
	PartsDto fetchParts(String partsNumber);
}

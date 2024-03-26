package com.aircraft.maintenance.partsandtools.service;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;

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

	/**
	 * @param PartsDto - partsDto
	 * @return boolean - True/False based on the update status
	 */
	boolean updateParts(PartsDto partsDto);

	/**
	 * @param String - partsNumber
	 * @return boolean - True/False based on the update status
	 */
	boolean deleteParts(String partsNumber);

}
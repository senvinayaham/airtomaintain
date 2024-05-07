package com.aircraft.maintenance.partsandtools.service;

import java.util.concurrent.CompletableFuture;

import com.aircraft.maintenance.partsandtools.dto.PartsDto;
import com.aircraft.maintenance.partsandtools.entity.Parts;

import graphql.schema.DataFetcher;

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

	
	/**
	 * @param String - partsNumber
	 * @return Parts - Parts Object
	 */
	DataFetcher<CompletableFuture<Parts>> getPart();
	
}

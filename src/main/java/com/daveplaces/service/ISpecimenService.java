package com.daveplaces.service;

import com.daveplaces.dto.SpecimenDTO;

/**
 * CRUD operations for specimens
 * @author david
 *
 */
public interface ISpecimenService {

	/**
	 * Get specimen from persistance layer
	 * @param id a unique lookup
	 * @return a specimen with a matching id
	 */
	SpecimenDTO fetchById(int id);
	
	/**
	 * Save a DTO to the persistance layer
	 * @param specimenDTO
	 */
	void save(SpecimenDTO specimenDTO);

}
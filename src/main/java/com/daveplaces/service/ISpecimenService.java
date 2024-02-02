package com.daveplaces.service;

import java.util.List;

import com.daveplaces.dto.PlantDTO;
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

	/** 
	 * Return a list of plants that contain this String
	 * @param string the search criteria: can be genus, species, cultivar or common.
	 * @return a list of matching plants
	 */
	List<PlantDTO> fetchPlants(String string);

}
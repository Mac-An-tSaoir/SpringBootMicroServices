package com.daveplaces.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.daveplaces.dao.ISpecimenDAO;
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
	boolean save(SpecimenDTO specimenDTO) throws Exception;

	/** 
	 * Return a list of plants that contain this String
	 * @param string the search criteria: can be genus, species, cultivar or common.
	 * @return a list of matching plants
	 */
	List<PlantDTO> fetchPlants(String string) throws Exception;

	void setSpecimenDAO(ISpecimenDAO specimenDAO);

	ISpecimenDAO getSpecimenDAO();

	Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception;

	void saveImage(MultipartFile imageFile) throws Exception;

}
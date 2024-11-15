package com.daveplaces.dao;

import java.util.List;

import com.daveplaces.dto.SpecimenDTO;

public interface ISpecimenDAO {
	
	boolean save(SpecimenDTO specimenDTO) throws Exception;

	Iterable<SpecimenDTO> fetchAll() throws Exception;

	List<SpecimenDTO> fetchSpecimensByPlantId(int plantId);

}

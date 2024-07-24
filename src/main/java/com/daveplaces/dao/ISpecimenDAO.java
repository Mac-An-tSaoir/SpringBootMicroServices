package com.daveplaces.dao;

import com.daveplaces.dto.SpecimenDTO;

public interface ISpecimenDAO {
	
	boolean save(SpecimenDTO specimenDTO) throws Exception;

	Iterable<SpecimenDTO> fetchAll() throws Exception;

}

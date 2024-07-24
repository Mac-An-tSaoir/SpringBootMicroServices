package com.daveplaces.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daveplaces.dto.SpecimenDTO;

@Component
public class SpecimenDAO implements ISpecimenDAO {

	@Autowired
	SpecimenRepository specimenRepository;
	
	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		specimenRepository.save(specimenDTO);
		return false;
	}
	
	@Override
	public Iterable<SpecimenDTO> fetchAll() throws Exception {
		return specimenRepository.findAll();
	}

}

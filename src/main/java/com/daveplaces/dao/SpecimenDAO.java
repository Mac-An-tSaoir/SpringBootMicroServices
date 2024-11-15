package com.daveplaces.dao;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	//was getting nulls returned with the valid specimens
	public List<SpecimenDTO> fetchSpecimensByPlantId(int plantId) {
		List<SpecimenDTO> specimens = specimenRepository.findByPlantId(plantId);
		List<SpecimenDTO> cleanListOfSpecimens = new ArrayList<SpecimenDTO>();
		return specimens;
	}

}

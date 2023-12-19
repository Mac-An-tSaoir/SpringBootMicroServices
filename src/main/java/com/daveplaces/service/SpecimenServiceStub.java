package com.daveplaces.service;

import org.springframework.stereotype.Component;

import com.daveplaces.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	@Override
	public SpecimenDTO fetchById(int id) {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(43);
		specimenDTO.setLatitude("52.668");
		specimenDTO.setLongitude("-8.630");
		specimenDTO.setDescription("A Whitethorn tree");
		return specimenDTO;
	}
	
	@Override
	public void save(SpecimenDTO specimenDTO) {
		
	}

}

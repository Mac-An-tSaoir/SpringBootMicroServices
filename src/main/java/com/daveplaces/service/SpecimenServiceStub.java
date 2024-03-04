package com.daveplaces.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;

//to deal with trouble in v33 and save() method


@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	//@Autowired
	private ISpecimenDAO specimenDAO;
	
	
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
	public boolean save(SpecimenDTO specimenDTO) {
		//specimenDAO is mocked in the Test class, can't mock it here.
		System.out.println("Stub's specimenDAO object: "+specimenDAO);
		System.out.println("Stub's save() parameter "+specimenDTO+"\n");
		boolean result = false;
		
		try {
			result = specimenDAO.save(specimenDTO);
		} catch (Exception ex) {
			System.out.println("Stub's save() "+ex);
		}
		System.out.println("\n save's result: "+result);
		return result;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {
		// stub out a plant fetch mechanism
		List<PlantDTO> matchingPlants = new ArrayList<PlantDTO>();
		
		if (searchTerm.contains("edbud") || searchTerm.contains("cersis")) {
			PlantDTO plant = new PlantDTO();
			plant.setGenus("Cersis");
			plant.setSpecies("canadensis");
			plant.setCommon("Eastern Redbud");
			//plant.setCultivar("---");
			matchingPlants.add(plant); 
		}
		return matchingPlants;
	}

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		return specimenDAO;
	}

	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		System.out.println("\nStub: set specimenDAO "+ specimenDAO.toString());
		this.specimenDAO = specimenDAO;
	}

}

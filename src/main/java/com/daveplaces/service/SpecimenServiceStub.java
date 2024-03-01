package com.daveplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;

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
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		boolean result = specimenDAO.save(specimenDTO);
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
		this.specimenDAO = specimenDAO;
	}

}

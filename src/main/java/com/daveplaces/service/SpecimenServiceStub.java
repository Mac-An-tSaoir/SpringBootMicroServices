package com.daveplaces.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PhotoDTO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;



//to deal with trouble in v33 and save() method


@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	//@Autowired//different to v33, this is commmented out.
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
		//specimenDAO is mocked in the Test class, have to repeat it here...
		boolean result = false;
		
		try {
			System.out.println("Stub's DAO object: "+specimenDAO);
			//System.out.println("Stub's specimenDTO id    : "+specimenDTO.getSpecimenId()+"\n");
			
			result = specimenDAO.save(specimenDTO);
		} catch (Exception ex) {
			System.out.println("Stub's save() "+ex);
		}
		System.out.println("Stub's save() result: "+result+"\n");
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
		System.out.println("\nStub: setSpecimenDAO():: "+ specimenDAO.toString());
		this.specimenDAO = specimenDAO;
	}

	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

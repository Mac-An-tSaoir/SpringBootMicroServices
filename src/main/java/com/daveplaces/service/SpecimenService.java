package com.daveplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daveplaces.dao.IPlantDAO;
import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;

@Component
public class SpecimenService implements ISpecimenService {

	@Autowired
	IPlantDAO plantDAO;
	
	@Autowired
	ISpecimenDAO specimenDAO;
	
	@Override
	public SpecimenDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		specimenDAO.save(specimenDTO);
		return false;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception{
		// TODO Auto-generated method stub
		return plantDAO.fetch(searchTerm);
		
	}
	
	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception{
		return specimenDAO.fetchAll();
	}

	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

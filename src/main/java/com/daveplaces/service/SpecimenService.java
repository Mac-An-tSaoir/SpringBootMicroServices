package com.daveplaces.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
	@Cacheable("fetchPlants")
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

	@Override
	public void saveImage(MultipartFile imageFile) throws Exception {
		String folder = "/Users/david/Documents/Barcode/Cincinnati/photos/";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		
	}
	
	

}
